<html>
<head>
  <title>Buy</title>
</head>
<body>
  <h1>Place Order</h1>
 
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
		
	<h3><%=productName%></h3>
		
	<form method="get" action="AddCart.jsp">
		
		<fieldset>
			<legend>Product information:</legend>
			<img src = <%=imageLocation%> width = "200" height = "200" alt = "Product Image">
			<table>
				<tr>
					<td> Product Name: </td>
					<td> 
						<input type="text" name="<%=productUrl%>" value="<%=productName%>" readonly> 
					</td>         
				</tr>
				
				<tr>
					<td> Product Price: </td>
					<td> <input type="text" name="productPrice" value=<%=productPrice%> readonly> </td>
				</tr>
			</table>
			<input type="submit" value="Place Order">
			
		</fieldset>
		
	</form>
		
	
</body>
</html>