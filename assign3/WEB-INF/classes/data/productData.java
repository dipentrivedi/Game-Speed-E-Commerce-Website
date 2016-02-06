package data;
import java.util.*;
//import data.product;

/** Simple bean to illustrate the various forms
 *  of jsp:setProperty.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class productData {
   
   HashMap<String,product> hm1;
	
   String productName;
   int quantity;
   int productPrice;

  public productData(){
	  hm1=new HashMap<String,product>();
	}
  
	//product name
  public HashMap getProductData() {
    return(hm1);
  }
  
  public void addProduct(product p) {
	  product temp=hm1.get(p.getProductName());
	  if(temp==null){
    
	  hm1.put(p.getProductName(),p);
	  }
	  else
	  {
		  temp.addQuantity();
	  }
  }
  
 //product quantity
  public int getProductQuantity(String productName) {
      product temp=hm1.get(productName);
	  if(temp==null){
    
	  return -1;
	  }
	  else
	  {
		  return temp.getProductQuantity();
	  }
  }
  
  public void setProductQuantity(int productQuantity,String productName) {
     product temp=hm1.get(productName);
	
	temp.setProductQuantity(productQuantity);
  }
  
  }
