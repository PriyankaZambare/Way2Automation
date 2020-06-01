package TestCases;

import org.testng.annotations.Test;

import PageObject.DropdownBox;
import PageObject.LoginPage;

public class TC_DropdownBoxHandle_003 extends BaseClass{
	
	@Test(priority=1)
	public void HandleDropdown() throws InterruptedException
	{
		LoginPage lp=new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		
		lp.SetPassword(password);

		lp.ClkLoginBtn();
		Thread.sleep(3000);
		
		DropdownBox dp=new DropdownBox(driver);
		dp.ImgDropDown();
		dp.SelectAllCounrtyName();
				
	}
	
	@Test(priority=2)
	public void EnterAllCountryName()
	{
		DropdownBox dp=new DropdownBox(driver);
		dp.ClkEnterCountry();
	}

}
