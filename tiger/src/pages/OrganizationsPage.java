package pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import generics.WebdriverUtils;
/**
 * 
 * @author Arun
 *
 */
public class OrganizationsPage {
	
	WebDriver driver;
	
	@FindBy(xpath="//img[@alt='Create Organization...']")
	private WebElement createOrganizationIcon;
	
	@FindBy(id="search_txt")
	private WebElement searchForTextBox;
	
	@FindBy(name="search_field")
	private WebElement inDropDown;
	
	@FindBy(xpath="//input[@value=' Search Now ']")
	private WebElement searchNowButton;
	
	@FindBy(xpath="//span[contains(.,'of ')]")
	private WebElement textOfNumRecords;
	
	@FindBy(xpath="//span[contains(.,'of ')]/following-sibling::a[@alt='Next']")
	private WebElement forwardIcon;
	
	@FindBys({@FindBy(xpath="//table[@class='lvt small']/tbody/tr")})
	private List<WebElement> list;
	
	@FindBy(name="pagenum")
	private WebElement pageNum;

	public OrganizationInformationPage CreatingNewOrganizationPage;
	
	public OrganizationsPage(WebDriver driver) {
	    this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public CreatingNewOrganizationPage navigateToCreatingNewOrganizationPage()
	{
		createOrganizationIcon.click();
		return new CreatingNewOrganizationPage(driver);
	}
	
	public WebElement getSearchForTextBox()
	{
		return searchForTextBox;
	}
	
	public WebElement getInDropDown()
	{
		return inDropDown;
	}
	
	public WebElement getSearchNowButton()
	{
		return searchNowButton;
	}
	
	public WebElement getPageNum()
	{
		return pageNum;
	}

	public String getLastDataFromListTable(WebDriver driver)
	{
		int i=0;
		String s1=textOfNumRecords.getText();
		String[] c = s1.split(" ");
		String a=c[c.length-1].trim();
		System.out.println(a);
		while(!(a.equals(pageNum.getAttribute("value"))))
		{
			forwardIcon.click();
		}
	
		String s=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr[last()]/td[3]/a")).getText();
		return s;
	}
	
	public String getDataFromListTable(WebDriver driver,int row,int col)
	{
		String s=driver.findElement(By.xpath("//table[@class='lvt small']/tbody/tr["+row+"]/td["+col+"]/a")).getText();
		return s;
	}
	
	
}
