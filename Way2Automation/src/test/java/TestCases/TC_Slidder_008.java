package TestCases;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.Slidder;

public class TC_Slidder_008 extends BaseClass {
	
	@Test
	public void SlidderAction() throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.ClkLoginBtn();
		
		Slidder s=new Slidder(driver);
		s.ClkImgSlidder();
		
	}

}
