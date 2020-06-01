package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Slidder {
	
WebDriver ldriver;

public Slidder(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(xpath="//img[@src='images/slider.jpg']")
WebElement imgSlidder;

@FindBy(xpath="//iframe[@src='slider/defult1.html']")
WebElement RangeSlidderFrame;

@FindBy(xpath="//span[@class='ui-slider-handle ui-state-default ui-corner-all']")
WebElement slider;


public void ClkImgSlidder() throws InterruptedException
{
    ldriver.navigate().refresh();
    
    Actions act=new Actions(ldriver);
    JavascriptExecutor js=(JavascriptExecutor)ldriver;
    js.executeScript("arguments[0].scrollIntoView();", imgSlidder);
    imgSlidder.click();
	
	
	ldriver.switchTo().frame(RangeSlidderFrame);
	act.dragAndDropBy(slider, 9, 0).build().perform();
	
}
}
