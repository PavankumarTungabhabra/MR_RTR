package Greenkart.EcommarceApplication.Resources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	
	public static ExtentReports getReporterObject()
	{
		
		ExtentSparkReporter reporter=new ExtentSparkReporter(System.getProperty("user.dir")+"//extentReports//index.html");
		reporter.config().setReportName("AutomationExecutionReport");
		reporter.config().setDocumentTitle("GreenKartApplication");
		ExtentReports extent=new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Prarthana");
		return extent;
		
	}

}
