package com.qa.FreeCrmPro.TestBase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.qa.FreeCrmPro.Utility.ExcelDataProvider;
import com.qa.FreeCrmPro.Utility.TestUtil;


public class TestBase {
	public static WebDriver driver;

	public static Properties prop;
	
	public static ExcelDataProvider dataprovider;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void beforeSuite(){
		
		dataprovider=new ExcelDataProvider();
		ExtentHtmlReporter extent= new ExtentHtmlReporter(new File(System.getProperty("user.dir") + "/Reports/freeCrm.html"));
		report = new ExtentReports();
		report.attachReporter(extent);
	}
	public TestBase()
	{
		try {
			FileInputStream fis =new FileInputStream("C:\\Users\\r\\Downloads\\eclipse-jee-photon-R-win32\\eclipse\\d\\eclipse-workspace\\SeleniumPOMFramework\\src\\main\\java\\com\\qa\\FreeCrmPro\\Config\\config.properties");
			prop = new Properties();
			prop.load(fis);
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		initilization(prop.getProperty("browser"), prop.getProperty("url"));
	}
	public static void initilization(String brrName, String url)
	{
		String browser = prop.getProperty("browser");
		if(browser.equals("Firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "C:\\Users\\r\\Downloads\\geckodriver-v0.24.0-win32\\geckodriver.exe");
			driver = new FirefoxDriver();}
		else if(browser.equals("chrome"))
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\r\\Desktop\\SelLbray\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_Wait, TimeUnit.SECONDS);
		driver.get(url);
	}
	
	

}
