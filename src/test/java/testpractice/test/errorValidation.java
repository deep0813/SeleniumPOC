package testpractice.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import testpractice.TestComponents.BaseTest;

public class errorValidation extends BaseTest{

	
	
	@Test
	public  void submitOrder() throws InterruptedException {
		// TODO Auto-generated method stub
		
		String productName = "ZARA COAT 3";
		landingpage.loginApplication("prakherdeep10@gmail.com", "Prakher@12");
		Assert.assertEquals("Incorrect email or password.", landingpage.goToErrorValidation());	

	}

}
