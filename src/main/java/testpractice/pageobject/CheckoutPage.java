package testpractice.pageobject;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testpractice.abstractComponents.AbstractComponent;

public class CheckoutPage extends AbstractComponent{

	WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath="//button['.ta-item.list-group-item.ng-star-inserted'][2]")
	WebElement countryName;
	
	@FindBy(css=".action__submit")
	WebElement submit;
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	private WebElement country;
	
	private By results = By.cssSelector(".ta-results");
	
	public void selectCountry(String counrtyName) {
		Actions ac= new Actions(driver);
		ac.sendKeys(country,"India").build().perform();
		waitForElementToAppear(By.cssSelector(".ta-results"));
		countryName.click();
		
	}
	
	public ConfirmationPage submitorder() throws InterruptedException {
		Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).build().perform();
		submit.click();
		return new ConfirmationPage(driver);
	}
	
}
