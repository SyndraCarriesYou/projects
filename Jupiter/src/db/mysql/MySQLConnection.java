package db.mysql;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import db.DBConnection;
import entity.Item;
import entity.Item.ItemBuilder;
import external.TicketMasterAPI;

public class MySQLConnection implements DBConnection {

	private Connection conn;
	// private PreparedStatement saveItemStmt;

//	private PreparedStatement saveItemStmt() {
//		try {
//			if (saveItemStmt == null) {
//				if (conn == null) {
//					System.err.println("DB Connection Failed!");
//					return null;
//				}
//				saveItemStmt = conn.prepareStatement("INSERT IGNORE INTO items VALUES (?, ?, ?, ?, ?, ?, ?)");
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		return saveItemStmt;
//	}

	public MySQLConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn = DriverManager.getConnection(MySQLDBUtil.URL);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void close() {
		if (conn != null) {
			try {
				conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void setFavoriteItems(String userId, List<String> itemIds) {
		if (conn == null) {
			System.err.println("DB connection failed!");
			return;
		}
		
		try {
			// why do need specify the row 
			String sql = "INSERT IGNORE INTO history (user_id, item_id) VALUES (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			for (String itemId : itemIds) {
				stmt.setString(2, itemId);
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}


	}

	@Override
	public void unsetFavoriteItems(String userId, List<String> itemIds) {
		if (conn == null) {
			System.err.println("DB connection failed!");
			return;
		}
		
		try {
			String sql = "DELETE FROM history WHERE user_id = ? AND item_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			for (String itemId : itemIds) {
				stmt.setString(2, itemId);
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Set<String> getFavoriteItemIds(String userId) {
		if (conn == null) {
			return new HashSet<>();
		}
		
		Set<String> favoriteItemIds = new HashSet<>();
		
		try {
			String sql = "SELECT item_id FROM history WHERE user_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			while (rs.next()) {
				String itemId = rs.getString("item_id");
				favoriteItemIds.add(itemId);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return favoriteItemIds;

	}

	@Override
	public Set<Item> getFavoriteItems(String userId) {
		if (conn == null) {
			System.err.println("DB connection failed!");
			return new HashSet<>();
		}
		
		Set<Item> favoriteItems = new HashSet<>();
		Set<String> itemIds = getFavoriteItemIds(userId);
		
		try {
			String sql = "SELECT * FROM items WHERE item_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			for (String itemId : itemIds) {
				stmt.setString(1, itemId);
				
				//需要查询结果出来 所以使用resultset
				ResultSet rs = stmt.executeQuery();
				
				ItemBuilder builder = new ItemBuilder();
				
				// 指针最开始在-1的位置 所以先callnext
				// 在这个method内可以用if 代替 while 但是一般默认rs return 多个值
				while (rs.next()) {
					builder.setItemId(rs.getString("item_id"));
					builder.setName(rs.getString("name"));
					builder.setAddress(rs.getString("address"));
					builder.setImageUrl(rs.getString("image_url"));
					builder.setUrl(rs.getString("url"));
					builder.setCategories(getCategories(itemId));
					builder.setRating(rs.getDouble("rating"));
					builder.setDistance(rs.getDouble("distance"));
					
					favoriteItems.add(builder.build());
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return favoriteItems;

	}

	@Override
	public Set<String> getCategories(String itemId) {
		if (conn == null) {
			System.err.println("DB connection failed!");
			return null;
		}
		
		Set<String> categories = new HashSet<>();
		
		try {
			String sql = "SELECT category FROM categories WHERE item_id = ? ";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, itemId);
			
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				categories.add(rs.getString("category"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return categories;

	}

	@Override
	/**
	 * save the searched items for favorite function later use
	 */
	public List<Item> searchItems(double lat, double lon, String term) {
		TicketMasterAPI tmAPI = new TicketMasterAPI();
		List<Item> items = tmAPI.search(lat, lon, term);
		for (Item item : items) {
			saveItem(item);
		}
		return items;

	}

	@Override
	public void saveItem(Item item) {
		if (conn == null) {
			System.err.println("DB connection failed!");
			return;
		}

		try {
			// to avoid inserting the same item
			// to avoid invalid input SQL Injection

			// SQL Injection
			// Example:
			// SELECT * FROM users WHERE username = '<username>' AND password = '<password>'
			// version 1
			// username: aoweifapweofj' OR 1=1 --
			// password: joaiefjajfaow
			// ->
			// SELECT * FROM users WHERE username = 'aoweifapweofj' OR 1=1 --' AND password
			// = 'joaiefjajfaow'
			// version 2
			// username: oiaejofijaw
			// password: awjeofaiwjefowai' OR '1' = '1
			// ->
			// SELECT * FROM users WHERE username = 'oiaejofijaw' AND password =
			// 'awjeofaiwjefowai' OR '1' = '1'

			// prepareStatement 在复用的时候效率更高
			// singleton
			String sql = "INSERT IGNORE INTO items VALUES (?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, item.getItemId());
			stmt.setString(2, item.getName());
			stmt.setDouble(3, item.getRating());
			stmt.setString(4, item.getAddress());
			stmt.setString(5, item.getImageUrl());
			stmt.setString(6, item.getUrl());
			stmt.setDouble(7, item.getDistance());
			stmt.execute();

			sql = "INSERT IGNORE INTO categories VALUES (?, ?)";

			stmt = conn.prepareStatement(sql);
			stmt.setString(1, item.getItemId());
			for (String category : item.getCategories()) {
				stmt.setString(2, category);
				stmt.execute();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	/**
	 * has been tested in doPost ItemHistory.java 
	 */
	public String getFullname(String userId) {
		if(conn == null) {
			System.err.println("DB Connection failed!");
			return null; 
		}
		String name = "";
		try {
			String sql = "SELECT first_name, last_name FROM users where user_id = ?";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, userId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				name = String.join(" ", rs.getString("first_name"), rs.getString("last_name"));
			}
			
		} catch(SQLException e){
			e.printStackTrace();
		}
		return name; 
		
	}

	@Override
	/**
	 * has been tested in doPost ItemHistory.java 
	 */
	public boolean verifyLogin(String userId, String password) {
		if (conn == null) {
			return false;
		}
		try {
			String sql = "SELECT user_id from users WHERE user_id = ? and password = ?";
			PreparedStatement statement = conn.prepareStatement(sql);
			statement.setString(1, userId);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;

	}

}