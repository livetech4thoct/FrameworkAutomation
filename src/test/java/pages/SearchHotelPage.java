package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;

public class SearchHotelPage extends BasePage {
	
	public SearchHotelPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//select[@name='location']")
	WebElement locationDropdown;
	
	@FindBy(xpath="//select[@name='hotels']")
	WebElement hotelsDropdown;
	
	@FindBy(xpath="//select[@name='room_type']")
	WebElement room_typeDropdown;
	
	@FindBy(xpath="//select[@name='room_nos']")
	WebElement room_nosDropdown;
	
	@FindBy(xpath="//input[@name='datepick_in']")
	WebElement checkInDateTextbox;
	
	@FindBy(xpath="//input[@name='datepick_out']")
	WebElement checkOutDateTextbox;
	
	@FindBy(xpath="//select[@name='adult_room']")
	WebElement adultsPerRoomDropdown;
	
	@FindBy(xpath="//select[@name='child_room']")
	WebElement childsPerRoomDropdown;
	
	@FindBy(xpath="//input[@name='Submit']")
	WebElement searchButton;
	
	@FindBy(xpath="//input[@name='Reset']")
	WebElement resetButton;
	
	
	public void locationDropdown(String option)
	{
		new Select(locationDropdown).selectByVisibleText(option);
	}
	
	public void checkInDateTextbox(String date)
	{
		checkInDateTextbox.clear();
		checkInDateTextbox.sendKeys(date);
	}
	

}
