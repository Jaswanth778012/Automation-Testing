package com.kodnest.TestNGConcept.extentReports;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener {
	
	public ExtentSparkReporter sparkReporter;
	
	public ExtentReports reports;
	
	public ExtentTest test;	
	
	
	public void onStart(ITestContext context)
	{
		System.out.println(System.getProperty("user.dir"));
		sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir")+ "/reports/myReport.html");
		
		sparkReporter.config().setDocumentTitle("Automation report");
		
		sparkReporter.config().setReportName("Smoke Testing");
		
		sparkReporter.config().setTheme(Theme.DARK);
		
		reports = new ExtentReports();
		reports.attachReporter(sparkReporter);
		
		reports.setSystemInfo("ComputerName", "local");
		reports.setSystemInfo("Environment", "QA Automation Test");
		reports.setSystemInfo("TesterName", "Jaswanth");
		reports.setSystemInfo("BrowserName", "Chrome");
	}
	
	public void onTestSuccess(ITestResult result)
	{
		test = reports.createTest(result.getName());
		
		test.log(Status.PASS, "test case got passed" + result.getName());
		
	}
	
	public void onTestFailure(ITestResult result)
	{
		test = reports.createTest(result.getName());
		test.log(Status.FAIL, "Test Case got failed is" + result.getName());
	}
	
	
	
	@Override
	public void onTestSkipped(ITestResult result) {
		test = reports.createTest(result.getName());
		test.log(Status.SKIP, "Test Case got Skipped " + result.getName());
	}

	public void onFinish(ITestContext context)
	{
		reports.flush();
	}
}
