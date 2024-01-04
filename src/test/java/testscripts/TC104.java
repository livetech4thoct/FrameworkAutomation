package testscripts;

import java.util.HashMap;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.LoginPage;
import pages.SearchHotelPage;
import utils.UtilKit;

public class TC104 extends BaseTest {
	
	@Test(dataProvider = "getData")
	public void tc104(HashMap<String,String> dataMap)
	{
		
		LoginPage lp=new LoginPage();
		lp.usernameTextbox(dataMap.get("username"));
		lp.passwordTextbox(dataMap.get("password"));
		lp.loginButton();
		
		lp.validateTitle(dataMap.get("expectedTitle"));
		
		//SearchHotelPage
		
		SearchHotelPage searchHotelPage=new SearchHotelPage();
		searchHotelPage.locationDropdown(dataMap.get("Location"));
		searchHotelPage.checkInDateTextbox(dataMap.get("Check InDate"));
	}
	
	@DataProvider
	public Object[][] getData()
	{
		
		Object[][] data=new Object[1][1];
		
		data[0][0]=UtilKit.getTestData("TC-104");
		
		return data;
		
	}

}
