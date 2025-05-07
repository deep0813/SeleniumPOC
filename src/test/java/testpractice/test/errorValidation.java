package testpractice.test;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import org.testng.AssertJUnit;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import testpractice.TestComponents.BaseTest;
import testpractice.pageobject.CartPage;
import testpractice.pageobject.CheckoutPage;
import testpractice.pageobject.productCatlog;

public class errorValidation extends BaseTest{

	
	
	@Test(groups= {"ErrorHandling"})
	public  void submitOrder() throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
		String productName = "ZARA COAT 3";
		landingpage.loginApplication("prakherdeep10@gmail.com", "Prakher@12");
		AssertJUnit.assertEquals("Incorrect email or password.", landingpage.goToErrorValidation());	

	}

	@Test
	public void productValidation() throws InterruptedException {
		
		String productName = "ZARA COAT 3";
		productCatlog productCatlog= landingpage.loginApplication("prakherdeep10@gmail.com", "Prakher@123");
		List <WebElement>products= productCatlog.getProductList();
		productCatlog.addProductToCart(productName);
		CartPage cartpage= productCatlog.goToCartPage();
		Boolean match =cartpage.VerifyProductDisplay("ZARA COAT 34");
//		CheckoutPage checkoutPage= cartpage.goToCheckout();
		Assert.assertFalse(match);
	}
	
	
	
	
}
