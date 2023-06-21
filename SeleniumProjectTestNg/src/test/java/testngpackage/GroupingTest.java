package testngpackage;

import org.testng.annotations.*;
/*
 * loginByEmail - sanity & regression
 * loginByFacebook - sanity
 * loginByTwitter - regression
 * paymentIn Rupees - sanity
 * paymentInDollar - regression
 * returnPaymentByBank - sanity & regression
 */

public class GroupingTest {
	
	
  @Test(priority = 1, groups= {"sanity", "regression"})
  public void loginByEmail() {
	  System.out.println("loginByEmail");
  }
  
  
  @Test(priority = 1, groups= {"sanity"})
  void loginByFacebook() {
	  System.out.println("loginByFacebook");
  }
  
  
  @Test(priority = 1, groups= {"regression"})
  void loginByTwitter() {
	  System.out.println("loginByTwitter");
  }
  
  
  @Test(priority = 1, groups= {"sanity"})
  void paymentInRupees() {
	  System.out.println("paymentInRupees");
  }
  
  
  @Test(priority = 1, groups= {"regression"})
  void paymentInDollar() {
	  System.out.println("paymentInDollar");
  }
  
  
  @Test(priority = 1, groups= {"sanity", "regression"})
  void returnPayemntBybank() {
	  System.out.println("returnPayemntBybank");
  }
}
