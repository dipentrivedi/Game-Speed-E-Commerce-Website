<html>
<head>
  <title>LoginServlet</title>
</head>
<body>
<h1>Login</h1>

<%@page import="java.util.*,
java.io.*,
java.servlet.*,
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
			//session= request.getSession(true);
		
			String user = request.getParameter("userid");
			String pass = request.getParameter("password");
			String tmpUser;
			String tmpPass;
			String useridSession=user;
			
		    //Connect to Mongo DB
			MongoClient mongo = new MongoClient("localhost", 27017);
						
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("assign3");
			
			DBCollection myDetails = db.getCollection("userDetails");
			
			
			// Find and display 
			BasicDBObject searchQueryUser = new BasicDBObject();
			BasicDBObject searchQueryPass = new BasicDBObject();
			
			searchQueryUser.put("userid",user);
			searchQueryPass.put("password",pass);
			
		
			DBCursor cursorUser = myDetails.find(searchQueryUser);
			DBCursor cursorPass = myDetails.find(searchQueryPass);
	
			
			if(cursorUser.count() == 0){
%>
				
			<h1>INCORRECT USERNAME</h1>;
<%			
			}
			else{
				
			while(cursorUser.hasNext())
			{
								
				BasicDBObject objUser = (BasicDBObject) cursorUser.next();				
				BasicDBObject objPass = (BasicDBObject) cursorPass.next();				
				
				tmpUser=objUser.getString("userid");
				
				tmpPass=objPass.getString("password");
				
				if(tmpUser.equals(user))
				 {
							if(tmpPass.equals(pass))
							{
								
								if(session.getAttribute("userid")==null)
								{
									//pd= new productData();
									session.setAttribute("userid",useridSession);
%>

									<h1>Login Success</h1>
									<form action="home.jsp">
									<input type="submit" name="loginSuccess" value="Home">
									</form>					
<%
								
								}
								else
								{
									useridSession=(String)session.getAttribute("userid");
%>
									<h1>User Already Logged in</h1>
									<form action="home.jsp">
											<input type="submit" name="loginSuccess" value="Home">
									</form>		
<%				
								}
								break;
							}
							else
							{
%>
						<h1>Login Failure! Username or password is incorrect</h1>
						<form action="signup.jsp">
						<input type="submit" name="singupFailure" value="Go Back">
						</form>

<%
							}
				}
				else{
%>
						<h1>Username is incorrect</h1>
<%
				}
			}
		} 
%>
</body>
</html>
