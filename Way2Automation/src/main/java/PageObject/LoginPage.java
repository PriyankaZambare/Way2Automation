package PageObject;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//a[@href='#login']")
	WebElement SigninLnk;
	
	@FindBy (xpath="/html/body/div[4]/div/div/div/div/div/form/fieldset[1]/input")
	WebElement usernametxt;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/div/div/form/fieldset[2]/input")
	WebElement pwdtxt;
	
	@FindBy(xpath="/html/body/div[4]/div/div/div/div/div/form/div/div[2]/input")
	WebElement submitBtn;
	
	public void ClkSigninLnk()
	{
		SigninLnk.click();
	}
	public void SetUsername(String username) 
	{
//		ldriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 usernametxt.sendKeys(username);
		
	//	JavascriptExecutor javascript = (JavascriptExecutor) ldriver;
	//	javascript.executeScript("var element = document.querySelector('locator'); element.value = 'whatever';");
		
	//    Actions act=new Actions (ldriver);
	//	act.moveToElement(usernametxt).sendKeys(username).build().perform();
		
		
	}
	
	public void SetPassword(String pwd)
	{
		pwdtxt.sendKeys(pwd);
	}
	
	public void ClkLoginBtn()
	{
		submitBtn.click();
	}
	
	
	

}
