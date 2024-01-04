package listeners;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

import base.BaseTest;

public class MyTestNGListener  extends BaseTest implements ITestListener {

	@Override
	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestStart(result);
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		
		String testCaseName=result.getMethod().getMethodName();
		String screenshotsDirPath=System.getProperty("user.dir")+"\\screenshots";
		File screenshotsDir=new File(screenshotsDirPath);
		
		screenshotsDir.mkdir();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenshotsDirPath+"\\"+testCaseName+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.addScreenCaptureFromPath(screenshotsDirPath+"\\"+testCaseName+date+".png");
		
		test.log(Status.PASS, testCaseName+" is passed");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testCaseName=result.getMethod().getMethodName();
		String screenshotsDirPath=System.getProperty("user.dir")+"\\screenshots";
		File screenshotsDir=new File(screenshotsDirPath);
		
		screenshotsDir.mkdir();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		
		String date = simpleDateFormat.format(new Date());
		System.out.println(date);
		date=date.replace(":", "-");
		System.out.println(date);
		
		File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File(screenshotsDirPath+"\\"+testCaseName+date+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		test.log(Status.FAIL, testCaseName+" is Failed");
	}
	

	@Override
	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestSkipped(result);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedButWithinSuccessPercentage(result);
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		ITestListener.super.onTestFailedWithTimeout(result);
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onStart(context);
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		ITestListener.super.onFinish(context);
	}

}
