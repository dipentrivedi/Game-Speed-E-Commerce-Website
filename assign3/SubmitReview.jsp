<html>

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>Game-Speed</title>
	<link rel="stylesheet" href="styles.css" type="text/css" />
</head>

<body>
<div id="container">
    
<header>
    	<h1><a href="index.jsp">Game<span>Speed</span></a></h1>
        <h2>world's largest online Game store</h2>
    </header>
	
<h2 align="center"></h2> 

 
<%@page import="data.*,
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
java.util.*"
%>

	
<%	
	//private static final long serialVersionUID = 1L;
	MongoClient mongo;
	

      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);

	
				
		try{
			//Get the values from the form
			String productName = request.getParameter("productName");
			String productCategory = request.getParameter("productCategory");
			String productPrice = request.getParameter("productPrice");
			String retailerName = request.getParameter("retailerName");
			String retailerCity = request.getParameter("retailerCity");
			String retailerZipcode = request.getParameter("retailerZipcode");
			String retailerState = request.getParameter("retailerState");
			String productOnSale = request.getParameter("productOnSale");
			String consoleManufacturer = request.getParameter("consoleManufacturer");
			String manufacturerRebate = request.getParameter("manufacturerRebate");
			String userId = request.getParameter("userId");
			String userAge = request.getParameter("userAge");
			String userGender = request.getParameter("userGender");
		    String userOccupation = request.getParameter("userOccupation");
			int reviewRating = Integer.parseInt(request.getParameter("reviewRating"));	
			String reviewDate = request.getParameter("reviewDate");
			String reviewText = request.getParameter("reviewText");
									
			// If database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("assign3");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection productReviews = db.getCollection("productReviews");
			
		//	System.Collection productReviews selected successfully");
				
			BasicDBObject doc = new BasicDBObject("title", "productReviews").
				append("productName", productName).
				append("productCategory", productCategory).
				append("productPrice", reviewRating).
				append("retailerName", retailerName).
				append("retailerCity", retailerCity).
				append("retailerZipcode", retailerZipcode).
				append("retailerState", retailerState).
				append("productOnSale", productOnSale).
				append("consoleManufacturer", consoleManufacturer).
				append("manufacturerRebate", manufacturerRebate).
				append("reviewRating", reviewRating).
				append("userId", userId).
				append("userAge", userAge).
				append("userGender", userGender).
				append("userOccupation", userOccupation).
				append("reviewRating", reviewRating).
				append("reviewDate", reviewDate).
				append("reviewText", reviewText);
									
			productReviews.insert(doc);
				
		//	System.Document inserted successfully");

		%>

		
			<h1> Review submitted for:<%=productName%></h1>		
			<table>	
			<tr>
			<td>
			<a href="home.jsp"> home </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href="XBox.jsp"> X Box </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href="PlayStation.jsp"> Play Station </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href="Nintendo.jsp"> Nintendo </a>
			</td>
			</tr>
			
			<tr>
			<td>
			<a href="Accessories.jsp"> Accesories </a>
			</td>
			</tr>
			
			
			</table>
<%	
		} catch (MongoException e) {
			e.printStackTrace();
		}
%>

</div>
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
</body>
</html>