package PageObject;
//*******************************************
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClickMenuClick {
WebDriver ldriver;

public ClickMenuClick(WebDriver rdriver)
{
	PageFactory.initElements(rdriver, this);
}

@FindBy(xpath="//img[@src='images/menu.jpg']")
WebElement imgMenu;

@FindBy(xpath="//a[@href='#example-1-tab-2']")
WebElement menuwithSubMenu;

@FindBy(xpath="//iframe[@src='menu/defult2.html']")
WebElement menuWithSubmenuIframe;

@FindBy(xpath="//li[@id='ui-id-8']")
WebElement delphi;

@FindBy(xpath="//li[@id='ui-id-10']")
WebElement Submenu2;

public void ClickImgMenu() throws InterruptedException
{
	ldriver.navigate().refresh();
	Thread.sleep(3000);
	
	Actions act=new Actions(ldriver);
	act.moveToElement(imgMenu).click().build().perform();


 /*   Thread.sleep(3000);
	JavascriptExecutor js= (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].scrollIntoView();", imgMenu);	
	imgMenu.click(); */
}

public void ClickMenuWithSUbMenu()
{
	
	menuwithSubMenu.click();
	ldriver.switchTo().frame(menuWithSubmenuIframe);
	Actions act=new Actions(ldriver);
	act.moveToElement(delphi).moveToElement(Submenu2).click().build().perform();
	
}


}
