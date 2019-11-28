package db;

import db.mysql.MySQLConnection;

/**
 * The factory to create different database instances.
 * Use the same interface for different database. 
 * The Default DB is mysql. 
 * 
 * @author Wenwen Zheng
 *
 */
public class DBConnectionFactory {
	
	// This constant should be changed based on the pipeline used.
	private static final String DEFAULT_DB = "mysql";
	
	/**
	 * Create a DBConnection of selected database
	 * 
	 * @param db The name of the database used 
	 * @return DBConnection of selected database
	 */
	public static DBConnection getConnection(String db) {
		switch (db) {
		case "mysql":
			return new MySQLConnection();
			
		case "mongodb":
			// return new MongoDBConnection();
			return null;
		default:
			throw new IllegalArgumentException("Invalid db: " + db);
		}
	}
	
	/**
	 * Create a default DBConnection
	 * 
	 * @return a default DBConnection
	 */
	public static DBConnection getConnection() {
		return getConnection(DEFAULT_DB);
	}

}
