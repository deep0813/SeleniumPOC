package testpractice.test;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import testpractice.TestComponents.BaseTest;
import testpractice.pageobject.CartPage;
import testpractice.pageobject.CheckoutPage;
import testpractice.pageobject.ConfirmationPage;
import testpractice.pageobject.LandingPage;
import testpractice.pageobject.productCatlog;

public class submitOrderTest extends BaseTest {

	 
	@Test(dataProvider="getData", groups="purchase")
	public  void submitOrder(HashMap <String, String> input ) throws IOException, InterruptedException  {
//		String productName = "ZARA COAT 3";

		productCatlog productCatlog= landingpage.loginApplication(input.get("email"),input.get("password"));
	
		
		List <WebElement>products= productCatlog.getProductList();
		productCatlog.addProductToCart(input.get("productname"));
		CartPage cartpage= productCatlog.goToCartPage();
		Boolean match =cartpage.VerifyProductDisplay(input.get("productname"));

		CheckoutPage checkoutPage= cartpage.goToCheckout();

		Assert.assertTrue(match);
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitorder();
		String confirmationMessage= confirmationPage.verifyConfirmation();
		AssertJUnit.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(confirmationMessage);
		
//	public void product catalogtest
	
	}
//		@Test(dependsOnMethods={"SubmitOrder"})
//		public void OrderHistoryTest() {
//			productCatlog productCatlog= landingpage.loginApplication("prakherdeep10@gmail.com", "Prakher@123");
//			OrderPage orderPage = productCatlog.goToCartPage();
//			Assert.assertTrue(orderPage);
//		}
//		
		@DataProvider
		public Object[][] getData() {
			HashMap < String, String> map = new HashMap<String,String>();
			map.put("email", "prakherdeep10@gmail.com");
			map.put("password","Prakher@123");
			map.put("productname","ZARA COAT 3");
			
			HashMap < String, String> map1 = new HashMap<String,String>();
			map1.put("email", "anshika@gmail.com");
			map1.put("password","Iamking@000");
			map1.put("productname","ADIDAS ORIGINAL");
			
			
			return new Object[][] {{map},{map1}};
		
	}
		
		// this will only be run when the test will be fail
	
		
		
		
		
}
