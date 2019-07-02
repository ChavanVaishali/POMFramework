package com.qa.FreeCrmPro.TestCases;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.Pages.CompanyDetails;
import com.qa.FreeCrmPro.Pages.HomePage;
import com.qa.FreeCrmPro.Pages.LoginPage;
import com.qa.FreeCrmPro.Pages.RegPage;
import com.qa.FreeCrmPro.TestBase.TestBase;
import com.qa.FreeCrmPro.Utility.TestUtil;
public class RegPageTest extends TestBase{
	LoginPage loginPage;
	RegPage regPage;
	CompanyDetails companyDetails;
	
	@BeforeMethod
	public void setUp() {
		
		initilization(prop.getProperty("browser"), prop.getProperty("url"));

		loginPage = new LoginPage();
		regPage = loginPage.clickOnSignUpLink();
	}

	@Test(dataProvider="getExcelData")
	public void createNewFreeCrmProNewUSerTest(String dd_Text, String firstName, String lastName,
			String emailId, String confirmEmailID, String username, String u_pwd, String confirmUser_pwd) {
		regPage.createNewFreeCrmProNewUSer(dd_Text, firstName, lastName, emailId, confirmEmailID, username, u_pwd, confirmUser_pwd);
		
	}
	@Test(dataProvider="getExcelData1")
	public void EnterCompanyDetailsTest(String companyName, String phoneNo) {
		companyDetails.EnterCompanyDetails(companyName, phoneNo);
		
	}

	@DataProvider
	public Object[][] getExcelData() {
		
		//registration
		return dataprovider.getExcelData("registration");

	}
	
	
	@DataProvider
	public Object[][] getExcelData1() {
		
		//registration
		return dataprovider.getExcelData("CompanyDetails");

	}

}

