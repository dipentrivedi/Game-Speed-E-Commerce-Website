<html>
<head>
  <title>Buy</title>
</head>
<body>
  <h1>Product Reviews</h1>
	
	<%!
		String productName = "";
		String imageLocation = " ";
		double productPrice = 0.0;	
		String useridSession="";
			
	%>
	<%
		if (request.getParameter("XBox_Original") != null){
				productName = "X Box Original";
				imageLocation = "images/img_XBoxOriginal.jpg";
				productPrice = 80;
			}else if (request.getParameter("XBox_360") != null){
				productName = "X Box 360";
				imageLocation = "images/img_XBox360.jpg";
				productPrice = 300;
			}else if (request.getParameter("XBox_One") != null){
				productName = "X Box One";
				imageLocation = "images/img_XBoxOne.jpg";
				productPrice = 500;
			}else if (request.getParameter("XBox_360_controller") != null){
				productName = "X Box 360 controller";
				imageLocation = "images/img_Xbox_360_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_one_controller") != null){
				productName = "X Box One controller";
				imageLocation = "images/img_Xbox_one_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_orginal_controller") != null){
				productName = "X Box Original controller";
				imageLocation = "images/img_Xbox_original_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation_2") != null){
				productName = "PlayStation 2";
				imageLocation = "images/img_PlayStation2.jpg";
				productPrice = 60;
			}else if (request.getParameter("PlayStation_3") != null){
				productName = "PlayStation 3";
				imageLocation = "images/img_PlayStation3.jpg";
				productPrice = 220;
			}else if (request.getParameter("PlayStation_4") != null){
				productName = "PlayStation 4";
				imageLocation = "images/img_PlayStation4.jpg";
				productPrice = 400;
			}else if (request.getParameter("PlayStation2_controller") != null){
				productName = "PlayStation2 controller";
				imageLocation = "images/img_Playstation2_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation3_controller") != null){
				productName = "PlayStation3 controller";
				imageLocation = "images/img_Playstation3_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation4_controller") != null){
				productName = "PlayStation4 controller";
				imageLocation = "images/img_Playstation4_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("Wii_Console") != null){
				productName = "Wii Console";
				imageLocation = "images/img_wii_console.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_Console2") != null){
				productName = "Wii Console2";
				imageLocation = "images/img_wii_console2.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_U_controller") != null){
				productName = "Wii U controller";
				imageLocation = "images/img_wiiu_controller.jpg";
				productPrice = 40;
			}else if (request.getParameter("Wii_controler") != null){
				productName = "Wii controller";
				imageLocation = "images/img_wii_controller.jpg";
				productPrice = 40;
			}
			if (request.getParameter("XBox_Original") != null){
				productName = "X Box Original";
				imageLocation = "images/img_XBoxOriginal.jpg";
				productPrice = 80;
			}else if (request.getParameter("XBox_360") != null){
				productName = "X Box 360";
				imageLocation = "images/img_XBox360.jpg";
				productPrice = 300;
			}else if (request.getParameter("XBox_One") != null){
				productName = "X Box One";
				imageLocation = "images/img_XBoxOne.jpg";
				productPrice = 500;
			}else if (request.getParameter("XBox_360_controller") != null){
				productName = "X Box 360 controller";
				imageLocation = "images/img_Xbox_360_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_one_controller") != null){
				productName = "X Box One controller";
				imageLocation = "images/img_Xbox_one_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_orginal_controller") != null){
				productName = "X Box Original controller";
				imageLocation = "images/img_Xbox_original_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation_2") != null){
				productName = "PlayStation 2";
				imageLocation = "images/img_PlayStation2.jpg";
				productPrice = 60;
			}else if (request.getParameter("PlayStation_3") != null){
				productName = "PlayStation 3";
				imageLocation = "images/img_PlayStation3.jpg";
				productPrice = 220;
			}else if (request.getParameter("PlayStation_4") != null){
				productName = "PlayStation 4";
				imageLocation = "images/img_PlayStation4.jpg";
				productPrice = 400;
			}else if (request.getParameter("PlayStation2_controller") != null){
				productName = "PlayStation2 controller";
				imageLocation = "images/img_Playstation2_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation3_controller") != null){
				productName = "PlayStation3 controller";
				imageLocation = "images/img_Playstation3_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation4_controller") != null){
				productName = "PlayStation4 controller";
				imageLocation = "images/img_Playstation4_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("Wii_Console") != null){
				productName = "Wii Console";
				imageLocation = "images/img_wii_console.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_Console2") != null){
				productName = "Wii Console2";
				imageLocation = "images/img_wii_console2.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_U_controller") != null){
				productName = "Wii U controller";
				imageLocation = "images/img_wiiu_controller.jpg";
				productPrice = 40;
			}else if (request.getParameter("Wii_controler") != null){
				productName = "Wii controller";
				imageLocation = "images/img_wii_controller.jpg";
				productPrice = 40;
			}
			if (request.getParameter("XBox_Original") != null){
				productName = "X Box Original";
				imageLocation = "images/img_XBoxOriginal.jpg";
				productPrice = 80;
			}else if (request.getParameter("XBox_360") != null){
				productName = "X Box 360";
				imageLocation = "images/img_XBox360.jpg";
				productPrice = 300;
			}else if (request.getParameter("XBox_One") != null){
				productName = "X Box One";
				imageLocation = "images/img_XBoxOne.jpg";
				productPrice = 500;
			}else if (request.getParameter("XBox_360_controller") != null){
				productName = "X Box 360 controller";
				imageLocation = "images/img_Xbox_360_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_one_controller") != null){
				productName = "X Box One controller";
				imageLocation = "images/img_Xbox_one_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_orginal_controller") != null){
				productName = "X Box Original controller";
				imageLocation = "images/img_Xbox_original_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation_2") != null){
				productName = "PlayStation 2";
				imageLocation = "images/img_PlayStation2.jpg";
				productPrice = 60;
			}else if (request.getParameter("PlayStation_3") != null){
				productName = "PlayStation 3";
				imageLocation = "images/img_PlayStation3.jpg";
				productPrice = 220;
			}else if (request.getParameter("PlayStation_4") != null){
				productName = "PlayStation 4";
				imageLocation = "images/img_PlayStation4.jpg";
				productPrice = 400;
			}else if (request.getParameter("PlayStation2_controller") != null){
				productName = "PlayStation2 controller";
				imageLocation = "images/img_Playstation2_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation3_controller") != null){
				productName = "PlayStation3 controller";
				imageLocation = "images/img_Playstation3_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation4_controller") != null){
				productName = "PlayStation4 controller";
				imageLocation = "images/img_Playstation4_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("Wii_Console") != null){
				productName = "Wii Console";
				imageLocation = "images/img_wii_console.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_Console2") != null){
				productName = "Wii Console2";
				imageLocation = "images/img_wii_console2.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_U_controller") != null){
				productName = "Wii U controller";
				imageLocation = "images/img_wiiu_controller.jpg";
				productPrice = 40;
			}else if (request.getParameter("Wii_controler") != null){
				productName = "Wii controller";
				imageLocation = "images/img_wii_controller.jpg";
				productPrice = 40;
			}
			if (request.getParameter("XBox_Original") != null){
				productName = "X Box Original";
				imageLocation = "images/img_XBoxOriginal.jpg";
				productPrice = 80;
			}else if (request.getParameter("XBox_360") != null){
				productName = "X Box 360";
				imageLocation = "images/img_XBox360.jpg";
				productPrice = 300;
			}else if (request.getParameter("XBox_One") != null){
				productName = "X Box One";
				imageLocation = "images/img_XBoxOne.jpg";
				productPrice = 500;
			}else if (request.getParameter("XBox_360_controller") != null){
				productName = "X Box 360 controller";
				imageLocation = "images/img_Xbox_360_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_one_controller") != null){
				productName = "X Box One controller";
				imageLocation = "images/img_Xbox_one_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_orginal_controller") != null){
				productName = "X Box Original controller";
				imageLocation = "images/img_Xbox_original_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation_2") != null){
				productName = "PlayStation 2";
				imageLocation = "images/img_PlayStation2.jpg";
				productPrice = 60;
			}else if (request.getParameter("PlayStation_3") != null){
				productName = "PlayStation 3";
				imageLocation = "images/img_PlayStation3.jpg";
				productPrice = 220;
			}else if (request.getParameter("PlayStation_4") != null){
				productName = "PlayStation 4";
				imageLocation = "images/img_PlayStation4.jpg";
				productPrice = 400;
			}else if (request.getParameter("PlayStation2_controller") != null){
				productName = "PlayStation2 controller";
				imageLocation = "images/img_Playstation2_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation3_controller") != null){
				productName = "PlayStation3 controller";
				imageLocation = "images/img_Playstation3_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation4_controller") != null){
				productName = "PlayStation4 controller";
				imageLocation = "images/img_Playstation4_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("Wii_Console") != null){
				productName = "Wii Console";
				imageLocation = "images/img_wii_console.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_Console2") != null){
				productName = "Wii Console2";
				imageLocation = "images/img_wii_console2.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_U_controller") != null){
				productName = "Wii U controller";
				imageLocation = "images/img_wiiu_controller.jpg";
				productPrice = 40;
			}else if (request.getParameter("Wii_controler") != null){
				productName = "Wii controller";
				imageLocation = "images/img_wii_controller.jpg";
				productPrice = 40;
			}
			if (request.getParameter("XBox_Original") != null){
				productName = "X Box Original";
				imageLocation = "images/img_XBoxOriginal.jpg";
				productPrice = 80;
			}else if (request.getParameter("XBox_360") != null){
				productName = "X Box 360";
				imageLocation = "images/img_XBox360.jpg";
				productPrice = 300;
			}else if (request.getParameter("XBox_One") != null){
				productName = "X Box One";
				imageLocation = "images/img_XBoxOne.jpg";
				productPrice = 500;
			}else if (request.getParameter("XBox_360_controller") != null){
				productName = "X Box 360 controller";
				imageLocation = "images/img_Xbox_360_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_one_controller") != null){
				productName = "X Box One controller";
				imageLocation = "images/img_Xbox_one_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("XBox_orginal_controller") != null){
				productName = "X Box Original controller";
				imageLocation = "images/img_Xbox_original_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation_2") != null){
				productName = "PlayStation 2";
				imageLocation = "images/img_PlayStation2.jpg";
				productPrice = 60;
			}else if (request.getParameter("PlayStation_3") != null){
				productName = "PlayStation 3";
				imageLocation = "images/img_PlayStation3.jpg";
				productPrice = 220;
			}else if (request.getParameter("PlayStation_4") != null){
				productName = "PlayStation 4";
				imageLocation = "images/img_PlayStation4.jpg";
				productPrice = 400;
			}else if (request.getParameter("PlayStation2_controller") != null){
				productName = "PlayStation2 controller";
				imageLocation = "images/img_Playstation2_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation3_controller") != null){
				productName = "PlayStation3 controller";
				imageLocation = "images/img_Playstation3_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("PlayStation4_controller") != null){
				productName = "PlayStation4 controller";
				imageLocation = "images/img_Playstation4_controller.jpg";
				productPrice = 50;
			}else if (request.getParameter("Wii_Console") != null){
				productName = "Wii Console";
				imageLocation = "images/img_wii_console.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_Console2") != null){
				productName = "Wii Console2";
				imageLocation = "images/img_wii_console2.jpg";
				productPrice = 400;
			}else if (request.getParameter("Wii_U_controller") != null){
				productName = "Wii U controller";
				imageLocation = "images/img_wiiu_controller.jpg";
				productPrice = 40;
			}else if (request.getParameter("Wii_controller") != null){
				productName = "Wii controller";
				imageLocation = "images/img_wii_controller.jpg";
				productPrice = 40;
			}
			
			//check for user session
			if(session.getAttribute("userid")==null)
			{
%>
									<h1>User not Logged In</h1>
									<form action="login.jsp">
									<input type="submit" name="loginUnSuccessful" value="Login">
									</form>		
<%	
			}else					
			{
				useridSession=(String)session.getAttribute("userid");

%>
		
	<h3><%=productName%></h3>
		
	<form method="get" action="SubmitReview.jsp">
		
		<fieldset>
			<legend>Product information:</legend>
			<img src = <%=imageLocation%> width = "200" height = "200" alt = "Product Image">
			<table>
				<tr>
					<td> Product Name: </td>
					<td> <input type="text" name="productName" value = '<%=productName%>' readonly> </td>
				</tr>
				
				<tr>
					<td> Product Price: </td>
					<td> <input type="text" name="productPrice" value = '<%=productPrice%>' readonly> </td>
				</tr>
			</table>
		</fieldset>
		
		<fieldset>
			<legend>Reviews:</legend>
			<table>
				<tr>
					<td> Product Name: </td>
					<td> <input type="text" name="productName" value = '<%=productName%>'>  </td>
				</tr>
				
				<tr>
                                <td> Product Category: </td>
                                <td>
                                    <select name="productCategory">
                                        <option value="Console" selected>Game Console</option>
                                        <option value="Game">Game</option>
                                        <option value="Accessories">Accessories</option>
                                </td>
                            </tr>

                            
                            <tr>
                                <td> Product Price: </td>
                                <td>
                                    <input type="number" name="productPrice" value='<%=productPrice%>' size=10 class="s" /> </td>
                            </tr>

                            <tr>
                                <td> Retailer Name: </td>
                                <td>
                                    <select name="retailerName">
                                        <option value="GameSpeed" selected>GameSpeed</option>
                                        <option value="Walmart">Walmart</option>
                                        <option value="BestBuy">BestBuy</option>
                                        
                                </td>
                            </tr>



                            <tr>
                                <td> Retailer Zip code: </td>
                                <td>
                                    <input type="number" name="retailerZipcode" size=10/> </td>
                            </tr>

                            <tr>
                                <td> Retailer City: </td>
                                <td>
                                    <input type="text" name="retailerCity" class="s" /> </td>
                            </tr>

                            <tr>
                                <td> Retailer State: </td>
                                <td>
                                    <input type="text" name="retailerState" class="s" /> </td>
                            </tr>

                            <tr>
                                <td> Product On Sale: </td>
                                <td>
                                    <input type="radio" name="productOnSale" value="Yes" /> Yes
                                    <input type="radio" name="productOnSale" value="No" /> No</td>
                            </tr>


                            <tr>
                                <td> Product Manufacturer: </td>
                                <td>
                                    <select name="consoleManufacturer">
                                        <option value="Microsoft" selected>Microsoft</option>
                                        <option value="Sony">Sony</option>
                                        <option value="Nintendo">Nintendo</option>
                                        <option value="ElectronicArts">Electronic Arts</option>
                                        <option value="Activision">Activision</option>
                                        <option value="TakeTwoInteractive">Take-Two Interactive</option>
                                </td>
                            </tr>

                            <tr>
                                <td> Manufacture Rebate: </td>
                                <td>
                                    <input type="radio" name="manufacturerRebate" value="Yes" /> Yes
                                    <input type="radio" name="manufacturerRebate" value="No" /> No
								</td>
                            </tr>



                            <tr>
                                <td> User ID: </td>
                                <td>
                                     <input type="text" name="userId" value="<%=useridSession%>"class="s" /> </td>
                            </tr>

                            <tr>
                                <td> User Age: </td>
                                <td>
                                    <input type="number" name="userAge" class="s" /> </td>
                            </tr>

                            <tr>
                                <td> User Gender: </td>
                                <td>
                                    <input type="radio" name="userGender" value="Male" /> Male
                                    <input type="radio" name="userGender" value="Female" /> Female</td>
                            </tr>

                            <tr>
                                <td> User Occupation: </td>
                                <td>
                                    <input type="text" name="userOccupation" class="s" /> </td>
                            </tr>


                            <tr>
                                <td> Review Rating: </td>
                                <td>
                                    <select name="reviewRating">
                                        <option value="1" selected>1</option>
                                        <option value="2">2</option>
                                        <option value="3">3</option>
                                        <option value="4">4</option>
                                        <option value="5">5</option>
                                </td>
                            </tr>

                            <tr>
                                <td> Review Date: </td>
                                <td>
                                    <input type="date" name="reviewDate" size=10/> </td>
                            </tr>

                            <tr>
                                <td> Review Text: </td>
                                <td>
                                    <textarea name="reviewText" rows="4" cols="50"> </textarea>
                                </td>
                            </tr>

                            <tr>
                                <td>
                                    <input type="submit" value="Submit Review" class="formbutton" /> </td>
                                <td></td>
                            </tr>


				
			</table>
				
		</fieldset>
		
	</form>
<%	
	}

%>
	
</body>
</html>