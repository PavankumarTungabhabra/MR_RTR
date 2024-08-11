package Resources;

import java.io.File;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporterNG {
	public static ExtentReports GetReportObject()
	{
		File FilePath = new File(System.getProperty("user.dir")+"//Reports//extentReport.html");
		ExtentSparkReporter reporter=new ExtentSparkReporter(FilePath);
		reporter.config().setDocumentTitle("AutomationExecution Reports");
		reporter.config().setReportName("Execiution");
		ExtentReports extent= new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Pavankumar T");
		return extent;
	}

}
