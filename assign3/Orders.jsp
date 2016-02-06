
<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Game-Speed</title>
	<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>
<div id="container">
    
<header>
    	<h1><a href="home.jsp">Game<span>Speed</span></a></h1>
        <h2>world's largest online Game store</h2>
    </header>
	
<h2 align="center">Order Details</h2> 
 
<%@ page import="data.*,
java.io.*,
com.mongodb.MongoClient,
com.mongodb.MongoException,
com.mongodb.WriteConcern,
com.mongodb.DB,
com.mongodb.DBCollection,
com.mongodb.BasicDBObject,
com.mongodb.DBObject,
com.mongodb.DBCursor,
com.mongodb.ServerAddress,
java.lang.*,
java.text.*,
java.util.*"
%>
<form name="signup" action="home.jsp" method="post">
<%!int productPrice = 0;%>

<%
			MongoClient mongo = new MongoClient("localhost", 27017);

			//productData pd=(productData)session.getAttribute("cart");
			
			String useridSession=(String)session.getAttribute("userid");
			
			String searchField = "UserId";
			String searchParameter = useridSession;
			int count=0;
			String productName="";
			int productPrice=0;
			int productQuantity=0;
			int totalPrice=0;
			
			
			double confirmationNumber=Math.random();
			String userid=(String)session.getAttribute("userid");
			/* String ccNum=request.getParameter("ccNum");
			String ccType=request.getParameter("cardType");
	
			int totalPrice=Integer.parseInt(request.getParameter("totalPrice"));
			 */
			
			DB db = mongo.getDB("assign3");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myOrders = db.getCollection("myOrders"); 
			
			// Find and display 
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(searchField, searchParameter);

			DBCursor cursor = myOrders.find(searchQuery);
			if(cursor.count() == 0){
%>	
			<h2>No Orders Found.</h2>
			
<%
			}else{
				
					while (cursor.hasNext()) {
					//out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();				
					productName = obj.getString("productName");
					productPrice = Integer.parseInt(obj.getString("productPrice"));
					productQuantity = Integer.parseInt(obj.getString("productQuantity"));
					totalPrice=Integer.parseInt(obj.getString("TotalPrice"));
					count++;
	
%>
	<fieldset>
			<legend></legend>
		
				
				<table border="1">	
					<tr>
					<td> Product Name: </td>
					<td><%=productName%></td>
					</tr>
					
					<tr>
					<td> Product Price: </td>
					<td><%=productPrice%></td>
					</tr>
					
					<tr>
					<td> Product Quantity: </td>
					<td><%=productQuantity%></td>
					</tr>
			
				</table>
		</fieldset>

<%		
				}		
			}
%>	
<table border="1" bgcolor="red" style="color:blue">	
	<tr>
		<td width="55%">Total Price: </td>
		<td><%=totalPrice%></td>
	</tr>	
</table>
</form>
   
   <footer>
	
        <div class="footer-content">
            <ul>
            	<li><h4>Dummy Link Section 1</h4></li>
                <li><a href="#">Dummy Link 1</a></li>
                <li><a href="#">Dummy Link 2</a></li>
                <li><a href="#">Dummy Link  3</a></li>
			</ul>
           
        <div class="clear"></div>
        </div>
		
        <div class="footer-bottom">
            <p>CSP 595 - Enterprise Web Application - Tutorial 2</p>
        </div>
		
    </footer>
</div>

</body>

</html>