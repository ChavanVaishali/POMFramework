package com.qa.FreeCrmPro.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.Pages.Companies;
import com.qa.FreeCrmPro.Pages.Contacts;
import com.qa.FreeCrmPro.Pages.Deals;
import com.qa.FreeCrmPro.Pages.HomePage;
import com.qa.FreeCrmPro.Pages.LoginPage;
import com.qa.FreeCrmPro.TestBase.TestBase;
import com.qa.FreeCrmPro.Utility.TestUtil;

public class HomePageTest extends TestBase{

	LoginPage loginpage;
	HomePage homepage;
	TestUtil testUtil;
	Contacts contactspage;
	Deals dealsspage;
	Companies companiespage;
	public HomePageTest()
	{
		super();
	}
	
	@BeforeMethod
	public void setUp()
	{
		initilization(prop.getProperty("browser"), prop.getProperty("url"));

		testUtil= new TestUtil();
		contactspage = new Contacts();
		dealsspage = new Deals();
		companiespage = new Companies();
		loginpage = new LoginPage();
		homepage=loginpage.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=1)
	public void loginPageTitleTest()
	{
		String title = homepage.validateHomePageTitle();
		Assert.assertEquals(title, "CRMPRO");
	}
	
	@Test(priority=2)
	public void verifyUserTest()
	{
		testUtil.switchToFrame();
		Assert.assertTrue(homepage.verifyCurrentUser());
	}
	
	@Test(priority=3)
	public void verifyContactsClick()
	{
		testUtil.switchToFrame();
		contactspage = homepage.clickOnContacts();
	}
	
	@Test(priority=4)
	public void verifyCompaniesClick()
	{
		testUtil.switchToFrame();
		companiespage = homepage.clickOnCompanies();
	}

	@Test(priority=5)
	public void verifyDealsClick()
	{
		testUtil.switchToFrame();
		dealsspage = homepage.clickOnDeals();
	}

	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
