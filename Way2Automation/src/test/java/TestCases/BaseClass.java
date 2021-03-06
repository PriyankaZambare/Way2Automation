package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import Utilities.ReadConfig;

public class BaseClass {
	
	ReadConfig readconfig=new  ReadConfig();
public String BaseURL=readconfig.getApplicationURL();
public String username=readconfig.getUsername();
public String password=readconfig.getPassword();

static WebDriver driver;
static Logger logger;

@Parameters("browser")
@BeforeClass
public void Setup(String br)
{
	logger=Logger.getLogger("Way2Automation");
	PropertyConfigurator.configure("Log4j.properties");
	if(br.equals("Chrome"))
	{
		System.setProperty("webdriver.chrome.driver",readconfig.getChromepath());
		driver=new ChromeDriver();
	}
	else if(br.equals("Firefox"))
	{
		System.setProperty("webdriver.gecko.driver",readconfig.getFirefoxpathh());
		driver=new FirefoxDriver();
	}
	
	else if(br.equals("IE"))
	{
		System.setProperty("webdriver.ie.driver",readconfig.getiepath());
		driver=new InternetExplorerDriver();
	}
	
	driver.get(BaseURL);
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	
}

@AfterClass
public void tearDown() throws InterruptedException
{
	Thread.sleep(5000);
//	driver.quit();
}

public void CaptureSreen(WebDriver driver,String tname) throws IOException
{
	TakesScreenshot ts=(TakesScreenshot)driver;
	File Source=ts.getScreenshotAs(OutputType.FILE);
	File Target=new File(System.getProperty("user.dir")+"/Screenshots/"+tname+".png");
	FileUtils.copyFile(Source, Target);
}

}
