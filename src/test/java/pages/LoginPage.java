package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import base.BasePage;

public class LoginPage extends BasePage {
	
	@FindBy(xpath="//input[@name='username']")
	WebElement usernameTextbox;
	
	@FindBy(xpath="//input[@name='password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath="//input[@name='login']")
	WebElement loginButton;
	
	public void usernameTextbox(String value)
	{
		usernameTextbox.sendKeys(value);
	}
	
	public void passwordTextbox(String value)
	{
		passwordTextbox.sendKeys(value);
	}
	
	public void loginButton()
	{
		loginButton.click();
	}
	
	
}
