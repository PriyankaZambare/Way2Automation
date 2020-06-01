package PageObject;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Resize {
WebDriver ldriver;
public Resize(WebDriver rdriver)
{
	ldriver=rdriver;
	PageFactory.initElements(rdriver, this);
}

@FindBy(xpath="//img[@src='images/resizable.jpg']")
WebElement imgResize;

@FindBy(xpath="//iframe[@src='resizable/default.html']")
WebElement defaultIframe;

@FindBy(xpath="//div[@class='ui-resizable-handle ui-resizable-se ui-icon ui-icon-gripsmall-diagonal-se']")
WebElement resizeBtn;

@FindBy(xpath="//a[@href='#example-1-tab-2']")
WebElement lnkAnimate;

@FindBy(xpath="//iframe[@src='resizable/default2.html']")
WebElement AnimationIframe;

@FindBy(xpath="//a[@href='#example-1-tab-3']")
WebElement lnkConResizeArea;

@FindBy(xpath="//iframe[@src='resizable/default3.html']")
WebElement ConResizeAreaIframe;

public void ClkImgResize()
{
	ldriver.navigate().refresh();
	JavascriptExecutor js=(JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].scrollIntoView();", imgResize);
	imgResize.click();
}

public void ClkDefaultFun()
{
	ldriver.switchTo().frame(defaultIframe);
	Actions act =new Actions(ldriver);
	act.dragAndDropBy(resizeBtn, 20, 80).build().perform();
}

public void ClkAnimation()
{
ldriver.switchTo().defaultContent();
lnkAnimate.click();
ldriver.switchTo().frame(AnimationIframe);

Actions act=new Actions(ldriver);
act.dragAndDropBy(resizeBtn, 40, 60).build().perform();

}

public void ClkConResizeArea()
{
ldriver.switchTo().defaultContent();
lnkConResizeArea.click();
ldriver.switchTo().frame(ConResizeAreaIframe);
Actions act=new Actions(ldriver);
act.clickAndHold(resizeBtn).moveToElement(resizeBtn, 30, 10).release().build().perform();

}



}
