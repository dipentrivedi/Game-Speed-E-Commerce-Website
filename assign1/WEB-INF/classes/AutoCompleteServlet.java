import java.io.*;
import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.HashMap;
import java.util.Iterator;
import com.mongodb.MongoClient;
import com.mongodb.MongoException;
import com.mongodb.WriteConcern;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCursor;
import com.mongodb.ServerAddress;


/**
 *
 * @author nbuser
 */
public class AutoCompleteServlet extends HttpServlet {

    private ServletContext context;
	MongoClient mongo;
  //  private ComposerData compData = new ComposerData();
   // private HashMap composers = compData.getComposers();

    @Override
    public void init(ServletConfig config) throws ServletException {
        this.context = config.getServletContext();
	mongo = new MongoClient("localhost", 27017);

		  
	}
	

    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException, ServletException {

        String action = request.getParameter("action");
        String targetId = request.getParameter("id");
		
	//	PrintWriter out = response.getWriter();
//		out.println("action = " + action + " && target="+targetId);
        StringBuffer sb = new StringBuffer();

			  //Connect to Mongo DB
		
			DB db = mongo.getDB("assign1");
				
			
			// If the collection does not exists, MongoDB will create it for you
			DBCollection myProducts = db.getCollection("myProducts");
			// Find and display
			DBCursor cursor = myProducts.find();
			
        if (targetId != null) {
            targetId = targetId.trim().toLowerCase();
        } else {
            context.getRequestDispatcher("/error").forward(request, response);
        }

        boolean namesAdded = false;
        if (action.equals("complete")) {

            // check if user sent empty string
            if (!targetId.equals("")) {

                //Iterator it = composers.keySet().iterator();
				
                while (cursor.hasNext()) {
					BasicDBObject doc = (BasicDBObject) cursor.next();
					
					
                   // String id = (String) it.next();
                  //  Composer composer = (Composer) composers.get(id);

                    if (doc.getString("productName").toLowerCase().startsWith(targetId))
					{
						
                        sb.append("<composer>");
                        sb.append("<id>" + doc.getString("productName") + "</id>");
                        sb.append("</composer>");
                        namesAdded = true;
                    }
                }
            }

            if (namesAdded) {
				
                response.setContentType("text/xml");
                response.setHeader("Cache-Control", "no-cache");
                response.getWriter().write("<composers>" + sb.toString() + "</composers>");
            } else {
                //nothing to show
                response.setStatus(HttpServletResponse.SC_NO_CONTENT);
            } 
        }

        if (action.equals("lookup")) {
			
            // put the target composer in the request scope to display 
            if ((targetId != null))
				//&& composers.containsKey(targetId.trim())) {
			{
                context.getRequestDispatcher("/productDetails?id="+request.getParameter("id")).forward(request, response);
            }
        }
    }
}
