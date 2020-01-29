package pages;

import org.openqa.selenium.Keys;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Arun
 *
 */
public class CampaignsPage {
	 @FindBy(xpath="//img[@alt='Create Campaign...']")
	   private WebElement  createCampaign;
	 
	 @FindBy(name="campaignname")
	   private WebElement  campaignName;
	 
	 @FindBy(xpath="//img[@alt='Select']")
	   private WebElement  select;
	 
	 @FindBy(id="search_txt")
	   private WebElement  searchpro;
	 @FindBy(name="search_field")
	   private WebElement  selProd;
	 @FindBy(name="search")
	   private WebElement  clSearch;
	 @FindBy(id="1")
	   private WebElement  aftsearch;
	 @FindBy(xpath="//input[@value='  Save  ']")
	   private WebElement  saveCampgn;
	
		
		public CampaignsPage(WebDriver driver) 
		{
			 PageFactory.initElements(driver, this);
		}
		
		public void clickCreateCampaign()
		{
			createCampaign.click();	
		}
		public void setCampaignName(String name)
		{
			campaignName.sendKeys(name);
		}
		public void clickSelect()
		{
			select.click();	
		}
		
		public void searchProd(String ProName)
		{
			searchpro.sendKeys(ProName,Keys.ENTER);	
		}
		
		public WebElement selectProduct()
		{
			return selProd;	
		}
		public void clickSearch()
		{
			clSearch.click();	
		}
		
		public void afterSearch()
		{
			aftsearch.click();;	
		}
		public void saveCampaign()
		{
			saveCampgn.click();	
		}

}
