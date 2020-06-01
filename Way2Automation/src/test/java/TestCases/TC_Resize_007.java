package TestCases;

import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.Resize;

public class TC_Resize_007 extends BaseClass {
	
	@Test(priority=1)
	public void ResizeDefaultF()
	{
		LoginPage lp=new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.ClkLoginBtn();
		
		Resize rz= new Resize(driver);
		rz.ClkImgResize();
		rz.ClkDefaultFun();
	}
	
	@Test(priority=2)
	public void ResizeAnimation()
	{
		Resize rz= new Resize(driver);
		rz.ClkAnimation();
	}
	
	@Test (priority=3)
	public void ConResizeArea()
	{
		Resize rz= new Resize(driver);
		rz.ClkConResizeArea();
	}
	
	

}
