package testpractice.test;

import java.time.Duration;
import java.util.List;

import org.apache.hc.core5.util.Asserts;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import testpractice.pageobject.LandingPage;

public class StandAloneTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver =new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/client");
		String email= "prakherdeep10@gmail.com";
		String password="Prakher@123";
		String productName = "ZARA COAT 3";
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.findElement(By.id("userEmail")).sendKeys(email);
		driver.findElement(By.id("userPassword")).sendKeys(password);
		driver.findElement(By.id("login")).click();
		LandingPage landingpage = new LandingPage(driver);
		List <WebElement> products=	driver.findElements(By.cssSelector(".mb-3"));
		WebElement prod =products.stream().filter(product-> product.findElement(By.cssSelector("b")).getText().equals(productName)).findFirst().orElse(null);
		prod.findElement(By.cssSelector(".btn.w-10.rounded")).click();
		
		WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		System.out.println(driver.findElement(By.id("toast-container")).getText());
		wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.id("toast-container"))));
		driver.findElement(By.xpath("//button[@routerlink='/dashboard/cart']")).click();
		List <WebElement> carts =	driver.findElements(By.xpath("//div[@class='infoWrap']//h3"));
		Boolean match = carts.stream().anyMatch(cart -> cart.getText().equalsIgnoreCase(productName));
		Assert.assertTrue(match);
		driver.findElement(By.xpath("//button[.='Checkout']")).click();
		Actions ac= new Actions(driver);
		ac.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
		
		
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
		driver.findElement(By.xpath("//button['.ta-item.list-group-item.ng-star-inserted'][2]")).click();
		Thread.sleep(5000);
		driver.findElement(By.cssSelector(".action__submit")).click();
		System.out.println(driver.findElement(By.cssSelector(".hero-primary")).getText());
		driver.close();
		
	}

}
