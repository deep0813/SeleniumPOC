package testpractice.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import testpractice.abstractComponents.AbstractComponent;

public class OrderPage extends AbstractComponent{
	
	WebDriver driver;
	
//	@FindBy()
	
	
	
	
	
	
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		}

		
	

}
