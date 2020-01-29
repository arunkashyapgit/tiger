package generics;

import java.util.Iterator;

import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebdriverUtils {
 
	public static int generateRandomNumber() {
		Random ran= new Random();
		return ran.nextInt(500); 
	}
	
	public void maximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	
	public void waitForLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	public void waitForElementToClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public void waitForVisibility(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	public void selectTheCheckBoxByVisibleText(WebElement element,String visibleText)
	{
		Select sel=new Select(element);
		sel.selectByVisibleText(visibleText);
		
	}
	public void waitforRefresh(WebDriver driver,WebElement element)
	{
		WebDriverWait wait= new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.stalenessOf(element));
	}
	
	public void mouseoveraction(WebDriver driver ,WebElement element)
	{
		Actions a=new Actions(driver);
		a.moveToElement(element).perform();
	}
	public void waitForElementandclick(WebElement element) throws InterruptedException
	{
		int count=0;
		while(count<=25)
		{
			try {
				element.click();
				break;
			}
			catch(Throwable t)
			{
				Thread.sleep(1000);
				count++;
			}
		}
	}
	
	public void verifyPage(WebDriver driver,String expectedtitle )
	{
		WebDriverWait wait=new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.titleIs(expectedtitle));
		String actualtitle=driver.getTitle();
		if(actualtitle.equals(expectedtitle))
		{
			System.out.println("expected title is====>"+expectedtitle);
		}
		else
		{
			System.out.println("expected title is not displayed====>" +actualtitle);
		}
		
	}
	
	
	static String childId=null;
	static String parentId=null;
	
	public void switchToChildWindow(WebDriver driver) {
		
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		parentId=it.next();
		childId=it.next();
		
		driver.switchTo().window(childId);
	}
	
	public void switchToParentWindow(WebDriver driver) {
		driver.switchTo().window(parentId);
		
	} 
	
	public void select(WebElement element,String text)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);
	}
	
	public void select(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
	}
	
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
}
