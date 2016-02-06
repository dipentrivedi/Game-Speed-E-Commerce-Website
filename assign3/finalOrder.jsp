
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

			productData pd=(productData)session.getAttribute("cart");
			
			String useridSession=(String)session.getAttribute("userid");
		
			HashMap<String,product> hm1=pd.getProductData();
			
			int i=0;
			String pruductDetails="";
			double confirmationNumber=Math.random()*10;

			DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
			Date d = new Date();
			String initalDate=dateFormat.format(d);
			
			StringTokenizer st=new StringTokenizer(initalDate,"/");
			String s1 = st.nextToken();
			String s2 = st.nextToken();
			String datestr = st.nextToken();
			int k1=(Integer.parseInt(datestr)+5);
			int k2=(Integer.parseInt(datestr)+4);
			String deliveryDate = s1+"/"+s2+"/"+k1;
			String cancelDate= s1+"/"+s2+"/"+k2;
			
			String fname=request.getParameter("fname");
			String lname=request.getParameter("lname");
			String name=fname+" "+lname;
			String userid=(String)session.getAttribute("userid");
			String ccNum=request.getParameter("ccNum");
			String ccType=request.getParameter("cardType");
			int totalQuant=Integer.parseInt(request.getParameter("totalQuant"));
			int totalPrice=Integer.parseInt(request.getParameter("totalPrice"));
			
			String productDetails="";
			Set set1 = hm1.entrySet();
			// Get an iterator
			Iterator i1 = set1.iterator();
			
			DB db = mongo.getDB("assign3");
				
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myOrders = db.getCollection("myOrders"); 
			
			while(i1.hasNext()) {
				Map.Entry me1 = (Map.Entry)i1.next();			
				product p=(product)me1.getValue();
				i++;
					

%>

<%
				productDetails=p.getProductName()+","+p.getProductPrice()+","+p.getProductQuantity();
				
				totalQuant+=p.getProductQuantity();
				totalPrice+=p.getProductPrice()*p.getProductQuantity();
			//	productDetails=p.getProductName()+","+p.getProductPrice()+","+p.getProductQuantity();
				
				totalQuant+=p.getProductQuantity();
				totalPrice+=p.getProductPrice()*p.getProductQuantity();
		
				
				BasicDBObject doc = new BasicDBObject("title", "myOrders").
				append("productName", p.getProductName()).
				append("productPrice", p.getProductPrice()).
				append("productQuantity",p.getProductQuantity()).
				append("UserId", userid).
				append("Name", name).
				append("CardNumber", ccNum).
				append("CardType", ccType).
				append("DelieveryDate", deliveryDate).
				append("CancelDate", cancelDate).
				append("item", productDetails).
				append("itemPrice", p.getProductPrice()).
				append("itemQuantity", p.getProductQuantity()).
				append("TotalPrice", totalPrice).
				append("TotalQuantity", totalQuant).
				append("ComfitmationNumber",confirmationNumber);
				
				myOrders.insert(doc);
	 
			
		}
%>
<center>
<h1>Hello, <%=userid%></h1>
<h2>Your Order has been place.</h2>
<h2>Confirmation No: <%=confirmationNumber%></h2>
<h2>Date is: <%=initalDate%></h2>	
<h2>Delievery Date is: <%=deliveryDate%></h2>
</center>
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