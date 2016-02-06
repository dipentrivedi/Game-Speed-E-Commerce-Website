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
	
<h2 align="center"><u>Reviews</u></h2> 

 
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
		MongoClient mongo;
	

      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
		try{
			//Get the values from the form
			
			String searchField = "productName";
			
			//Get the product selected
			String searchParameter = "";
			if (request.getParameter("XBox_Original") != null){
			searchParameter = "X Box Original";
			}else if (request.getParameter("XBox_360") != null){
			searchParameter = "X Box 360";
			}else if (request.getParameter("XBox_One") != null){
			searchParameter = "X Box One";
			}else if (request.getParameter("XBox_360_controller") != null){
			searchParameter = "X Box 360 controller";
			}else if (request.getParameter("XBox_one_controller") != null){
			searchParameter = "X Box One controller";
			}else if (request.getParameter("XBox_orginal_controller") != null){
			searchParameter = "X Box Original controller";
			}else if (request.getParameter("PlayStation_2") != null){
			searchParameter = "PlayStation 2";
			}else if (request.getParameter("PlayStation_3") != null){
			searchParameter = "PlayStation 3";
			}else if (request.getParameter("PlayStation_4") != null){
			searchParameter = "PlayStation 4";
			}else if (request.getParameter("PlayStation2_controller") != null){
			searchParameter = "PlayStation2 controller";
			}else if (request.getParameter("PlayStation3_controller") != null){
			searchParameter = "PlayStation3 controller";
			}else if (request.getParameter("PlayStation4_controller") != null){
			searchParameter = "PlayStation4 controller";
			}else if (request.getParameter("Wii_Console") != null){
			searchParameter = "Wii Console";
			}else if (request.getParameter("Wii_Console2") != null){
			searchParameter = "Wii Console2";
			}else if (request.getParameter("Wii_U_controller") != null){
			searchParameter = "Wii U controller";
			}else if (request.getParameter("Wii_controller") != null){
			searchParameter = "Wii controller";
			}
			
			// if database doesn't exists, MongoDB will create it for you
			DB db = mongo.getDB("assign3");
			
			DBCollection myReviews = db.getCollection("productReviews");
			
			// Find and display 
			BasicDBObject searchQuery = new BasicDBObject();
			searchQuery.put(searchField, searchParameter);

			DBCursor cursor = myReviews.find(searchQuery);
	
			if(cursor.count() == 0){
%>	
			<h2>There are no reviews for this product.</h2>
			
<%
			}else{
				
			String productName = "";
			String productCategory = "";
			String productPrice = "";
			String retailerName = "";
			String retailerCity = "";
			String retailerZipcode = "";
			String retailerState = "";
			String productOnSale = "";
			String consoleManufacturer = "";
			String manufacturerRebate = "";
			String userId = "";
			String userAge = "";
			String userGender = "";
		    String userOccupation = "";
			int reviewRating = 0;
			String reviewDate = "";
			String reviewText = "";
			int count=0;
			
				while (cursor.hasNext()) {
					//out.println(cursor.next());
					BasicDBObject obj = (BasicDBObject) cursor.next();				
					productName = obj.getString("productName");
					productCategory = obj.getString("productCategory");
					productPrice = obj.getString("productPrice");
					retailerName = obj.getString("retailerName");
					retailerCity = obj.getString("retailerCity");
					retailerZipcode = obj.getString("retailerZipcode");
					retailerState = obj.getString("retailerState");
					productOnSale = obj.getString("productOnSale");
					consoleManufacturer = obj.getString("consoleManufacturer");
					manufacturerRebate = obj.getString("manufacturerRebate");
					userId = obj.getString("userId");
					userAge = obj.getString("userAge");
					userGender = obj.getString("userGender");
					userOccupation = obj.getString("userOccupation");
					reviewRating = obj.getInt("reviewRating");
					reviewDate = obj.getString("reviewDate");
					reviewText = obj.getString("reviewText");
					count++;
%>		
		<fieldset>
			<legend></legend>
		
				<h2><%=count%>></h2>
				<table border="1">	
					<tr>
					<td> Product Name: </td>
					<td><%=productName%></td>
					</tr>
					
					<tr>
					<td> Product Category: </td>
					<td><%=productCategory%></td>
					</tr>
					
					<tr>
					<td> Product Price: </td>
					<td><%=productPrice%></td>
					</tr>
					
					<tr>
					<td> Retailer Name: </td>
					<td><%=retailerName%></td>
					</tr>
					
					<tr>
					<td> Retailer City: </td>
					<td><%=retailerCity%></td>
					</tr>
					
					<tr>
					<td> RetailerZip: </td>
					<td><%=retailerZipcode%></td>
					</tr>
					
					<tr>
					<td> Retailer State: </td>
					<td><%=retailerState%></td>
					</tr>
					
					<tr>
					<td> Product OnSale: </td>
					<td><%=productOnSale%></td>
					</tr>
					
					<tr>
					<td> Manufacturer Name: </td>
					<td><%=consoleManufacturer%></td>
					</tr>
					
					<tr>
					<td>Manufacturer Rebate: </td>
					<td><%=manufacturerRebate%></td>
					</tr>
								
					<tr>
					<td> User Id: </td>
					<td><%=userId%></td>
					</tr>
					
					<tr>
					<td> User Age: </td>
					<td><%=userAge%></td>
					</tr>
					
					<tr>
					<td> User Gender: </td>
					<td><%=userGender%></td>
					</tr>
					
					<tr>
					<td> User Occupation: </td>
					<td><%=userOccupation%></td>
					</tr>
					
					<tr>
					<td> Review Rating: </td>
					<td><%=reviewRating%></td>
					</tr>
						
					<tr>
					<td> Review Date: </td>
					<td><%=reviewDate%></td>
					</tr>
					
					<tr>
					<td> Review Text: </td>
					<td><%=reviewText%></td>
					</tr>
					
				</table>
			
<%			
			} 
		}
	}
	catch (MongoException e) {
				e.printStackTrace();
	}

%>
			</legend>
		</fieldset>
			
			<table border="1">
			
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
			
			</table>
			<br><br><hr>
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
            <p>CSP 595 - Enterprise Web Application - Tutorial 3</p>
        </div>
		
</footer>

</body>
</html>
