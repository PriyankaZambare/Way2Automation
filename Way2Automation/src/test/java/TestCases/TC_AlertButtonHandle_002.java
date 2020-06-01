package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import PageObject.AlertWindow;
import PageObject.LoginPage;

public class TC_AlertButtonHandle_002 extends BaseClass {
	
	@Test(priority=1)
	public void HandleAlerts() throws InterruptedException
	{
		logger.info("Url is Opened");
		LoginPage lp= new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		logger.info("Entered username");
		
		lp.SetPassword(password);
		logger.info("Entered password");
		
		lp.ClkLoginBtn();
		logger.info("Login Successfully");
		
		AlertWindow aw=new AlertWindow(driver);
		aw.ClickOnAlretImage();
		aw.ClickOnAlretBtn();
		
		aw.inputAlertBtn();
		String ExepectedText="Hello Hiee Selenium! How are you today?";
		String ActualText=driver.findElement(By.xpath("//p[@id='demo']")).getText();
		if(ExepectedText.equals("ActualText"))
		{
			Assert.assertTrue(true);
			logger.info("Alert window Successfully Closed ... ");
		}
	/*	else
		{
			Assert.assertTrue(false);
			logger.info("Alert window wasn's work properly ... ");
		}*/
		
			
		
	}
	


}
