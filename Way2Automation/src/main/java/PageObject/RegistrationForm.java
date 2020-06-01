package PageObject;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class RegistrationForm {
	WebDriver ldriver;
	
	public RegistrationForm(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//img[@src='images/registration.jpg']")
	WebElement ImgRegistration;
	
	@FindBy(xpath="//input[@name='name']")
	WebElement FirstNamae;
	
	@FindBy(xpath="/html/body/section/div/div/div/form/fieldset[1]/p[2]/input")
	WebElement LastName ;
	
	@FindBy(xpath="//input[@type='radio']")
	 List<WebElement> materialStatus;
	
	@FindBy(xpath="//input[@type='file']")
	WebElement yrProfilePic;
	
	@FindBy(name="phone")
	WebElement Phone;
	
	@FindBy(name="username")
	WebElement Username;
	
	@FindBy(name="email")
	WebElement emailId;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(name="c_password")
	WebElement cpass;
	
	@FindBy(xpath="//input[@value='submit']")
	WebElement SubBtn;
	
	@FindBy(xpath="//input[@name='hobby']")
	List<WebElement> hobby;
	
	@FindBy(xpath="/html/body/section/div/div/div/form/fieldset[3]/div/label[2]/input")
	WebElement reading;
	
	public void ClkImgRegistration()
	{
		ldriver.navigate().refresh();
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].click();", ImgRegistration);
		
	}
	
	public void FullFormInfo(String name,String LastN ,String No,String uName ,String email,String pass) throws InterruptedException, FindFailed
	{
		FirstNamae.sendKeys(name);
		Thread.sleep(3000);
		LastName.sendKeys(LastN);
		
		System.out.println(materialStatus.size());
	/*	for(WebElement radio:materialStatus)
		{
			System.out.println(radio.getText());
			if(radio.getText().equals("Single"))
	           {
				radio.click();
				break;
			   }
					
		}*/                                               // names will not print and don's show any error
		
		for(int i=0;i<materialStatus.size();i++)
		{
			WebElement radio=materialStatus.get(i);
			String Value=radio.getText();
			System.out.println(Value);
		}                                                 // names will not print and don's show any error
		
		
		System.out.println(hobby.size());
		for(WebElement AllHobby : hobby)
		{
		    System.out.println(AllHobby.getText());	         // names will not print and don's show any error
		}
		reading.click();
		
		Phone.sendKeys(No);
		Username.sendKeys(uName);
		emailId.sendKeys(email);
		
		Actions act =new Actions(ldriver);
		act.moveToElement(yrProfilePic).click().build().perform();
		
		Screen s=new Screen();
		Pattern TextBox=new Pattern(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenCaptureForSikuli\\FileTextBox.PNG.png");
		Pattern OpenBtn=new Pattern(System.getProperty("user.dir")+"\\src\\test\\resources\\ScreenCaptureForSikuli\\OpenButton.png");
		s.wait(TextBox,20);
		s.type(TextBox,"C:\\Users\\Priya\\Pictures\\birds img\\Peachock.jpg");
		s.click(OpenBtn);
		
		password.sendKeys(pass);
		cpass.sendKeys(pass);
		
		SubBtn.click();  
	}
	
}
