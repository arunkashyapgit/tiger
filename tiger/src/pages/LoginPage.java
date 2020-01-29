package pages;

import java.io.IOException;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import generics.FileLib;
/**
 * 
 * @author Arun
 *
 */
public class LoginPage {
	
	FileLib flib=new FileLib();
	WebDriver driver;
	
	
	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	private WebElement password;
	
	@FindBy(id="submitButton")
	private WebElement loginButton;
	
    public LoginPage(WebDriver driver) {
    	this.driver=driver;
		PageFactory.initElements(driver, this);
	}

    public WebElement getUsername()
    {
    	return username;
    }
    
    public WebElement getPassword()
    {
    	return password;
    }
    
    public HomePage navigateToHomePage()
    {
    	
    	loginButton.click();
    	return new HomePage(driver);
    }
    
    public void login(String username,String password)
    {
    	this.username.sendKeys(username);
    	this.password.sendKeys(password);
    	loginButton.click();
    
    }
    
    public void login() throws IOException
    {
    	String userName=flib.getDataFromProperties("username");
		String passWord=flib.getDataFromProperties("password");  
        username.sendKeys(userName);
        password.sendKeys(passWord);
        loginButton.click();
    
    }
    
}
