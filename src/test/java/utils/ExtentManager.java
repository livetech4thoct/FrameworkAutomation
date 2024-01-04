package utils;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base.BaseTest;

public class ExtentManager extends BaseTest {

	public static ExtentReports getReports()
	{
		
		
		
		if(reports==null)
		{
			 reports=new ExtentReports();
			
			String reportsDirPath=System.getProperty("user.dir")+"\\reports";
			File reportsDir=new File(reportsDirPath);
			
			reportsDir.mkdir();
			
			String pattern = "yyyy-MM-dd HH:mm:ss";
			SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
			
			String date = simpleDateFormat.format(new Date());
			System.out.println(date);
			date=date.replace(":", "-");
			System.out.println(date);
			
			File reportFile=new File(reportsDirPath+"\\"+date+".html");
			
			ExtentSparkReporter reporter=new ExtentSparkReporter(reportFile);
			
			reporter.config().setDocumentTitle("Adactin Regression Tests Reports");
			
			reporter.config().setTheme(Theme.DARK);
			
			reports.attachReporter(reporter);
			
			
			
		}
		
		return reports;
		
		
	}
}
