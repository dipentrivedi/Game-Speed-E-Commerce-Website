/*
 * LoginServlet.java
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


public class LoginServlet extends HttpServlet {
   
    
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException  {
        
		    HttpSession session= request.getSession(true);
		
			String user = request.getParameter("userid");
			String pass = request.getParameter("password");
			String tmpUser;
			String tmpPass;
			
	    	response.setContentType("text/html");
		
		    PrintWriter output = response.getWriter();
	
			output.println(user);
		
		    //Connect to Mongo DB
			MongoClient mongo = new MongoClient("localhost", 27017);
						
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("assign1");
			
			DBCollection myDetails = db.getCollection("userDetails");
			
			
			// Find and display 
			BasicDBObject searchQueryUser = new BasicDBObject();
			BasicDBObject searchQueryPass = new BasicDBObject();
			
			searchQueryUser.put("userid",user);
			searchQueryPass.put("password",pass);
			
		
			DBCursor cursorUser = myDetails.find(searchQueryUser);
			DBCursor cursorPass = myDetails.find(searchQueryPass);
	
			
			if(cursorUser.count() == 0){
				
				showPage(response, "INCORRECT USERNAME");
			
			}
			else{
				
			while(cursorUser.hasNext()) //&& cursorPass.hasNext())
			{
								
				BasicDBObject objUser = (BasicDBObject) cursorUser.next();				
				BasicDBObject objPass = (BasicDBObject) cursorPass.next();				
				
				tmpUser=objUser.getString("userid");
				
				tmpPass=objPass.getString("password");
				
				if(tmpUser.equals(user))
				 {
							if(tmpPass.equals(pass))
							{
								homePage(response, "Login Success!");
								
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myProducts = db.getCollection("myProducts");
			// Find and display
			DBCursor cursor = myProducts.find();
			if(cursor.count()==0){
				BasicDBObject doc = new BasicDBObject("title", "myProducts").
					append("productName", "XBoxOriginal").
					append("productcategory", "XBox").
					append("price", "150").
					append("discount", "5").
					append("rebate", "10");
					
				BasicDBObject doc1 = new BasicDBObject("title", "myProducts").
					append("productName", "XBox360").
					append("productcategory", "XBox").
					append("price", "100").
					append("discount", "15").
					append("rebate", "5");
					
				BasicDBObject doc2 = new BasicDBObject("title", "myProducts").
					append("productName", "XBoxOne").
					append("productcategory", "XBox").
					append("price", "100").
					append("discount", "15").
					append("rebate", "5");
				
					
				BasicDBObject doc3 = new BasicDBObject("title", "myProducts").
					append("productName", "PlayStation2").
					append("productcategory", "PlayStation").
					append("price", "100").
					append("discount", "5").
					append("rebate", "10");
					
				
				BasicDBObject doc4 = new BasicDBObject("title", "myProducts").
					append("productName", "PlayStation3").
					append("productcategory", "PlayStation").
					append("price", "100").
					append("discount", "5").
					append("rebate", "10");
				
				BasicDBObject doc5 = new BasicDBObject("title", "myProducts").
					append("productName", "PlayStation4").
					append("productcategory", "PlayStation").
					append("price", "100").
					append("discount", "5").
					append("rebate", "10");
				
				BasicDBObject doc6 = new BasicDBObject("title", "myProducts").
					append("productName", "WiiConsole").
					append("productcategory", "Nintendo").
					append("price", "100").
					append("discount", "5").
					append("rebate", "10");
				
				
				BasicDBObject doc7 = new BasicDBObject("title", "myProducts").
					append("productName", "WiiUconsole").
					append("productcategory", "Nintendo").
					append("price", "100").
					append("discount", "5").
					append("rebate", "10");
					
				myProducts.insert(doc);
				myProducts.insert(doc1);
				myProducts.insert(doc2);
				myProducts.insert(doc3);
				myProducts.insert(doc4);
				myProducts.insert(doc5);
				myProducts.insert(doc6);
				myProducts.insert(doc7);
				
			}			
								session.setAttribute("userid",user);
							}
							else
							{
								showPage(response, "Login Failure! Username or password is incorrect");
							}
				}
				else{
						output.println("sorry");
				}
			}
			}
    } 
    
    /**
     * Actually shows the <code>HTML</code> result page
     */
    protected void showPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        
		out.println("<h2>" + message + "</h2>");
        out.println("<a href="+"login.html"+"><input type="+"button"+" name="+"homeButton"+" value="+"home"+"></a>");
 
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }

 protected void homePage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Login Successful</title>");  
        out.println("</head>");
        out.println("<body>");
        
		out.println("<h2>" + message + "</h2>");
        out.println("<a href="+"home.html"+"><input type="+"button"+" name="+"homeButton"+" value="+"home"+"></a>");
 
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
    
    
}
