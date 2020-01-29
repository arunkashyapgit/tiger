package test;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import generics.BaseClass;
import generics.WebdriverUtils;
import pages.CampaignsPage;
import pages.HomePage;

public class TestCampaign extends BaseClass  {
	@Test(groups="smokeTest")
	

	public  void testCampaign() throws InterruptedException {
		
		 String name = "mobiles_"+WebdriverUtils.generateRandomNumber();
		 wlib.verifyPage(driver,"Administrator - Home - vtiger CRM 5 - Commercial Open Source CRM");
		
	    HomePage vhp = new HomePage(driver);
	    vhp.clickOnMore();;
		vhp.clickCampaigns();
		
		CampaignsPage vcp = new CampaignsPage(driver);
		vcp.clickCreateCampaign();
		vcp.setCampaignName(name);
		vcp.clickSelect();
		wlib.switchToChildWindow(driver);
		WebElement selPro = vcp.selectProduct();

		wlib.selectTheCheckBoxByVisibleText(selPro,"Product Name");
		vcp.searchProd("iphone");
		Thread.sleep(2000);
		 
		vcp.afterSearch();
		wlib.switchToParentWindow(driver);
	
		vcp.saveCampaign();
		
		
		
		
	}
	

}
