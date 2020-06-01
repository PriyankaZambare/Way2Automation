package PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class HandleDatapicker {
WebDriver ldriver;

public HandleDatapicker(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(xpath="//img[@src='images/datepicker.jpg']")
WebElement imgDataPicker;

@FindBy(xpath="//a[@href='#example-1-tab-1']")
WebElement ClkDefaultFun;

@FindBy(xpath="//iframe[@src='datepicker/defult1.html']")
WebElement iframeDefaultFun;

@FindBy (xpath="//input[@id='datepicker']")
WebElement defaultfunDatapicker;

@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-w']")
WebElement ClkPreviousBtn;

@FindBy(linkText="25")
WebElement ClkDate;

@FindBy(xpath="//a[@href='#example-1-tab-2']")
WebElement ClkAnimation;

@FindBy(xpath="//iframe[@src='datepicker/defult2.html']")
WebElement AnimationFrame;

@FindBy(xpath="//input[@id='datepicker']")
WebElement AnimationDataPicker;

@FindBy(xpath="//span[@class='ui-icon ui-icon-circle-triangle-e']")
WebElement ClkForwordBtn;

@FindBy(linkText="6")
WebElement DateSelect;

@FindBy(id="anim")
WebElement SelectAnimations;

@FindBy(xpath="//a[@href='#example-1-tab-3']")
WebElement DisplayMonAndyr;

@FindBy(xpath="//iframe[@src='datepicker/defult3.html']")
WebElement DisplayFrame;

@FindBy(xpath="//input[@id='datepicker']")
WebElement DisplayDataPickerBox;

@FindBy(xpath="//select[@class='ui-datepicker-month']")
WebElement ClkMonth;

@FindBy(xpath="//select[@class='ui-datepicker-year']")
WebElement ClkYear;

@FindBy(linkText="16")
WebElement LnkDate;

@FindBy(xpath="//a[@href='#example-1-tab-4']")
WebElement FormateDateClk;

@FindBy(xpath="//iframe[@src='datepicker/defult4.html']")
WebElement FormateDateIframe;

@FindBy(xpath="//select[@id='format']")
WebElement FormateOption;

@FindBy(xpath="//input[@id='datepicker']")
WebElement ClkFormateDateBox;

@FindBy(linkText="16")
WebElement Date;

public void ClkdatapickerImg() throws InterruptedException
{
	ldriver.navigate().refresh();
	JavascriptExecutor js=(JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].scrollIntoView();", imgDataPicker);
	imgDataPicker.click();
	
}

public void ClkDefaultFunctionality()
{
	ClkDefaultFun.click();
	ldriver.switchTo().frame(iframeDefaultFun);
	defaultfunDatapicker.click();
	
	for(int i=20;i>=1;i--)
	{
		ClkPreviousBtn.click();
		
	}
	ClkDate.click();
}

public void ClickAnimationBtn()
{
	ldriver.switchTo().defaultContent();
	ClkAnimation.click();
	ldriver.switchTo().frame(AnimationFrame);
	AnimationDataPicker.click();
	
	for(int i=1;i<=7;i++)
	{
		ClkForwordBtn.click();
	}
	DateSelect.click();
	
	Select sel=new Select(SelectAnimations);
	List<WebElement> Animation=sel.getOptions();
	
	for(WebElement SelectAni:Animation)
	{
		System.out.println(SelectAni.getText());
		if(SelectAni.getText().equals("Fold (UI Effect)"))
		{
			SelectAni.click();
			break;
		}
	}
	
	
}
public void ClkDisplayMonthAndYear()
{
	ldriver.switchTo().defaultContent();
	DisplayMonAndyr.click();
	ldriver.switchTo().frame(DisplayFrame);
	DisplayDataPickerBox.click();
	
	ClkMonth.click();
	Select mon=new Select(ClkMonth);
	System.out.println(mon.getOptions().size());
	List<WebElement> month=mon.getOptions();
	for(WebElement Allmonth:month)
	{
	System.out.println(Allmonth.getText());
	if(Allmonth.getText().equals("NOV"))
	{
		Allmonth.click();
	}
	}
	System.out.println("**********************************");
	
	ClkYear.click();
	Select yr=new Select(ClkYear);
	System.out.println(yr.getOptions().size());
	List <WebElement>year=yr.getOptions();
	for(WebElement AllYear:year)
	{
		System.out.println(AllYear.getText());
/*		if(AllYear.getText().equals("2022"))
		{
			AllYear.click();
		} */
	}
	System.out.println("******************************");
	ldriver.navigate().refresh();
	LnkDate.click();
}

public void ClkFormateDate()
{
	ldriver.switchTo().defaultContent();
	FormateDateClk.click();
	ldriver.switchTo().frame(FormateDateIframe);
	
	FormateOption.click();
	Select option=new Select(FormateOption);
	System.out.println(option.getOptions().size());
	List<WebElement> Formate=option.getOptions();
	for(WebElement ForOp:Formate)
	{
		System.out.println(ForOp.getText());
		if(ForOp.getText().equals("Full - DD, d MM, yy"))
		{
			ForOp.click();
			break;
		}
		ClkFormateDateBox.click();
		Date.click();
	
		}
	
}



}