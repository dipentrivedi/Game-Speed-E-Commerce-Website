<html>
<head>
  <title>SubmitOrder</title>
</head>
<body>
  <h1>Submit Order</h1>
 
<%@page import="java.io.*,
com.mongodb.MongoClient,
com.mongodb.MongoException,
com.mongodb.WriteConcern,
com.mongodb.DB,
com.mongodb.DBCollection,
com.mongodb.BasicDBObject,
com.mongodb.DBObject,
com.mongodb.DBCursor,
com.mongodb.ServerAddress,
java.util.Arrays,
java.util.List,
java.util.Set,
java.util.Date"
%>

<%
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	
/* 	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
	}
 */	
				
		try{
			//Get the values from the form
			String productName = request.getParameter("productName");
			int productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String address = request.getParameter("address");
			int phoneNumber = Integer.parseInt(request.getParameter("phoneNumber"));							
										
			// If database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("assign3");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myOrders = db.getCollection("myOrders");
%>			
			<h1>Collection myOrders selected successfully</h1>
<%				
			BasicDBObject doc = new BasicDBObject("title", "myOrders").
				append("productName", productName).
				append("productPrice", productPrice).
				append("firstName", firstName).
				append("lastName", lastName).
				append("address", address).
				append("phoneNumber", phoneNumber);
					
			myOrders.insert(doc);
%>

<h1>Document inserted successfully</h1>

<h1>Hi, <%=firstName%><br>			
Order placed for:<%=productName%></h1>

<>			
			<table>
			
			<tr>
			<td>
			<a href='index.html'> Index </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href='XBox.html'> X Box </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href='PlayStation.html'> Play Station </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href='Nintendo.html'> Nintendo </a>
			</td>
			</tr>
		
			</table>
			
			</body>
			</html>
			
<%			
		} catch (MongoException e) {
			e.printStackTrace();
		}
	}
	
	public void destroy()	{
      // do nothing.
	}
	
}
%>
</body>
</html>
