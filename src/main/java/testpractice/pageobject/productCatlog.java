package testpractice.pageobject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import testpractice.abstractComponents.AbstractComponent;

public class productCatlog extends AbstractComponent{

	WebDriver driver;

	public productCatlog(WebDriver driver) {
		// TODO Auto-generated constructor stub
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

		@FindBy(css=".mb-3")
		List <WebElement> products;
		
		
		
		By productBy = By.cssSelector(".mb-3");
		By addToCart = By.cssSelector(".btn.w-10.rounded");
		By tostmessage = By.id("toast-container");
		By cartheader = By.xpath("//button[@routerlink='/dashboard/cart']");
	
//		WebElement userEmail=driver.findElement(By.id("userEmail"));
		
		public List<WebElement> getProductList()
		{
			waitForElementToAppear(productBy);
			return products;
		}
	
		public WebElement getproductName(String ProductName) 
		{
//			List <WebElement> products=	driver.findElements(By.cssSelector(".mb-3"));
			WebElement prod =getProductList().stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(ProductName)).findFirst().orElse(null);
			return prod;
		}
		
		
		
		public void addProductToCart(String ProductName)
		{
			WebElement prod=getproductName(ProductName);
			prod.findElement(addToCart).click();
			waitForElementToAppear(tostmessage);
		
		
		}
		
	

}
