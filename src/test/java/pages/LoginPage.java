package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.aventstack.extentreports.Status;

import base.BasePage;

public class LoginPage extends BasePage {
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	
	public void usernameTextbox(String value)
	{
		usernameTextbox.sendKeys(value);
		
		test.log(Status.INFO, "Entered text "+value+" into textbox usernameTextbox");
	}
	
	public void passwordTextbox(String value)
	{
		passwordTextbox.sendKeys(value);
		test.log(Status.INFO, "Entered text "+value+" into textbox passwordTextbox");
	}
	
	public void loginButton()
	{
		loginButton.click();
		test.log(Status.INFO, "Clicked button  loginButton");
	}
	
	
}
