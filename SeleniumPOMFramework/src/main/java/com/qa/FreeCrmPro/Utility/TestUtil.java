package com.qa.FreeCrmPro.Utility;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import com.qa.FreeCrmPro.TestBase.TestBase;

public class TestUtil extends TestBase{
	public static long Page_Load_Timeout=30;
	public static long Implicit_Wait=20;
	public void switchToFrame()
	{
		driver.switchTo().frame("mainpanel");
	}
	public static void captureScreenShots(WebDriver driver)
	{
		
		try {
			File srcFile=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileHandler.copy(srcFile, new File(".//ScreenShots//FreeCrem_"+getCurrentDateTime() +".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Screenshot captured");
	}
	
	public static String getCurrentDateTime()
	{
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy+HH+mm+ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}
	

}
