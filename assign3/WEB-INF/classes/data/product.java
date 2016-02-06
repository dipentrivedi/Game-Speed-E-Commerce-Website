package data;

import java.util.*;

/** Simple bean to illustrate the various forms
 *  of jsp:setProperty.
 *  <P>
 *  Taken from Core Servlets and JavaServer Pages 2nd Edition
 *  from Prentice Hall and Sun Microsystems Press,
 *  http://www.coreservlets.com/.
 *  &copy; 2003 Marty Hall; may be freely used or adapted.
 */

public class product {
   
   String productName;
   int quantity;
   int productPrice;

  public product(){ 
	  productName="";
	  quantity=0;
	  productPrice=0;
  }
  
  public product(String productName, int productPrice){
	  this.productName=productName;
	  this.productPrice=productPrice;
	  this.quantity=1;
  }
  
  void addQuantity(){
	  quantity++;
  }
  
	//product name
  public String getProductName() {
    return(productName);
  }
	//product quantity
  public int getProductQuantity() {
    return(quantity);
  }
  
  public void setProductQuantity(int quantity)
  {
	  this.quantity=quantity;
  }
  
	//product price
  public int getProductPrice() {
    return(productPrice);
  }
}
