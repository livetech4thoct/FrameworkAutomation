package keywords;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import base.BaseTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class GenericKeywords extends BaseTest {
	
	public void openBrowser()
	{
		try {
			fis1=new FileInputStream("config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		configProp=new Properties();
		
		try {
			configProp.load(fis1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
		}
		
	}
	
	
	public void launchApp()
	{
		driver.get(configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWaitTime"))));
		
	}

	
	public void type(String locatorKey,String text)
	{
		findElement(locatorKey).sendKeys(text);
			
	}
	
	
	public void click(String locatorKey)
	{
		findElement(locatorKey).click();
	}
	
	public WebElement findElement(String locatorKey)
	{
		WebElement element=null;
		
		element=driver.findElement(getLocator(locatorKey));
		
		return element;
	}
	
	public By getLocator(String locatorKey)
	{
		By by=null;
		
		if(locatorKey.endsWith("_id"))
		{
			by=By.id(locatorProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_name"))
		{
			by=By.name(locatorProp.getProperty(locatorKey));
		}
		else if(locatorKey.endsWith("_xpath"))
		{
			by=By.xpath(locatorProp.getProperty(locatorKey));
		}else 
			
			{
				by=By.xpath(locatorProp.getProperty(locatorKey));
			}
		
		
		return by;
		
	}
	
	public void close()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
	}
}
