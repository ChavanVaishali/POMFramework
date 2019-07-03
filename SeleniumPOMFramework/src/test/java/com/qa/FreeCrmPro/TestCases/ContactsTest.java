package com.qa.FreeCrmPro.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.Pages.Contacts;
import com.qa.FreeCrmPro.Pages.HomePage;
import com.qa.FreeCrmPro.Pages.LoginPage;
import com.qa.FreeCrmPro.TestBase.TestBase;
import com.qa.FreeCrmPro.Utility.TestUtil;

public class ContactsTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	TestUtil testUtil;
	Contacts contactsPage;
	
	String sheetName = "contacts";
	
	   
	public ContactsTest(){
			super();
			
	}
	
	
	@BeforeMethod
	public void setUp() throws InterruptedException {
		
		initilization(prop.getProperty("browser"), prop.getProperty("url"));
		testUtil = new TestUtil();
		contactsPage = new Contacts();
		loginPage = new LoginPage();
		homePage = loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		TestUtil.runTimeInfo("error", "login successful");
		testUtil.switchToFrame();
		contactsPage = homePage.clickOnContacts();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(contactsPage.verifyContactsLabel(), "contacts label is missing on the page");
	}
	
	@Test(priority=2)
	public void selectSingleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
	}
	
	@Test(priority=3)
	public void selectMultipleContactsTest(){
		contactsPage.selectContactsByName("test2 test2");
		contactsPage.selectContactsByName("ui uiii");

	}
	
	@DataProvider
	public Object[][] getExcelData() {
		
		//registration
		return dataprovider.getExcelData("contacts");

	}
	
	
	@Test(priority=4, dataProvider="getExcelData")
	public void validateCreateNewContact(String title, String firstName, String lastName, String company){
		logger = report.createTest("Create New Contact");
		homePage.clickOnNewContactLink();
		
		contactsPage.createNewContact(title, firstName, lastName, company);
		
	}
	
	

	@AfterMethod
	public void tearDown(){
		driver.quit();
	}
	
	
	
	
}
