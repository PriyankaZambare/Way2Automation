package PageObject;

import java.util.List;import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class DropdownBox {
	WebDriver ldriver;
	
	public DropdownBox(WebDriver rdriver)
	{
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
	}
	
	@FindBy(xpath="//img[@src='images/dropdown.jpg']")
	WebElement dropdownimg;
	
	@FindBy(xpath="//a[@href='#example-1-tab-1']")
	WebElement SelectCountry;
	
	@FindBy(xpath="//iframe[@src='dropdown/default.html']")
	WebElement SelectCountryIframe;
	
	@FindBy(xpath="/html/body/select")
	WebElement dropDownBtn;
	
	
	@FindBy(xpath="//a[@href='#example-1-tab-2']")
	WebElement EnterCountrylnk;
	
	@FindBy(xpath="//iframe[@src='dropdown/default1.html']")
	WebElement iframeEnterCountry;
	
	@FindBy(xpath="//a[@class='ui-button ui-widget ui-state-default ui-button-icon-only custom-combobox-toggle ui-corner-right']")
	WebElement EnterCountryBtn;
	
	@FindBy(xpath="//li[@class='ui-menu-item']")
	List<WebElement> EnterAllCountryName;
	
	public void ImgDropDown()
	{
		JavascriptExecutor js=(JavascriptExecutor)ldriver;
		js.executeScript("arguments[0].scrollIntoView();", dropdownimg);
		
		dropdownimg.click();
	}
	
	public void SelectAllCounrtyName()
	{
		SelectCountry.click();
		
		ldriver.switchTo().frame(SelectCountryIframe);
		
		dropDownBtn.click();
		Select s=new Select(dropDownBtn);
	    System.out.println(s.getOptions().size());
	    
	    List <WebElement> country=s.getOptions();
	    
	    for(WebElement NameCon :country)
	    {
	    	System.out.println(NameCon.getText());
	    	
	    	if("Japan".equals(NameCon.getText()))
	    	{
	    		NameCon.click();
	    		break;
	    	}
	    }
	    System.out.println("************************");
	}
	
	 
    public void ClkEnterCountry()
    {
    	
    	ldriver.switchTo().defaultContent();
    	EnterCountrylnk.click();
    	ldriver.switchTo().frame(iframeEnterCountry);
    	
    	EnterCountryBtn.click();
    	
   //  	ldriver.findElement(By.xpath("//li[contains(@id,'ui-id-9')]")).click();
        
    	System.out.println(EnterAllCountryName.size());
            	
    	for(WebElement NameOfCountries :EnterAllCountryName)
    	{
    		System.out.println(NameOfCountries.getText());
    	}
 
    	
    	
    }
	

}
