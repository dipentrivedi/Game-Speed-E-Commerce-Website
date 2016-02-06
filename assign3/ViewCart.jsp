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
	
<h2 align="center"><u>View Cart</u></h2> 
	
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
	%>
	<%@ page import="java.util.*,data.*"%>
	
	
	<table border="1" sytle="width:100%" align="center">
	<tr>
		<td>Product Name</td>
		<td>Product Value</td>
		<td>Product Quantity</td>
		<td></td>
	</tr>	
	
	<%
		int totalQuant=0;
		int totalPrice=0;
		int i=0;
		product p=null;
		if(session.getAttribute("cart")==null)
		{
	%>
		<h1 align="center">no data found</h1>
	<%
		}
		else
		{
		
		productData pd=(productData)session.getAttribute("cart");
		
		HashMap<String,product> hm1=pd.getProductData();
		
	    
		Set set1 = hm1.entrySet();
		// Get an iterator
		Iterator i1 = set1.iterator();
		%>
	
	<%	
		
		// Display elements
		while(i1.hasNext()) {
		Map.Entry me1 = (Map.Entry)i1.next();			
		p=(product)me1.getValue();
		i++;
	 %>
				<form action="Update.jsp" method="get">
		<tr>
			<td><input type="hidden" name="<%=productUrl%>" value="<%=p.getProductName()%>"><%=p.getProductName()%></td>
			<td><input type="hidden" name="productPrice" value=<%=p.getProductPrice()%>><%=p.getProductPrice()+""%></td>
			<td><input type="text" name="productQuantity" value=<%=p.getProductQuantity()%>></td>
			<td>	
					<input type="submit" name="updatePrice" value="Update">
				</form>
			</td>
		</tr>
	<%

//		p.setProductQuatity(request.getParameter("productPrice"));

		totalQuant+=p.getProductQuantity();
		totalPrice+=p.getProductPrice()*p.getProductQuantity();
		}
	%>
	<tr align="left" width="100%">
		<td colspan="4">Sub Total (<%=totalQuant+""%> item) :$<%=totalPrice+""%></td>
	</tr>
	<%
	}
	%>
	</table>
	<table border="0" sytle="width:100%" align="center">
			<tr align="center">
				<td>
					
					<a href="home.jsp"><input type="button" value="Go Back"></a>
					
				</td>
				<td>
<%
				if(totalQuant==0)
				{
%>
					<a hfref="ViewCart.jsp"><input type="button" value="Proceed to Checkout"></a>	
			
<%
				}
				else
				{		
%>	
					<form method="post" action="Checkout.jsp" style="bgcolor:red">	
					<input type="hidden" name="<%=productUrl%>" value="<%=p.getProductName()%>">
					<input type="hidden" name="productPrice" value=<%=p.getProductPrice()%>>
					<input type="hidden" name="productQuantity" value=<%=p.getProductQuantity()%>>
					<input type="submit" value="Proceed to Checkout">	
<%
				}
%>
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