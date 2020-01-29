package pages;

import org.openqa.selenium.By;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.WebdriverUtils;
/**
 * 
 * @author Arun
 *
 */
public class CreatingNewOrganizationPage {

	WebDriver driver;
	
	@FindBy(name="accountname")
	private WebElement organizationNameTextBox;

	@FindBy(id="phone")
	private WebElement phoneTextBox;

	@FindBy(name="email1")
	private WebElement emailTextBox;

	@FindBy(xpath="//img[@title='Select']")
	private WebElement selectLookUpIcon;

	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;

	public CreatingNewOrganizationPage(WebDriver driver ) {

		this.driver=driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrganizationNameTextBox() {

		return organizationNameTextBox;
	}

	public WebElement getPhoneTextBox() {

		return phoneTextBox;
	}

	public WebElement getEmailTextBox() {

		return emailTextBox;
	}

	public WebElement getSelectLookUpIcon() {

		return selectLookUpIcon;
	}

	public WebElement getSaveButton() {

		return saveButton;
	}
	
	public OrganizationInformationPage createNewOrganization(String orgName,String phnNum,String emailId)
	{
		organizationNameTextBox.sendKeys(orgName);
		phoneTextBox.sendKeys(phnNum);
		emailTextBox.sendKeys(emailId);
		saveButton.click();
		return new OrganizationInformationPage(driver);
	}
	
	public OrganizationInformationPage createNewOrganization(WebDriver driver,String orgName,String phnNum,String emailId,String member) throws InterruptedException
	{
		WebdriverUtils lib= new WebdriverUtils();
		organizationNameTextBox.sendKeys(orgName);
		phoneTextBox.sendKeys(phnNum);
		emailTextBox.sendKeys(emailId);
		selectLookUpIcon.click();
		lib.switchToChildWindow(driver);
		OrganizationsPage org=new OrganizationsPage(driver);
		lib.select(org.getInDropDown(), "Organization Name");
		org.getSearchForTextBox().sendKeys(member,Keys.ENTER);
		driver.findElement(By.linkText(member)).click();
		lib.acceptAlert(driver);
		lib.switchToParentWindow(driver);
		lib.waitForElementandclick(saveButton);
		return new OrganizationInformationPage(driver);
	}
	public OrganizationInformationPage createNewOrganization(WebDriver driver,String orgName,String emailId) throws InterruptedException
	{
		WebdriverUtils lib= new WebdriverUtils();
		organizationNameTextBox.sendKeys(orgName);
	
		emailTextBox.sendKeys(emailId);
		selectLookUpIcon.click();
		
		lib.waitForElementandclick(saveButton);
		return new OrganizationInformationPage(driver);
	}

	public OrganizationInformationPage createNewOrganization(String memberName, String emailId) throws InterruptedException {
		WebdriverUtils lib= new WebdriverUtils();
		//organizationNameTextBox.sendKeys(orgName);
	
		emailTextBox.sendKeys(emailId);
		selectLookUpIcon.click();
		
		lib.waitForElementandclick(saveButton);
		return new OrganizationInformationPage(driver);
		
	}
	
	


}
