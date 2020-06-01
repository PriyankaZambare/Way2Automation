package TestCases;

import org.testng.annotations.Test;

import PageObject.ClickMenuClick;
import PageObject.LoginPage;

public class TC_Menu_005 extends BaseClass {

	
	@Test
	public void ClkMenu() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.ClkLoginBtn();
		
		ClickMenuClick cc=new ClickMenuClick(driver);
		cc.ClickImgMenu();
		cc.ClickMenuWithSUbMenu();
		
		
	}
}
