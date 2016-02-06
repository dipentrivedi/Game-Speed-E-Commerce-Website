/*
 * productDetails.java
 *
 */
 
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.*;
import javax.servlet.http.*;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;


public class productDetails extends HttpServlet {
   
    
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException  {
        try{
		   String searchField = "productName";
			
			//Get the product selected
			String searchParameter = request.getParameter("id");
			
			/* if (request.getParameter("id") != null){
			searchParameter = "XBoxOriginal";
			}else if (request.getParameter("XBox360") != null){
			searchParameter = "XBox360";
			}else if (request.getParameter("XBoxOne") != null){
			searchParameter = "XBoxOne";
			}else if (request.getParameter("PlayStation2") != null){
			searchParameter = "PlayStation2";
			}else if (request.getParameter("PlayStation3") != null){
			searchParameter = "PlayStation3";
			}else if (request.getParameter("PlayStation4") != null){
			searchParameter = "PlayStation4";
			}else if (request.getParameter("WiiConsole") != null){
			searchParameter = "WiiConsole";
			}else if (request.getParameter("WiiUConsole") != null){
			searchParameter = "WiiUConsole";
			}
		 */	
			System.out.println("searchParameter "+searchParameter);
	    	response.setContentType("text/html");
		
	
			
		    //Connect to Mongo DB
			MongoClient mongo = new MongoClient("localhost", 27017);
						
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("assign1");
			
			DBCollection myDetails = db.getCollection("myProducts");
			
			
			// Find and display 
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(searchField, searchParameter);

			DBCursor cursor = myDetails.find(searchQuery);
			
			PrintWriter out = response.getWriter();
			
			out.println("<!DOCTYPE html>"  
					+ "<html lang=\"en\">"
					+ "<head>	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
					+ "<title>Game Speed</title>"
					+ "<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" />"
					+ "</head>"
					+ "<body>"
					+ "<div id=\"container\">"
					+ "<header>"
					+ "<h1><a href=\"/\">Game<span>Speed</span></a></h1><h2>World's Largest Gaming Website</h2>"
					+ "</header>"
					+ "<nav>"
					+ "<ul>"
					+ "<li class=\"\"><a href=\"index.html\">Home</a></li>"
					+ "<li class=\"\"><a href=\"XBox.html\">Xbox</a></li>"
					+ "<li class=\"\"><a href=\"PlayStation.html\">Playstation</a></li>"
					+ "<li class=\"\"><a href=\"Nintendo.html\">Nintendo</a></li>"
					+ "</ul>"
					+ "</nav>"
					+ "<div id=\"body\">"
					+ "<section id=\"review-content\">"
					+ "<article>"
					+ "<center><h2 style=\"color:#DE2D3A;font-weight:700;\"> Product Details </h2>");
			
			if(cursor.count() == 0){
				
				out.println("There are no reviews for this product.");
			}else{
		
			out.println("<table border=\"1\" style=\"width:50%\">");
				
			String productName = "";
			String productCategory = "";
			String productPrice = "";
			String manufacturerDiscount = "";
			String manufacturerRebate = "";
			
			
				while (cursor.hasNext()) {
					//out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();				
					
					out.println("<tr>");
					out.println("<td> Product Name: </td>");
					productName = obj.getString("productName");
					out.println("<td>" +productName+ "</td>");
					out.println("</tr>");
					
					out.println("<tr>");
					out.println("<td> Product Catagory: </td>");
					productCategory = obj.getString("productcategory");
					out.println("<td>" +productCategory+ "</td>");
					out.println("</tr>");
					
					
					out.println("<tr>");
					out.println("<td> Product Price: </td>");
					productPrice = obj.getString("price");
					out.println("<td>" +productPrice+ "</td>");
					out.println("</tr>");
					
					
					out.println("<tr>");
					out.println("<td>Manufacturer Rebate: </td>");
					manufacturerRebate = obj.getString("rebate");
					out.println("<td>" +manufacturerRebate+ "</td>");
					out.println("</tr>");
						
						
					out.println("<tr>");
					out.println("<td>Manufacturer Discount: </td>");
					manufacturerDiscount = obj.getString("discount");
					out.println("<td>" +manufacturerDiscount+ "</td>");
					out.println("</tr>");
						
				}
			}	
				
				out.println("</center></table>");
				out.println("</div>");
				out.println("</body>");
				out.println("</html>");
		
		} catch (MongoException e) {
				e.printStackTrace();
		}
	} 
}
