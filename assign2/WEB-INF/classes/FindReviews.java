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
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;
import com.mongodb.AggregationOutput;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;

public class FindReviews extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	MongoClient mongo;
	
	public void init() throws ServletException{
      	// Connect to Mongo DB
		mongo = new MongoClient("localhost", 27017);
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		
		PrintWriter output = response.getWriter();
					
		DB db = mongo.getDB("assign1");
		
		// If the collection does not exists, MongoDB will create it for you
		DBCollection myReviews = db.getCollection("myReviews");
		
		BasicDBObject query = new BasicDBObject();
				
		try {
			
			// Get the form data
			String productName = request.getParameter("productName");
			String productCategory = request.getParameter("productCategory");
			int productPrice = Integer.parseInt(request.getParameter("productPrice"));
			String retailerZipcode = request.getParameter("retailerZipcode");
			String retailerCity = request.getParameter("retailerCity");
			String retailerState = request.getParameter("retailerState");
			String consoleManufacturer = request.getParameter("consoleManufacturer");
			String productOnSale = request.getParameter("productOnSale");
			String manufacturerRebate = request.getParameter("manufacturerRebate");
			String userID = request.getParameter("userID");
			String userAge = request.getParameter("userAge");
			String userGender = request.getParameter("userGender");
			
			String userOccupation = request.getParameter("userOccupation");
			String reviewDate = request.getParameter("reviewDate");
			
			
			String retailerName = request.getParameter("retailerName");
			int reviewRating = Integer.parseInt(request.getParameter("reviewRating"));
			String compareRating = request.getParameter("compareRating");
			String comparePrice = request.getParameter("comparePrice");
			String returnValueDropdown = request.getParameter("returnValue");
			String groupByDropdown = request.getParameter("groupByDropdown");
			String advSearchDropdown = request.getParameter("advSearchDropdown");
			String top5LikedProduct = request.getParameter("top5LikedProduct");
			String ret = request.getParameter("returnValue");
			
			//Boolean flags to check the filter settings
			boolean noFilter = false;
			boolean filterByProduct = false;
			boolean filterByProductCategory = false;
			boolean filterByPrice = false;	
			boolean filterByName = false;
			boolean filterByZip = false;
			boolean filterByCity = false;
			boolean filterByState = false;
			boolean filterByOnSale = false;
			boolean filterByManufacturer = false;
			boolean filterByRebate = false;
			boolean filterByID = false;
			boolean filterByAge = false;
			boolean filterByGender = false;
			boolean filterByOccupation = false;
			boolean filterByRating = false;
			boolean filterByDate = false;
		    boolean filterByLikedProduct = false;
			
			boolean groupBy = false;
			boolean groupByCity = false;
			boolean groupByProduct = false;
			boolean groupByRetailerName = false;
			
			
			boolean advSearch = false;
			boolean highestByCity = false;
			boolean highestByZipcode = false;
			
			
			boolean countOnly = false;
						
			//Get the filters selected
			//Filter - Simple Search
			String[] filters = request.getParameterValues("queryCheckBox");
			//Filters - Group By
			String[] extraSettings = request.getParameterValues("extraSettings");
			
			DBCursor dbCursor = null;
			AggregationOutput aggregateData = null;
			
			//Check for extra settings(Grouping Settings)
			if(extraSettings != null){				
				//User has selected extra settings
				groupBy=true;
				advSearch=true;
				for(int x = 0; x <extraSettings.length; x++){
					switch (extraSettings[x]){						
						case "COUNT_ONLY":
							//Not implemented functionality to return count only
							countOnly = true;				
							break;
						case "GROUP_BY":	
							//Can add more grouping conditions here
							if(groupByDropdown.equals("GROUP_BY_CITY")){
								groupByCity = true;
							}else if(groupByDropdown.equals("GROUP_BY_PRODUCT")){
								groupByProduct = true;
							}else if(groupByDropdown.equals("GROUP_BY_RETAILERNAME")){
								groupByRetailerName = true;
							} 							
							break;
						case "ADV_SEARCH":	
							//Can add more grouping conditions here
							if(advSearchDropdown.equals("HIGHEST_BY_CITY")){
								highestByCity = true;
							}else if(advSearchDropdown.equals("HIGHEST_BY_ZIPCODE")){
								highestByZipcode = true;
							} 							
							break;
					
					}		
				}				
			}			
			
			//Check the main filters only if the 'groupBy' option is not selected
			if(filters != null && groupBy != true && advSearch != true){
				for (int i = 0; i < filters.length; i++) {
					//Check what all filters are ON
					//Build the query accordingly
					switch (filters[i]){										
						case "productName":							
							filterByProduct = true;
							if(!productName.equals("ALL_PRODUCTS")){
								query.put("productName", productName);
							}						
							break;
							
						case "productCategory":							
							filterByProductCategory = true;
							
								query.put("productCategory", productCategory);
													
							break;
							
						case "productPrice":
							filterByPrice = true;
							if (comparePrice.equals("EQUALS_TO")) {
								query.put("productPrice", productPrice);
							}else if(comparePrice.equals("GREATER_THAN")){
								query.put("productPrice", new BasicDBObject("$gt", productPrice));
							}else if(comparePrice.equals("LESS_THAN")){
								query.put("productPrice", new BasicDBObject("$lt", productPrice));
							}
							break;
																			
						case "retailerName":
							filterByName = true;
							query.put("retailerName", retailerName);
							break;
						
						case "retailerZipcode":
							filterByZip = true;
							query.put("retailerZipcode", retailerZipcode);
							break;
												
						case "retailerCity": 
							filterByCity = true;
							if(!retailerCity.equals("All") && !groupByCity){
								query.put("retailerCity", retailerCity);
							}							
							break;
					
						case "retailerState":
							filterByState = true;
							query.put("retailerState", retailerState);
							break;
					
						case "consoleManufacturer":
							filterByManufacturer = true;
							query.put("consoleManufacturer", consoleManufacturer);
							break;
					
						
						case "productOnSale":
							filterByOnSale = true;
							query.put("productOnSale", productOnSale);
							break;
					
						case "manufacturerRebate":
							filterByRebate = true;
							query.put("manufacturerRebate", manufacturerRebate);
							break;
					
						case "userID":
							filterByID = true;
							query.put("userID", userID);
							break;
						
						case "userAge":
							filterByAge= true;
							query.put("userAge", userAge);
							break;
						
							
						case "userGender":
							filterByGender= true;
							query.put("userGender", userGender);
							break;
					
						case "userOccupation":
							filterByOccupation= true;
							query.put("userOccupation", userOccupation);
							break;
					
						case "reviewRating":	
							filterByRating = true;
							if (compareRating.equals("EQUALS_TO")) {
								query.put("reviewRating", reviewRating);
							}else{
								query.put("reviewRating", new BasicDBObject("$gt", reviewRating));
							}
							break;
					
						case "reviewDate":
							filterByDate= true;
							query.put("reviewDate", reviewDate);
							break;

            		
						case "top5LikedProduct":	
							//Can add more grouping conditions here
							filterByLikedProduct= true;							
							break;								
						
						default:
							//Show all the reviews if nothing is selected
							noFilter = true;
							break;						
					}				
				}
			}
			else if(filters != null && groupBy == true ){
			
			for (int i = 0; i < filters.length; i++) {
					//Check what all filters are ON
					//Build the query accordingly
					switch (filters[i]){										
						case "productName":							
							filterByProduct = true;
							if(!productName.equals("ALL_PRODUCTS")){
								query.put("productName", productName);
							}						
							break;
						
						case "productCategory":							
							filterByProductCategory = true;
							if(!productCategory.equals("ALL")){
								query.put("productCategory", productCategory);
							}						
							break;
												
						case "productPrice":
							filterByPrice = true;
							if (comparePrice.equals("EQUALS_TO")) {
								query.put("productPrice", productPrice);
							}else if(comparePrice.equals("GREATER_THAN")){
								query.put("productPrice", new BasicDBObject("$gt", productPrice));
							}else if(comparePrice.equals("LESS_THAN")){
								query.put("productPrice", new BasicDBObject("$lt", productPrice));
							}
							break;
												
						case "retailerZipcode":
							filterByZip = true;
							query.put("retailerZipcode", retailerZipcode);
							break;
												
						case "retailerCity": 
							filterByCity = true;
							if(!retailerCity.equals("All") && !groupByCity){
								query.put("retailerCity", retailerCity);
							}							
							break;
												
						case "reviewRating":	
							filterByRating = true;
				    	break;
													
						default:
							//Show all the reviews if nothing is selected
							noFilter = true;
							break;						
					}				
				}
			}else{
			
				//Show all the reviews if nothing is selected
				noFilter = true;
			}
			
						
			//Construct the top of the page
			constructPageTop(output);
						
			//Run the query 
			if(groupBy == true){		
				//Run the query using aggregate function
				DBObject match = null;
				DBObject sort = null;
				//DBObject limit = null;
				DBObject groupFields = null;
				DBObject group = null;
				DBObject projectFields = null;
				DBObject project = null;
				AggregationOutput aggregate = null;
				
			if(groupByCity){

			if(filters != null){
				for (int i = 0; i < filters.length; i++) {
					//Check what all filters are ON
					//Build the query accordingly
				switch (filters[i]){										
				
				case "reviewRating":
						
			/*----------------Group by and Review Rating-------------------*/			
						
					
					match = new BasicDBObject("$match",new BasicDBObject("reviewRating",reviewRating));
					
					
					groupFields = new BasicDBObject("_id", 0);
					groupFields.put("_id", "$retailerCity");
					groupFields.put("count", new BasicDBObject("$sum", 1));
					groupFields.put("productName", new BasicDBObject("$push", "$productName"));
					groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
					groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					
					group = new BasicDBObject("$group", groupFields);

					projectFields = new BasicDBObject("_id", 0);
					projectFields.put("City", "$_id");
					projectFields.put("Review Count", "$count");
					projectFields.put("Product", "$productName");
					projectFields.put("User", "$userName");
					projectFields.put("Reviews", "$review");
					projectFields.put("Rating", "$rating");
					
					project = new BasicDBObject("$project", projectFields);
					
					aggregate = myReviews.aggregate(match,group, project);
												
					//Construct the page content
					constructGroupReviewContent(aggregate, output, countOnly);
					break;
					
				case "top5LikedProduct":
							
					sort = new BasicDBObject("$sort",new BasicDBObject("reviewRating",-1));
		
					groupFields = new BasicDBObject("_id", 0);
					groupFields.put("_id", "$retailerCity");
					groupFields.put("count", new BasicDBObject("$sum", 1));
					groupFields.put("productName", new BasicDBObject("$push", "$productName"));
					groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
					groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					
					group = new BasicDBObject("$group", groupFields);

					projectFields = new BasicDBObject("_id", 0);
					projectFields.put("City", "$_id");
					projectFields.put("Review Count", "$count");
					projectFields.put("Product", "$productName");
					projectFields.put("User", "$userName");
					projectFields.put("Reviews", "$review");
					projectFields.put("Rating", "$rating");
					
					project = new BasicDBObject("$project", projectFields);
					
					aggregate = myReviews.aggregate(sort,group,project);
												
					//Construct the page content
					constructTop5LikedReviewContent(aggregate, output, countOnly);
					break;
				
					}
				}
			}
		    else
			{
						groupFields = new BasicDBObject("_id", 0);
						groupFields.put("_id", "$retailerCity");
						groupFields.put("count", new BasicDBObject("$sum", 1));
						groupFields.put("productName", new BasicDBObject("$push", "$productName"));
						groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
						groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					
						group = new BasicDBObject("$group", groupFields);

						projectFields = new BasicDBObject("_id", 0);
						projectFields.put("City", "$_id");
						projectFields.put("Review Count", "$count");
						projectFields.put("Product", "$productName");
						projectFields.put("User", "$userName");
						projectFields.put("Reviews", "$review");
						projectFields.put("Rating", "$rating");
					
						project = new BasicDBObject("$project", projectFields);
					
						aggregate = myReviews.aggregate(group, project);
												
						//Construct the page content
						constructGroupByCityContent(aggregate, output, countOnly);
				}
					
				}else if(groupByProduct)
				{
					

					groupFields = new BasicDBObject("_id", 0);
					groupFields.put("_id", "$productName");
					groupFields.put("count", new BasicDBObject("$sum", 1));
					groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
					groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					
					group = new BasicDBObject("$group", groupFields);

					projectFields = new BasicDBObject("_id", 0);
					projectFields.put("Product", "$_id");
					projectFields.put("Review Count", "$count");
					projectFields.put("Reviews", "$review");
					projectFields.put("Rating", "$rating");
										
					project = new BasicDBObject("$project", projectFields);
					
					aggregate = myReviews.aggregate(group, project);				
							
					//Construct the page content
					constructGroupByProductContent(aggregate, output, countOnly);
					
				}else if(groupByRetailerName){	

					groupFields = new BasicDBObject("_id", 0);
					groupFields.put("_id", "$retailerName");
					groupFields.put("count", new BasicDBObject("$sum", 1));
					groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
					groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					
					group = new BasicDBObject("$group", groupFields);

					projectFields = new BasicDBObject("_id", 0);
					projectFields.put("Retailer", "$_id");
					projectFields.put("Review Count", "$count");
					projectFields.put("Reviews", "$review");
					projectFields.put("Rating", "$rating");
										
					project = new BasicDBObject("$project", projectFields);
					
					aggregate = myReviews.aggregate(group, project);				
							
					//Construct the page content
					constructGroupByRetailerNameContent(aggregate, output, countOnly);
					
				}			 
			}
				
			/*----------------Advanced Search-------------------*/
			if(advSearch == true){		
				//Run the query using aggregate function
				DBObject match = null;
				DBObject groupFields = null;
				DBObject group = null;
				DBObject projectFields = null;
				DBObject project = null;
				AggregationOutput aggregate = null;
				
				if(highestByCity){
					
					groupFields = new BasicDBObject("_id", 0);
					groupFields.put("_id", "$retailerCity");
					//groupFields.put("productName","$productName");
					groupFields.put("count", new BasicDBObject("$sum", 1));
					groupFields.put("maxPrice", new BasicDBObject("$max", "$productPrice"));
					groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
					groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					groupFields.put("productName", new BasicDBObject("$push", "$productName"));
					
					group = new BasicDBObject("$group", groupFields);

					projectFields = new BasicDBObject("_id", 0);
					projectFields.put("City", "$_id");
					projectFields.put("Review Count", "$count");
			
					projectFields.put("ProductMaxPrice","$maxPrice");
					projectFields.put("ProductName", "$productName");
			
					projectFields.put("Reviews", "$review");
					projectFields.put("Rating", "$rating");
					
					project = new BasicDBObject("$project", projectFields);
					
					aggregate = myReviews.aggregate(group, project);
												
					//Construct the page content
					constructHighestByCityContent(aggregate, output, countOnly);
					
				}else if(highestByZipcode){
					
					groupFields = new BasicDBObject("_id", 0);
					groupFields.put("_id", "$retailerZipcode");
					
					groupFields.put("count", new BasicDBObject("$sum", 1));
					groupFields.put("maxPrice", new BasicDBObject("$max", "$productPrice"));
					groupFields.put("review", new BasicDBObject("$push", "$reviewText"));
					groupFields.put("rating", new BasicDBObject("$push", "$reviewRating"));
					groupFields.put("productName", new BasicDBObject("$push", "$productName"));
						
					groupFields.put("productName", new BasicDBObject("$push", "$productName"));
					
					group = new BasicDBObject("$group", groupFields);

					projectFields = new BasicDBObject("_id", 0);
					projectFields.put("Zipcode", "$_id");
					projectFields.put("Review Count", "$count");
					projectFields.put("ProductMaxPrice","$maxPrice");
					projectFields.put("ProductName", "$productName");
					projectFields.put("Reviews", "$review");
					projectFields.put("Rating", "$rating");
					
					
					project = new BasicDBObject("$project", projectFields);
					
					aggregate = myReviews.aggregate(group, project);
												
					//Construct the page content
					constructHighestByZipcodeContent(aggregate, output, countOnly);
					
				}			 
			}			
			else{
				//Check the return value selected
				int returnLimit = 0;
				
				//Create sort variable
				DBObject sort = new BasicDBObject();
												
				if (returnValueDropdown.equals("TOP_5")){
					//Top 5 - Sorted by review rating
					returnLimit = 5;
					sort.put("reviewRating",-1);
					dbCursor = myReviews.find(query).limit(returnLimit).sort(sort);
				}else if (returnValueDropdown.equals("TOP_10")){
					//Top 10 - Sorted by review rating
					returnLimit = 10;
					sort.put("reviewRating",-1);
					dbCursor = myReviews.find(query).limit(returnLimit).sort(sort);
				}else if (returnValueDropdown.equals("LATEST_5")){
					//Latest 5 - Sort by date
					returnLimit = 5;
					sort.put("reviewDate",-1);
					dbCursor = myReviews.find(query).limit(returnLimit).sort(sort);
				}else if (returnValueDropdown.equals("LATEST_10")){
					//Latest 10 - Sort by date
					returnLimit = 10;
					sort.put("reviewDate",-1);
					dbCursor = myReviews.find(query).limit(returnLimit).sort(sort);
				}else{
					//Run the simple search query(default result)
					dbCursor = myReviews.find(query);
				}		
				
				//Construct the page content
				constructDefaultContent(dbCursor, output, countOnly);
			}			
			
	//for advanced search
			//Construct the bottom of the page
			constructPageBottom(output);
			
			
		} catch (MongoException e) {
			e.printStackTrace();
		}

	}
	
	public void constructPageTop(PrintWriter output){
		String pageHeading = "Query Result";
		String myPageTop = "<!DOCTYPE html>" + "<html lang=\"en\">"
					+ "<head>	<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />"
					+ "<title>Game Speed</title>"
					+ "<link rel=\"stylesheet\" href=\"styles.css\" type=\"text/css\" />"
					+ "</head>"
					+ "<body>"
					+ "<div id=\"container\">"
					+ "<header>"
					+ "<h1><a href=\"/\">GameSpeed<span></span></a></h1><h2>Tutorial 3</h2>"
					+ "</header>"
					+ "<nav>"
					+ "<ul>"
					+ "<li class=\"\"><a href=\"Index.html\">Home</a></li>"
					+ "<li class = \"\"><a href=\"WriteReview.html\">Write Review</a></li>"
					+ "<li class = \"start selected\"><a href=\"DataAnalytics.html\">Data Analytics</a></li>"
					+ "</ul>"
					+ "</nav>"
					+ "<div id=\"body\">"
					+ "<section id=\"review-content\">"
					+ "<article>"
					+ "<h2 style=\"color:#DE2D3A;font-weight:700;\">" +pageHeading + "</h2>";
		
		output.println(myPageTop);		
	}
	
	public void constructPageBottom(PrintWriter output){
		String myPageBottom = "</article>"
					+ "</section>"
                    + "<div class=\"clear\"></div>"
					+ "</div>"
					+ "<footer>"
					+ "<div class=\"footer-content\">"
					+ "<ul>"
                    + "<li>"
                    + "<h4>Dummy Link Section 1</h4>"
                    + "</li>"
                    + "<li><a href=\"#\">Dummy Link 1</a>"
                    + "</li>"
                    + "<li><a href=\"#\">Dummy Link 2</a>"
                    + "</li>"
                    + "<li><a href=\"#\">Dummy Link  3</a>"
                    + "</li>"
					+ "</ul>"
					+ "<div class=\"clear\"></div>"
					+ "</div>"
					+ "<div class=\"footer-bottom\">"
					+ "<p>CSP 595 - Enterprise Web Application - Assignment#3</p>"
					+ "</div>"
					+ "</footer>"
					+ "</div>"
					+ "</body>"
					+ "</html>";
		
		output.println(myPageBottom);
	}
	
	public void constructDefaultContent(DBCursor dbCursor, PrintWriter output, boolean countOnly){
		int count = 0;
		String tableData = " ";
		String pageContent = " ";

		while (dbCursor.hasNext()) {		
			BasicDBObject bobj = (BasicDBObject) dbCursor.next();
			tableData =  "<tr><td>Name: <b>     " + bobj.getString("productName") + " </b></td></tr>"
						+ "<tr><td>Price:       " + bobj.getInt("productPrice") + "</br>"
						+ "Retailer:            " + bobj.getString("retailerName") + "</br>"
						+ "Retailer Zipcode:    " + bobj.getString("retailerZipcode") + "</br>"
						+ "Retailer City:       " + bobj.getString("retailerCity") + "</br>"
						+ "Retailer State:      " + bobj.getString("retailerState") + "</br>"
						+ "Sale:                " + bobj.getString("productOnSale") + "</br>"
						+ "User ID:             " + bobj.getString("userID") + "</br>"
						+ "User Age:            " + bobj.getString("userAge") + "</br>"
						+ "User Gender:         " + bobj.getString("userGender") + "</br>"
						+ "User Occupation:     " + bobj.getString("userOccupation") + "</br>"
						+ "Manufacturer:        " + bobj.getString("consoleManufacturer") + "</br>"
						+ "Manufacturer Rebate: " + bobj.getString("manufacturerRebate") + "</br>"
						+ "Rating:              " + bobj.getString("reviewRating") + "</br>"
						+ "Date:                " + bobj.getString("reviewDate") + "</br>"
						+ "Review Text:         " + bobj.getString("reviewText") + "</td></tr>";
				
			count++;
				
				output.println("<h3>"+count+"</h3>");
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
		}

		//No data found
		if(count == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}
		
	}
	
	public void constructTop5LikedReviewContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
		int i=1;
		int top5=5;
		
		output.println("<h1> Products with reviewed rating  </h1>");		
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productList = (BasicDBList) bobj.get("Product");
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
				
				rowCount++;
				tableData = "<tr><td>City: "+bobj.getString("City")+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
				
				//Now print the products with the given review rating
				while (productCount <5) {
					//i++;
					tableData = "<tr rowspan = \"3\"><td> Product: "+productList.get(productCount)+"</br>"
							+   "Rating: "+rating.get(productCount)+"</br>"
							+	"Review: "+productReview.get(productCount)+"</td></tr>";
												
					pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
					output.println(pageContent);
					
					productCount++;					
				/* 	}
					else{
						i=0;
						break;
					} */
				}	
				
				//Reset product count
				productCount =0;
		}		
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}
		
	}
	
	
	public void constructGroupReviewContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
		
		output.println("<h1> Products with reviewed rating  </h1>");		
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productList = (BasicDBList) bobj.get("Product");
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
				
				rowCount++;
				tableData = "<tr><td>City: "+bobj.getString("City")+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
				
				//Now print the products with the given review rating
				while (productCount < productList.size()) {
					tableData = "<tr rowspan = \"3\"><td> Product: "+productList.get(productCount)+"</br>"
							+   "Rating: "+rating.get(productCount)+"</br>"
							+	"Review: "+productReview.get(productCount)+"</td></tr>";
												
					pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
					output.println(pageContent);
					
					productCount++;					
				}	
				
				//Reset product count
				productCount =0;
		}		
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}
		
	}
	
				
	public void constructHighestByCityContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
	
		int i;
		
		output.println("<h1> Grouped By - City with highest price </h1>");		
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productList = (BasicDBList) bobj.get("ProductName");
				BasicDBList productPrice = (BasicDBList) bobj.get("ProductPrice");
		        int productMaxPrice = Integer.parseInt(bobj.getString("ProductMaxPrice"));
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
			
			rowCount++;
				tableData = "<tr><td>City: "+bobj.getString("City")+"</td>&nbsp"
						+ "<td>Max Price: "+productMaxPrice+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
	
			while (productCount < productList.size()) {
			tableData = "<tr><td>City: "+bobj.getString("City")+"</br>"
					+	"Product Name: "+productList.get(productCount)+"</br>"
					+	"Review: "+productReview.get(productCount)+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";				
					output.println(pageContent);
					productCount++;					
	
			}				
				//Reset product count
				productCount =0;
			}	
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}					
		
	}
	
				
	public void constructHighestByZipcodeContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
		
		
		int i;
		
		output.println("<h1> Grouped By - Zipcode with highest price </h1>");		
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productList = (BasicDBList) bobj.get("ProductName");
				BasicDBList productPrice = (BasicDBList) bobj.get("ProductPrice");
		        int productMaxPrice = Integer.parseInt(bobj.getString("ProductMaxPrice"));
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
			
			rowCount++;
				tableData = "<tr><td>Zipcode: "+bobj.getString("Zipcode")+"</td>&nbsp"	
						+ "<td>Max Price: "+productMaxPrice+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
	
			while (productCount < productList.size()) {
			tableData = "<tr><td>Product Name: "+productList.get(productCount)+"</br>"
					+	"Review: "+productReview.get(productCount)+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";				
					output.println(pageContent);
					productCount++;					
	
			}/* 	
			while (productCount < productList.size()) {
			tableData = "<tr><td>Zipcode: "+bobj.getString("Zipcode")+"</td>&nbsp"
					+	"<td>Product Name: "+productList.get(productCount)+"</td>"
					+	"<td>Product Price: "+productMaxPrice+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";				
					output.println(pageContent);
					productCount++;					
	
			} */				
				//Reset product count
				productCount =0;
			}	
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}					
		
	}
	
	
	public void constructGroupByCityContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int productCount = 0;
		String tableData = " ";
		String pageContent = " ";
		
		output.println("<h1> Grouped By - City </h1>");		
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productList = (BasicDBList) bobj.get("Product");
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
				
				rowCount++;
				tableData = "<tr><td>City: "+bobj.getString("City")+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
				
				//Now print the products with the given review rating
				while (productCount < productList.size()) {
					tableData = "<tr rowspan = \"3\"><td> Product: "+productList.get(productCount)+"</br>"
							+   "Rating: "+rating.get(productCount)+"</br>"
							+	"Review: "+productReview.get(productCount)+"</td></tr>";
												
					pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
					output.println(pageContent);
					
					productCount++;					
				}	
				
				//Reset product count
				productCount =0;
		}		
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}
		
	}
	
				
	
	public void constructGroupByProductContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int reviewCount = 0;
		String tableData = " ";
		String pageContent = " ";
				
		output.println("<h1> Grouped By - Products </h1>");
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
				
				rowCount++;
				tableData = "<tr><td>Product: "+bobj.getString("Product")+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
				
				//Now print the products with the given review rating
				while (reviewCount < productReview.size()) {
					tableData = "<tr rowspan = \"3\"><td>Rating: "+rating.get(reviewCount)+"</br>"
								+ "Review: "+productReview.get(reviewCount)+"</td></tr>";
							
					pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
					output.println(pageContent);
					
					reviewCount++;					
				}
					
				//Reset review count
				reviewCount = 0;
					
		}		
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}
		
	}
	
	public void constructGroupByRetailerNameContent(AggregationOutput aggregate, PrintWriter output, boolean countOnly){
		int rowCount = 0;
		int reviewCount = 0;
		String tableData = " ";
		String pageContent = " ";
				
		output.println("<h1> Grouped By - Products </h1>");
		for (DBObject result : aggregate.results()) {
				BasicDBObject bobj = (BasicDBObject) result;
				BasicDBList productReview = (BasicDBList) bobj.get("Reviews");
				BasicDBList rating = (BasicDBList) bobj.get("Rating");
				
				rowCount++;
				tableData = "<tr><td>Retailer: "+bobj.getString("Retailer")+"</td>&nbsp"
						+	"<td>Reviews Found: "+bobj.getString("Review Count")+"</td></tr>";
				
				pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
			    output.println(pageContent);
				
				//Now print the products with the given review rating
				while (reviewCount < productReview.size()) {
					tableData = "<tr rowspan = \"3\"><td>Rating: "+rating.get(reviewCount)+"</br>"
								+ "Review: "+productReview.get(reviewCount)+"</td></tr>";
							
					pageContent = "<table class = \"query-table\">"+tableData+"</table>";		
					output.println(pageContent);
					
					reviewCount++;					
				}
					
				//Reset review count
				reviewCount = 0;
					
		}		
		
		//No data found
		if(rowCount == 0){
			pageContent = "<h1>No Data Found</h1>";
			output.println(pageContent);
		}
		
	}
}