package testpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testpractice.abstractComponents.AbstractComponent;

public class LandingPage extends AbstractComponent {

	WebDriver driver;

	public LandingPage(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

		
		
	
//		WebElement userEmail=driver.findElement(By.id("userEmail"));
		
		
		@FindBy(id="userEmail")
		WebElement userEmailElem; 
		
		@FindBy(id="userPassword")
		WebElement passwordElem;
		 
		@FindBy(id="login")
		WebElement submit;
		
		@FindBy(css="[class*='flyInOut']")
		WebElement errorMessage;
		
		public productCatlog loginApplication(String user,String password) {
			userEmailElem.sendKeys(user);
			passwordElem.sendKeys(password);
			submit.click();
			productCatlog productCatlog= new productCatlog(driver);
			return productCatlog;
		}
		
		public void goTO()
		{
			driver.get("https://rahulshettyacademy.com/client");

		
		}
		
		public String goToErrorValidation() throws InterruptedException
		{
			Thread.sleep(1000);
			return errorMessage.getText();
		}
		
	

}
