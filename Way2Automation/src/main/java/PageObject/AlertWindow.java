package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class AlertWindow {
	WebDriver ldriver;
	
	public AlertWindow(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	
	@FindBy(xpath="//img [@src='images/simple_alert.jpg']")
	WebElement Clkimg;
	
	@FindBy(xpath="/html/body/button")
	WebElement Atlbtn;
	
	@FindBy(xpath="//a[@href='#example-1-tab-2']")
	WebElement inputAlertLnk;
	
	@FindBy(xpath="//button[text()='Click the button to demonstrate the Input box.']")
	WebElement inputAltbtn;
	
	public void ClickOnAlretImage()
	{
		ldriver.navigate().refresh();
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].scrollIntoView();", Clkimg);	
	    Clkimg.click();
	}
	
	public void ClickOnAlretBtn() throws InterruptedException
	{
		ldriver.switchTo().frame(0);
		Atlbtn.click();
		Thread.sleep(3000);
		ldriver.switchTo().alert().accept();
		
	}
	public void inputAlertBtn() throws InterruptedException
	{
		ldriver.switchTo().defaultContent();
		inputAlertLnk.click();
       
		ldriver.switchTo().frame(ldriver.findElement(By.xpath("//iframe[@src='alert/input-alert.html']")));
		
		inputAltbtn.click();
		ldriver.switchTo().alert().sendKeys("Hiee Selenium ");
		System.out.println(ldriver.switchTo().alert().getText());
		ldriver.switchTo().alert().accept();
			
	}

}
