package testpractice.TestComponents;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import testpractice.pageobject.extentReorterNG;

public class Listeners extends BaseTest implements ITestListener{
	
	ExtentTest test;
	ExtentReports extent=   extentReorterNG.getReportObject();

	    @Override
	    public void onTestStart(ITestResult result) {
	    	test= extent.createTest(result.getMethod().getMethodName());
	    }

	    @Override
	    public void onTestSuccess(ITestResult result) {
	        System.out.println("Test passed: " + result.getName());
	    }

	    @Override
	    public void onTestFailure(ITestResult result) {
	       test.fail(result.getThrowable());
	      
	       try {
			driver = (WebDriver) result.getTestClass().getRealClass().getField("driver").get(result.getInstance());
		} catch (IllegalArgumentException | IllegalAccessException | NoSuchFieldException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       
	       
	       
	       
	       
	       String filePath =null;
	       try {
			filePath = getScreenshot(result.getMethod().getMethodName(),driver);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	       test.addScreenCaptureFromPath(filePath ,result.getMethod().getMethodName());
	    }

	    // You can override other methods if needed
	    
	    public void onFinish(ITestResult sucess) {
	    extent.flush();
	}


}
