package com.qa.FreeCrmPro.TestCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.Pages.HomePage;
import com.qa.FreeCrmPro.Pages.LoginPage;
import com.qa.FreeCrmPro.TestBase.TestBase;
import com.qa.FreeCrmPro.Utility.TestUtil;

public class LoginPageTest extends TestBase {
	LoginPage loginpage;
	HomePage homepage;
	public LoginPageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initilization(prop.getProperty("browser"), prop.getProperty("url"));

		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = loginpage.validateLoginPageTitle();
		Assert.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	@Test(priority=2)
	public void logoImageTest()
	{
		boolean flag = loginpage.validateCrmImage();
		Assert.assertTrue(flag);
	}
	@Test(priority=3)
	public void loginTest()
	{
		
		logger = report.createTest("Login to CRM");
		logger.info("Starting Application");
		homepage = loginpage.login(dataprovider.getStringData("Login", 1, 0), dataprovider.getStringData("Login", 1, 1));
		logger.pass("Login Successfully");
		logger.fail("Login Failed");
		
	}
	@AfterMethod
	public void tearDown(ITestResult results)
	{
		
		report.flush();
		
		driver.quit();
	}
	

}
