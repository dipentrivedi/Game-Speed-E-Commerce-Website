import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;

public class Reviews extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	String productName = " ";
	String imageLocation = " ";
	int productPrice = 0;
	
	public void init(){
		//Connect to Mongo DB
		MongoClient mongo = new MongoClient("localhost", 27017);
						
		// if database doesn't exists, MongoDB will create it for you
		DB db = mongo.getDB("assign1");
		
		DBCollection myReviews = db.getCollection("myReviews");
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();

			
		try{
			//Get the values from the form
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
			
			
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Buy</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<h1>Place Order</h1>");							
			out.println("<h3>"+productName+"</h3>");
			
			out.println("<form method=\"get\" action=\"SubmitReview\">");
			out.println("<fieldset>");
			out.println("<legend>Product information:</legend>");
			out.println("<img src = \" "+imageLocation + " \" width = \"200\" height = \"200\" alt = \"Product Image\">");
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>Product Name:</td>");
			out.println("<td> <input type=\"text\" name=\"productName\" value= \'"+productName+"\' readonly> </td>");         
			out.println("</tr>");				
			out.println("<tr>");
			out.println("<td>Product Price: </td>");
			out.println("<td> <input type=\"text\" name=\"productPrice\" value= "+productPrice+" readonly> </td>");
			out.println("</tr>");
			out.println("</table>");
			out.println("</fieldset>");
			
			out.println("<fieldset>");
			out.println("<legend>Product Review:</legend>");
			
			out.println("<table>");
			out.println("<tr>");
			out.println("<td>Product Name:</td>");
			out.println("<td> <input type=\"text\" name=\"productName\" value= \'"+productName+"\' readonly> </td>");         
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Product Category: </td>");
			out.println("<td> <select name=\"productCategory\">"+
								"<option value=\"GameConsole\" selected>GameConsole</option>"+
								"<option value=\"Accessories\">Accessories</option>\"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Product Price: </td>");
			out.println("<td> <input type=\"text\" name=\"productPrice\" value= "+productPrice+" readonly> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Retailer Name: </td>");
			out.println("<td> <select name=\"retailerName\">"+
								"<option value=\"GameSpeed\" selected>GameSpeed</option>"+
								"<option value=\"Walmart\">Walmart</option>"+
								"<option value=\"BestBuy\">BestBuy</option>\"</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Retailer City: </td>");
			out.println("<td> <input type=\"text\" name=\"retailerCity\" > </td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td>Retailer Zipcode: </td>");
			out.println("<td> <input type=\"text\" name=\"retailerZipcode\" > </td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td>Retailer State: </td>");
			out.println("<td> <input type=\"text\" name=\"retailerState\"> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Product OnSale: </td>");
			out.println("<td> <input type=\"text\" name=\"productOnSale\"> </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Manufacturer Name: </td>");
			out.println("<td> <input type=\"text\" name=\"consoleManufacturer\" > </td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Manufacturer Rebate </td>");
			out.println("<td> <input type=\"text\" name=\"manufacturerRebate\"  > </td>");
			out.println("</tr>");
			
			
			out.println("<tr>");
			out.println("<td>User Name:</td>");
			out.println("<td> <input type=\"text\" placeholder=\"Your Name\" name=\"userName\"> </td>");         
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>User Id: </td>");
			out.println("<td> <input type=\"text\" placeholder=\"Your user Id\" name=\"userID\" > </td>");
			out.println("</tr>");
		
	
			out.println("<tr>");
			out.println("<td>User Age: </td>");
			out.println("<td> <input type=\"text\" placeholder=\"Your Age\" name=\"userAge\"  > </td>");
			out.println("</tr>");
				
			
			out.println("<tr>");
			out.println("<td>User Gender: </td>");
			out.println("<td> <input type=\"radio\" name=\"userGender\" value=\"male\">Male");
			out.println("<input type=\"radio\" name=\"userGender\" value=\"female\">Female");
			out.println("<input type=\"radio\" name=\"userGender\" value=\"Others\">Other<br>");
			out.println("</td>");
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>User Occupation: </td>");
			out.println("<td> <input type=\"text\" placeholder=\"Your Occupation\" name=\"userOccupation\"  > </td>");
			out.println("</tr>");
		
			out.println("<tr>");
			out.println("<td>Review Rating:</td>");
			out.println("<td> <select name=\"reviewRating\">"+
								"<option value=\"1\" selected>1</option>"+
								"<option value=\"2\">2</option>"+
								"<option value=\"3\">3</option>"+
								"<option value=\"4\">4</option>"+
								"<option value=\"5\">5</option>\"</td>");         
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Review Date:</td>");
			out.println("<td> <input type=\"text\" placeholder=\"Review Date\" name=\"reviewDate\"> </td>");         
			out.println("</tr>");
			
			out.println("<tr>");
			out.println("<td>Review Text:</td>");
			out.println("<td> <textarea name=\"reviewText\" placeholder=\"Review\" rows=\"4\" cols=\"50\"> </textarea> </td>");         
			out.println("</tr>");
			
			out.println("</table>");	
			
			out.println("<br><br>");
			out.println("<input type=\"submit\" value=\"submit\">");			
			
			out.println("</fieldset>");
			out.println("</form>");	
			out.println("</body>");
			out.println("</html>");
			
				
		} catch (MongoException e) {
		e.printStackTrace();
	    }	
	}
	
}