package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReportUtility {
	public static final ExtentReports extentReports = new ExtentReports();// static instance of extentreports that can
	// be shared accross the application

	public synchronized static ExtentReports createExtentReports() {

		ExtentSparkReporter reporter = new ExtentSparkReporter("./extent-reports/extent-report.html");
		reporter.config().setReportName("GroceryProject");
		extentReports.attachReporter(reporter);

		extentReports.setSystemInfo("Organization", "Obsqura");
		extentReports.setSystemInfo("Name", " Gouri Poornima");// provides context of the report
		extentReports.setSystemInfo("Designation", "QA Analyst");
		return extentReports;

	}
}
