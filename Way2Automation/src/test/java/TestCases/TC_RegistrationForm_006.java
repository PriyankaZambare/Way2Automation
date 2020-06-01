package TestCases;

import org.sikuli.script.FindFailed;
import org.testng.annotations.Test;

import PageObject.LoginPage;
import PageObject.RegistrationForm;

public class TC_RegistrationForm_006 extends BaseClass {
	
	@Test
	public void RegistrationFORM() throws InterruptedException, FindFailed
	{
		LoginPage lp=new LoginPage(driver);
		lp.ClkSigninLnk();
		lp.SetUsername(username);
		lp.SetPassword(password);
		lp.ClkLoginBtn();
		
		RegistrationForm rf=new RegistrationForm(driver);
		rf.ClkImgRegistration();
		rf.FullFormInfo("BBB", "ZZZ", "9087654312", "pass", "a@gmail.com", "bbb");
		
	}

}
