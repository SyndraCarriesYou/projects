package rpc;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import db.DBConnection;
import db.DBConnectionFactory;
import entity.Item;
import external.TicketMasterAPI;

/**
 * Servlet implementation class SearchItem
 */
@WebServlet("/search")
public class SearchItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchItem() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//      return text		
//	    PrintWriter out = response.getWriter();
//	    if(request.getParameter("username") != null) {
//	    	String username = request.getParameter("username");
//	    	out.print("Hello " + username);
//	    }
//	    out.close();
		

//      return HTML page
//		response.setContentType("text/html");
//		PrintWriter out = response.getWriter();
//		out.println("<html><body>");
//		out.println("<h1>This is a HTML page</h1>");
//		out.println("</body></html>");
//		
//		out.close();
		
//      return a JSON object		
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		
//		String username = "";
//		if (request.getParameter("username") != null) {
//			username = request.getParameter("username");
//		}
//		JSONObject obj = new JSONObject();
//		try {
//			obj.put("username", username);
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		out.print(obj);
//		out.close();
		
//      return a list of usernames

// 		before implementing rpcHelper
//		response.setContentType("application/json");
//		PrintWriter out = response.getWriter();
//		out.print(array);
//		out.close();		
		
// 		after implementing rpcHelper
//		JSONArray array = new JSONArray();
//		try {
//			array.put(new JSONObject().put("username", "abcd"));
//			array.put(new JSONObject().put("username", "1234"));
//		} catch (JSONException e) {
//			e.printStackTrace();
//		}
//		RpcHelper.writeJsonArray(response, array);
		
		
		//get the lat and lon from the request 
		double lat = Double.parseDouble(request.getParameter("lat"));
		double lon = Double.parseDouble(request.getParameter("lon"));
		
		// term can be empty
		String term = request.getParameter("term");
		String userId = request.getParameter("user_id");
		
		// sevlet 每次都是重新创建 
		// 所以 connection每次也都会重新创建 不需要优化
		DBConnection connection = DBConnectionFactory.getConnection();
		try {
			List<Item> items = connection.searchItems(lat, lon, term);
			Set<String> favoriteItems = connection.getFavoriteItemIds(userId);

			JSONArray array = new JSONArray();
			for (Item item : items) {
				JSONObject obj = item.toJSONObject();
				obj.put("favorite", favoriteItems.contains(item.getItemId()));
				array.put(obj);
			}

			RpcHelper.writeJsonArray(response, array);
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			connection.close();
		}
		// after creating db connection , this is not need 
		// since dbConnection uses tmAPI
//		TicketMasterAPI tmAPI = new TicketMasterAPI();
//		List<Item> items = tmAPI.search(lat, lon, term);
//		
//		JSONArray array = new JSONArray();
//		try {
//			for (Item item : items) {
//				JSONObject obj = item.toJSONObject();
//				array.put(obj);
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		RpcHelper.writeJsonArray(response, array);


	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
