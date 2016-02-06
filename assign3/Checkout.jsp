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
	
<h2 align="center"><u>Check Out</u></h2> 
 
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
<form action="finalOrder.jsp">	
	<table border="1" sytle="width:100%" align="center">
	<tr>
		<td>Product Name</td>
		<td>Product Value</td>
		<td>Product Quantity</td>
	</tr>	
	
	<%!
		String productName = "";
		String imageLocation = " ";
		String productUrl=" ";
		int productPrice = 0;	
	%>
	
<%
	
	if (request.getParameter("XBox_Original") != null){
				productName = "X Box Original";
				imageLocation = "images/img_XBoxOriginal.jpg";
				productPrice = 80;
				productUrl ="XBox_Original";
			}else if (request.getParameter("XBox_360") != null){
				productName = "X Box 360";
				imageLocation = "images/img_XBox360.jpg";
				productPrice = 300;
				productUrl ="XBox_360";
			}else if (request.getParameter("XBox_One") != null){
				productName = "X Box One";
				imageLocation = "images/img_XBoxOne.jpg";
				productPrice = 500;
				productUrl ="XBox_One";
			}else if (request.getParameter("XBox_360_controller") != null){
				productName = "X Box 360 controller";
				imageLocation = "images/img_Xbox_360_controller.jpg";
				productPrice = 50;
				productUrl ="XBox_360_controller";
			}else if (request.getParameter("XBox_one_controller") != null){
				productName = "X Box One controller";
				imageLocation = "images/img_Xbox_one_controller.jpg";
				productPrice = 50;
				productUrl ="XBox_one_controller";
			}else if (request.getParameter("XBox_orginal_controller") != null){
				productName = "X Box Original controller";
				imageLocation = "images/img_Xbox_original_controller.jpg";
				productPrice = 50;
				productUrl ="XBox_orginal_controller";
			}else if (request.getParameter("PlayStation_2") != null){
				productName = "PlayStation 2";
				imageLocation = "images/img_PlayStation2.jpg";
				productPrice = 60;
				productUrl ="PlayStation_2";
			}else if (request.getParameter("PlayStation_3") != null){
				productName = "PlayStation 3";
				imageLocation = "images/img_PlayStation3.jpg";
				productPrice = 220;
				productUrl ="PlayStation_3";
			}else if (request.getParameter("PlayStation_4") != null){
				productName = "PlayStation 4";
				imageLocation = "images/img_PlayStation4.jpg";
				productPrice = 400;
				productUrl ="PlayStation_4";
			}else if (request.getParameter("PlayStation2_controller") != null){
				productName = "PlayStation2 controller";
				imageLocation = "images/img_Playstation2_controller.jpg";
				productPrice = 50;
				productUrl ="PlayStation2_controller";
			}else if (request.getParameter("PlayStation3_controller") != null){
				productName = "PlayStation3 controller";
				imageLocation = "images/img_Playstation3_controller.jpg";
				productPrice = 50;
				productUrl ="PlayStation3_controller";
			}else if (request.getParameter("PlayStation4_controller") != null){
				productName = "PlayStation4 controller";
				imageLocation = "images/img_Playstation4_controller.jpg";
				productPrice = 50;
				productUrl ="PlayStation4_controller";
			}else if (request.getParameter("Wii_Console") != null){
				productName = "Wii Console";
				imageLocation = "images/img_wii_console.jpg";
				productPrice = 400;
				productUrl ="Wii_Console";
			}else if (request.getParameter("Wii_Console2") != null){
				productName = "Wii Console2";
				imageLocation = "images/img_wii_console2.jpg";
				productPrice = 400;
				productUrl ="Wii_Console2";
			}else if (request.getParameter("Wii_U_controller") != null){
				productName = "Wii U controller";
				imageLocation = "images/img_wiiu_controller.jpg";
				productPrice = 40;
				productUrl ="Wii_U_controller";
			}else if (request.getParameter("Wii_controller") != null){
				productName = "Wii controller";
				imageLocation = "images/img_wii_controller.jpg";
				productPrice = 40;
				productUrl ="Wii_controller";
			}
			MongoClient mongo = new MongoClient("localhost", 27017);

			productData pd=(productData)session.getAttribute("cart");
			
			String useridSession=(String)session.getAttribute("userid");
		
			HashMap<String,product> hm1=pd.getProductData();
			
			int totalQuant=0;
			int totalPrice=0;
			int i=0;
			String pruductDetails="";
			double confirmationNumber=Math.random();

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
		<tr>
			<td><input type="hidden" name="<%=productUrl%>" value="<%=p.getProductName()%>"><%=p.getProductName()%></td>
			<td><input type="hidden" name="productPrice" value=<%=p.getProductPrice()%>><%=p.getProductPrice()+""%></td>
			<td><input type="text" name="productQuantity" value=<%=p.getProductQuantity()%>></td>
		</tr>
<%
			
				
				totalQuant+=p.getProductQuantity();
				totalPrice+=p.getProductPrice()*p.getProductQuantity();
			
		}
%>
	<tr align="left" width="100%">
		<td colspan="3">Sub Total (<%=totalQuant+""%> item) :$<%=totalPrice+""%></td>
	</tr>
	</table>

 
<br><br><br><br>

<h1 align="center">Personal Details</h1>

<table  cellspacing="5" border="1" width="30%" cellpadding="5" align="center" >
<tr>
	<td>First Name</td>
	<td><input type="text" name="fname" required autofocus placeholder="Your first name" title="Please enter in more than three letters"/></td>
</tr>
<tr>
	<td>Last Name</td>
	<td><input type="text" name="lname" required autofocus placeholder="Your Last name" title="Please enter in more than three letters"/></td>
</tr>

<tr>
	<td>User id</td>
	<td><input type="text" name="userid" required autofocus placeholder="Your Username" value="<%=useridSession%>"title="Please enter in more than three letters"/></td>
</tr>

<tr>
	<td>Email</td>
	<td><input type="text" name="txtEmail" required autofocus placeholder="abc@xyz.com" title="Please enter Valid Email Adddress" pattern="[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,3}$"></td>
</tr>

<tr>
	<td> Credit Card Type: </td>
	<td>
		<select name="cardType">
			<option value="Visa" selected>Visa</option>
			<option value="Master Card">Master Card</option>
			<option value="American Express">American Express</option>
			<option value="Discover">Discover</option>
			<option value="Other">Other</option>
	</td>
</tr>

<tr>
	<td>Credit Card Number</td>
	<td><input type="password" name="ccNum" required autofocus placeholder="Your credit card number" title="Please enter 16 digit number"/>	</td>
</tr>


<tr>
	<td>CreditCard Exp Date</td>
	<td><input type="date" name="checkoutDate"/></td>
</tr>
	
<tr>
	<td>Address</td>
	<td> <textarea name="txtAddress" rows="4" cols="50" required autofocus placeholder="Your Address" title="Please enter your City & State"></textarea> </td>
	
</tr>
<tr>
	<td colspan="2">
		<input type="hidden" name="totalQuant" value="<%=totalQuant%>">
		<input type="hidden" name="totalPrice" value="<%=totalPrice%>">
		<input type="submit" name="checkoutSubmit" value="Submit Order">
	</td>
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
