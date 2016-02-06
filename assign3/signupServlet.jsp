<html>
<head>
  <title>SignUpServlet</title>
</head>
<body>
<h1>SignUp</h1>

<%@page import="java.util.HashMap,
java.util.Map,
com.mongodb.MongoClient,
com.mongodb.MongoException,
com.mongodb.WriteConcern,
com.mongodb.DB,
com.mongodb.DBCollection,
com.mongodb.BasicDBObject,
com.mongodb.DBObject,
com.mongodb.DBCursor,
com.mongodb.ServerAddress"
%> 

<%
		//protected Map users = new HashMap();
    
		String firstname = request.getParameter("fname");
		String lastname = request.getParameter("lname");
		String userid = request.getParameter("userid");
        String email = request.getParameter("txtEmail");
		String password = request.getParameter("password");
		String ccnumber = request.getParameter("ccNum");
		String address = request.getParameter("txtAddress");
			
		if(userid != null && userid.length() != 0) {
            userid = userid.trim();
        }
        if(password != null && password.length() != 0) {
            password = password.trim();
        }
      
		
	   if(userid != null && password != null) {
		
			MongoClient mongo = new MongoClient("localhost", 27017);
		
			DB db = mongo.getDB("assign3");
		
			DBCollection myDetails= db.getCollection("userDetails");
		
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
			
	   
%>

	<h1> Thank you for joining</h1>
	<form action="login.jsp">
	<input type="submit" name="singupSuccess" value="Login">
	</form>
<%
	   }
	   else
	   {
%>
	<h1> signup Failure!  You must supply a username and password</h1>
	<form action="signup.jsp">
	<input type="submit" name="singupFailure" value="Go Back">
	</form>
<%
	   }  
%>
</body>
</html>
