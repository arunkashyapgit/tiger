package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
/**
 * 
 * @author Arun
 *
 */
public class OrganizationInformationPage {
 WebDriver driver;
	
	public WebDriver getDriver() {
	return driver;
}

public WebElement getOrgNameInfo() {
	return orgNameInfo;
}

	@FindBy(id="dtlview_Organization Name")
	private WebElement orgNameInfo;
	
	public OrganizationInformationPage(WebDriver driver) {
	    this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
}
