package testscripts;

import java.util.HashMap;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import keywords.ApplicationKeywords;
import utils.UtilKit;

public class ValidateRegistration extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void validateRegistrationTest(HashMap<String,String> dataMap) throws InterruptedException
	{
		ApplicationKeywords app=new ApplicationKeywords();
		
		app.openBrowser();
		
		app.launchApp();
		
		app.click("newUserRegister_link");
		
		app.type("register_username_textbox", dataMap.get("username"));
		app.type("register_password_textbox", dataMap.get("password"));
		app.type("register_confirmPassword_textbox", dataMap.get("confirmPassword"));
		app.type("register_fullName_textbox", dataMap.get("Full Name"));
		app.type("register_emailAddress_textbox", dataMap.get("Email Address"));
		app.type("register_captcha_textbox", dataMap.get("Captcha"));
		app.click("register_termsAndCondition_checkbox");
		app.click("register_register_button");
		
		Thread.sleep(3000);
		
		app.close();
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
	 Object[][] data=	new Object[1][1];
		
	 data[0][0]=UtilKit.getTestData("TC-102");
		return data;
		
	}

}
