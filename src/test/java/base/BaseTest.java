package base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.github.bonigarcia.wdm.WebDriverManager;
import utils.ExtentManager;

public class BaseTest {
	
	public static FileInputStream fis1;
	public static Properties configProp;
	public static WebDriver driver;
	
	public static FileInputStream fis2;
	public static Properties locatorProp;
	
	public static ExtentReports reports;
	public static ExtentTest test;
	
	@BeforeTest
	public void beforeTest()
	{
		
		reports=ExtentManager.getReports();
		
		try {
			fis2=new FileInputStream("locators.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		locatorProp=new Properties();
		
		try {
			locatorProp.load(fis2);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@BeforeMethod
	public void setUp(ITestContext context) throws IOException
	{
		
		test=reports.createTest("Login Test");
		
		context.setAttribute("report", "reports");
		
		context.setAttribute("test", "test");
		
		fis1=new FileInputStream("config.properties");
		
		configProp=new Properties();
		
		configProp.load(fis1);
		
		String browserName=configProp.getProperty("browser");
		
		if(browserName.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			
			test.log(Status.INFO, "Chrome browser started ..");
			
		}
		else if(browserName.equalsIgnoreCase("firefox"))
		{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			test.log(Status.INFO, "Firefox browser started ..");
		}
		else if(browserName.equalsIgnoreCase("edge"))
		{
			WebDriverManager.edgedriver().setup();
			driver=new EdgeDriver();
			test.log(Status.INFO, "Edge browser started ..");
		}
		
		//launch the app
		
		driver.get(configProp.getProperty("url"));
		
		test.log(Status.INFO, "app launched with URL- "+ configProp.getProperty("url"));
		
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Long.parseLong(configProp.getProperty("implicitWaitTime"))));
		
	}

	@AfterMethod
	public void teardown()
	{
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		test.log(Status.INFO, " browser closed ..");
	}
	
	@AfterTest
	public void closeReports()
	{
		if(reports!=null)
		{
			reports.flush();
		}
	}
}
