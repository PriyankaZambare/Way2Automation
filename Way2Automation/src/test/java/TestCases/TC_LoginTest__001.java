package TestCases;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.LoginPage;

public class TC_LoginTest__001 extends BaseClass {
	
	@Test
	public void LoginTest() throws InterruptedException
	{
		logger.info("Url is Opned");
		LoginPage lp=new LoginPage(driver);
		lp.ClkSigninLnk();
	
		lp.SetUsername(username);
		logger.info("entered Username");
		
		lp.SetPassword(password);
		logger.info("entered Password");
		
	lp.ClkLoginBtn();
		
		if(driver.getTitle().equals("Welcome to the Test Site"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Pass..");
		}
		
		else
		{
			Assert.assertTrue(false);
			logger.info("Login Test Failed....");
		}
		
	}
	
}
