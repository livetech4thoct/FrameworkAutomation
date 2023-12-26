package testscripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.BaseTest;

public class ValidateLoginUsingDataProviderExcel extends BaseTest {
	
	@Test(dataProvider="getData")
	public void validateLoginTest1(String username,String password,String expTitle)
	{
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys(username);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);
		driver.findElement(By.xpath("//input[@name='login']")).click();
		Assert.assertEquals(driver.getTitle(), expTitle);
	}
	
	
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		FileInputStream fis1=new FileInputStream("src\\test\\resources\\testdata\\excels\\RegressionTestData.xlsx");
		
		XSSFWorkbook wb=new XSSFWorkbook(fis1);
		
		XSSFSheet ws=wb.getSheet("credentials");
		
		Object[][] data=new Object[ws.getLastRowNum()][ws.getRow(0).getLastCellNum()];
		
		for(int i=1;i<=ws.getLastRowNum();i++)
		{
			for(int j=0;j<ws.getRow(i).getLastCellNum();j++)
			{
				data[i-1][j]=ws.getRow(i).getCell(j).getStringCellValue();
			}
		}
		
		
		
		return data;
		
	}
	
}
