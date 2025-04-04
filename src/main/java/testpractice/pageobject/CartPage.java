package testpractice.pageobject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testpractice.abstractComponents.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	
	@FindBy(xpath= "//button[.='Checkout']")
	WebElement checkoutELe;
	
	@FindBy(css =".cartSection h3")
	private List<WebElement> cartProducts;
	
	
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
		// TODO Auto-generated constructor stub
	}
	
	public Boolean VerifyProductDisplay(String productName) throws InterruptedException {
		Boolean match = cartProducts.stream().anyMatch(product -> product.getText().equalsIgnoreCase(productName));
		Thread.sleep(5000);
		return match;
	}
	public CheckoutPage goToCheckout() {
		checkoutELe.click();
		return new CheckoutPage(driver);
	}
	
}
