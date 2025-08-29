package purchaseOrder;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class interview {

		public static void main(String[] args) {
		
// Write a Java program to remove spaces and reverse a string like: “This is a Java Program”.

		String str = "This is a Java Program";
		String str1 = str.replaceAll("\\s+", "");
		
		String rev= new StringBuilder(str1).reverse().toString();
		System.out.println("String after removing spaces: "+rev);
			
}
	}


