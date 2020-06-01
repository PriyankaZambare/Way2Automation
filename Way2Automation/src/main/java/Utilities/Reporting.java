package Utilities;

import java.io.File;
import java.sql.Driver;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.ITestContext;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;


public class Reporting extends TestListenerAdapter{
	
	public ExtentHtmlReporter htmlreporter;
	public ExtentReports reporters;
	public ExtentTest test;
	
	public void onStart(ITestContext Context)
	{
		String timeSpam=new SimpleDateFormat("yyyy-MM-dd-hh-MM-ss").format(new Date());
		String repName="Test Report"+timeSpam+".html";
		
		htmlreporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/"+repName);
		htmlreporter.loadXMLConfig(System.getProperty("user.dir")+"/extentConfig.xml/");
		
		
		reporters=new ExtentReports();
		
		reporters.attachReporter(htmlreporter);
		
		reporters.setSystemInfo("user","Priya");
		reporters.setSystemInfo("OS", "Windows 10");
		reporters.setSystemInfo("Env","QA");
		
		htmlreporter.config().setDocumentTitle("Way2Automation");
		htmlreporter.config().setReportName("Demo page");
		htmlreporter.config().setTheme(Theme.DARK);
		
	}
	
	public void onTestSuccess(ITestResult tr)
	{
		test=reporters.createTest(tr.getName());
		test.log(Status.PASS, MarkupHelper.createLabel(tr.getName(), ExtentColor.GREEN));
		test.pass("Test Pass...");
	}
	
	public void onTestFailure(ITestResult tr)
	{
		test=reporters.createTest(tr.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel(tr.getName(), ExtentColor.RED));
		test.log(Status.FAIL, "Test Case Failed");
		
		String Screenshotpath= System.getProperty("user.dir")+"/Screenshots/"+tr.getName() +".png";
		File f= new File(Screenshotpath);
		
		if(f.exists())
		try
		{
			test.fail("Screenshots is Below:"+test.addScreenCaptureFromBase64String(Screenshotpath));
		}
				
		catch(Exception e)
		{
			e.printStackTrace();
		}
				
		
	}
	
	public void onTestSkipped(ITestResult tr)
	{
		test=reporters.createTest(tr.getName());
		test.log(Status.SKIP, MarkupHelper.createLabel(tr.getName(), ExtentColor.ORANGE));
		
	}
	
	public void onFinish(ITestContext Context)
	{
		reporters.flush();
	}
	

}
