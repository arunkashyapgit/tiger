package generics;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import pages.HomePage;
import pages.LoginPage;

public class BaseClass {
	
	public FileLib flib=new FileLib();
	public WebdriverUtils wlib=new WebdriverUtils();
	 public WebDriver driver;
	
	@BeforeClass(groups={"smokeTest","regressionTest"})
	public void openBrowser() throws IOException
	{
		String browser=flib.getDataFromProperties("browser");
		String url=flib.getDataFromProperties("url");
		if(browser.equals("chrome"))
			driver=new ChromeDriver();
		else if(browser.equals("firefox"))
			driver=new FirefoxDriver();
		driver.get(url);
		wlib.waitForLoad(driver);
	
		
	}
	
	@BeforeMethod(groups="smokeTest")
	public void loginToApp() throws IOException
	{
		LoginPage lp=new LoginPage(driver);
			lp.login();
	}
	
	@AfterMethod(groups="smokeTest")
	public void closeApp()
	{
		HomePage hp=new HomePage(driver);
		hp.logout();
	}
	
	@AfterClass(groups="smokeTest")
	public void closeBrowser()
	{
		driver.close();
	}

}
