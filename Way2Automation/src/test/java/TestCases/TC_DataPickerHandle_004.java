package TestCases;

import org.testng.annotations.Test;

import PageObject.HandleDatapicker;
import PageObject.LoginPage;

public class TC_DataPickerHandle_004 extends BaseClass {
	
	@Test(priority=1)
	public void HandleDefaultFunctionality() throws InterruptedException
	{
		LoginPage lp= new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.ClkLoginBtn();
		
		HandleDatapicker hd=new HandleDatapicker(driver);
		hd.ClkdatapickerImg();
		hd.ClkDefaultFunctionality();
	}
	
	@Test(priority=2)
	public void Animation()
	{
		HandleDatapicker hd=new HandleDatapicker(driver);
		hd.ClickAnimationBtn();
	}
	
	@Test(priority=3)
	public void displayMonthAndYear()
	{
		HandleDatapicker hd=new HandleDatapicker(driver);
		hd.ClkDisplayMonthAndYear();
	}
	
	@Test(priority=4)
	public void Formate_Date()
	{
		HandleDatapicker hd=new HandleDatapicker(driver);
	     hd.ClkFormateDate();
}
	
}
