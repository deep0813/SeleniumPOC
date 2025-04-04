package testpractice.test;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

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
	String productName = "ZARA COAT 3";

	 
	@Test	
	public  void submitOrder() throws IOException, InterruptedException  {
		
		LandingPage landingpage = launchApplication();
		productCatlog productCatlog= landingpage.loginApplication("prakherdeep10@gmail.com", "Prakher@123");
	
		
		List <WebElement>products= productCatlog.getProductList();
		productCatlog.addProductToCart(productName);
		CartPage cartpage= productCatlog.goToCartPage();
		Boolean match =cartpage.VerifyProductDisplay(productName);

		CheckoutPage checkoutPage= cartpage.goToCheckout();

		Assert.assertTrue(match);
		checkoutPage.selectCountry("India");
		ConfirmationPage confirmationPage = checkoutPage.submitorder();
		String confirmationMessage= confirmationPage.verifyConfirmation();
		Assert.assertTrue(confirmationMessage.equalsIgnoreCase("Thankyou for the order."));
		System.out.println(confirmationMessage);
		
	
		
		
		
		
		
	}

}
