package testpractice.abstractComponents;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import testpractice.pageobject.CartPage;
import testpractice.pageobject.OrderPage;

public class AbstractComponent {

	WebDriver driver;
// Abstract components are which components are reusable items -> ex: - implicitly wait, explicitly wait 
	
	public  AbstractComponent(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);

	}
	
	@FindBy(xpath="//button[@routerlink='/dashboard/cart']")
	WebElement cartheader;
	
	@FindBy(css= "[routerlink*='myorders']")
	WebElement orderHeader;
	
	
	
	public void waitForElementToAppear(By FindBy)
	{
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(FindBy));
	}
		
//	public void waitForElementToDisappear(WebElement spinner) 
//	{
//		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
//     wait.until(ExpectedConditions.invisibilityOfElementLocated(spinner));
//
//	}
	public CartPage goToCartPage()
	{
		cartheader.click();
		CartPage cartPage =new CartPage(driver);
		return cartPage;
	}
	
	public OrderPage goToOrderPage() {
		orderHeader.click();
		OrderPage orderPage= new OrderPage(driver);
		return orderPage;
		
		
		
	}

}

