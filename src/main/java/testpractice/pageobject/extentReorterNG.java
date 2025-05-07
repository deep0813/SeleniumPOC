package testpractice.pageobject;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class extentReorterNG {

	public static ExtentReports getReportObject() {
		
		String path=System.getProperty("user.dir")+"//reports//index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation results");
		reporter.config().setDocumentTitle("Test Result");
		
		ExtentReports extent =new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("tester", "Prakher Deep");
		return extent;
		
	}

}
