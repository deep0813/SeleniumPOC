package testpractice.TestComponents;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import testpractice.pageobject.LandingPage;

public class BaseTest {
	public WebDriver driver;
	public LandingPage landingpage;
	public WebDriver initializeDriver() throws IOException {
		// TODO Auto-generated method stub
		
		// properties class
		
		Properties prop =new Properties();
		FileInputStream fis =new FileInputStream(System.getProperty("user.dir") + "//src/main/java/GlobalData.properties");
		prop.load(fis);
		String browserName= prop.getProperty("browser");
		if (browserName.contains("chrome")) {
			
			driver =new ChromeDriver();
	
		}
	 else if(browserName.equalsIgnoreCase("firefox")) 
	 	{
		 	driver =new FirefoxDriver();

		}
	 else if(browserName.equalsIgnoreCase("edge")) 
	 	{
		 	driver =new EdgeDriver();

		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		return driver;
	}

	@BeforeMethod
	public LandingPage launchApplication() throws IOException {
		driver =initializeDriver();
		LandingPage landingpage = new LandingPage(driver);
		landingpage.goTO();
		return landingpage;
	}
	@AfterMethod
	public void teaddown() {
		driver.close();
	}
	




}
