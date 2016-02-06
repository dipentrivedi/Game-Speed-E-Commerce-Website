/*
 * LoginServlet.java
 *
 */
 

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


public class signupServlet extends HttpServlet {
   
    protected Map users = new HashMap();
    /** 
     * Initializes the servlet with some usernames/password
    */  
//    public void init() {
//                users.put("test", "TEST");
//    }

    /** Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
    * @param request servlet request
    * @param response servlet response
    */
    
	  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, java.io.IOException  {
        
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String userid = request.getParameter("userid");
        String email = request.getParameter("txtEmail");
		String password = request.getParameter("password");
        
		String ccnumber = request.getParameter("ccNum");
		String address = request.getParameter("address");
			
		if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
      
		
	   if(userid != null && password != null) {
	//	users.put("userid","password");
		
			MongoClient mongo = new MongoClient("localhost", 27017);
		
			DB db = mongo.getDB("assign1");
		
			DBCollection myDetails= db.getCollection("myDetails");
		
			System.out.println("Collection myReviews selected successfully");
			
		
			BasicDBObject doc = new BasicDBObject("title", "MongoDB").
				append("fname", firstname).
				append("lname", lastname).
				append("userid", userid).
				append("email", email).
				append("password",password).
				append("ccnumber", ccnumber).
				append("address", address);
				
		    myDetails.insert(doc);
			
			System.out.println("Document inserted successfully");
			
			displayPage(response, "Thank you for joining");
	   }
	   else
	   {
			displayPage(response, "signup Failure!  You must supply a username and password");   
	   }
	   
	}
	 /*  if(userid != null &&
            password != null) {
                String realpassword = (String)users.get(userid);
                if(realpassword != null &&
                    realpassword.equals(password)) {
                    showPage(response, "Login Success!");
                } else {
                    showPage(response, "Login Failure! Username or password is incorrect");
                }
        }  else {
            showPage(response, "Login Failure!  You must supply a username and password");
        }
    } 
    */
	
    /**
     * Actually shows the <code>HTML</code> result page
     */
    protected void displayPage(HttpServletResponse response, String message)
    throws ServletException, java.io.IOException {
        response.setContentType("text/html");
        java.io.PrintWriter out = response.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>signup Servlet Result</title>");  
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>" + message + "</h2>");
        out.println("</body>");
        out.println("</html>");
        out.close();
 
    }
    
    /** Handles the HTTP <code>GET</code> method.
    * @param request servlet request
    * @param response servlet response
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    } 

    /** Handles the HTTP <code>POST</code> method.
    * @param request servlet request
    * @param response servlet response
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, java.io.IOException {
        processRequest(request, response);
    }
	*/
}
