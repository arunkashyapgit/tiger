package pages;

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
public class HomePage {
	
	WebDriver driver;
	
	@FindBy(linkText="Calendar")
	private WebElement calenderLink;
	
	@FindBy(linkText="Leads")
	private WebElement leadsLink;
	
	@FindBy(linkText="Organizations")
	private WebElement organizationLink;
	
	@FindBy(linkText="Contacts")
	private WebElement contactsLink;
	
	 @FindBy(xpath="//a[@name='Campaigns']")
	   private WebElement  campaign;
	
	@FindBy(linkText="Opportunities")
	private WebElement opportunitiesLink;
	
	@FindBy(linkText="Products")
	private WebElement productsLink;
	
	@FindBy(linkText="Documents")
	private WebElement documentsLink;
	
	@FindBy(linkText="Email")
	private WebElement emailLink;
	
	@FindBy(linkText="Trouble Tickets")
	private WebElement troubleTicketsLink;

	@FindBy(linkText="Dashboard")
	private WebElement dashboardLink;
	
	 @FindBy(xpath="//a[text()='More']")
	   private WebElement  moreLink;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement adminIcon;
	
	@FindBy(linkText="Sign Out")
	private WebElement logout;
	
	public HomePage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getCalenderLink()
	{
		return calenderLink;
	}
	
	public WebElement getOrganizationLink()
	{
		return organizationLink;
	}
	
	public OrganizationsPage navigateToOrganizationsPage()
	{
		organizationLink.click();
		return new OrganizationsPage(driver);
	}
	
	 @FindBy(xpath="//a[text()='Products']")
	  private WebElement  product;
	
	public WebElement getLeadsLink()
	{
		return leadsLink;
	}
	
	public WebElement getContactsLink()
	{
		return contactsLink;
	}
	
	public WebElement getOpportunitiesLink()
	{
		return opportunitiesLink;
	}
	

	public void clickCampaigns()
	{
		campaign.click();
	}
	public WebElement getDocumentsLink()
	{
		return documentsLink;
	}
	
	public WebElement getEmailLink()
	{
		return emailLink;
	}
	
	public WebElement getTroubleTicketsLink()
	{
		return troubleTicketsLink;
	}
	
	public WebElement getDashboardLink()
	{
		return dashboardLink;
	}
	
	public void clickOnProduct()
	{
		product.click();
	}
	public void clickOnMore()
	{
		moreLink.click();
	}
	public WebElement getMoreLink()
	{
		return moreLink;
	}

	public WebElement getUserIcon() {
		return adminIcon;
	}

	public WebElement getSignOutbtn() {
		return logout;
	}
	
	public void logout()
	{
		WebdriverUtils lib =new WebdriverUtils();
		lib.mouseoveraction(driver, adminIcon);
		logout.click();
	}
	

}
