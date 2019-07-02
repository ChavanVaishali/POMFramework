package com.qa.FreeCrmPro.TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.FreeCrmPro.Pages.CompanyDetails;
import com.qa.FreeCrmPro.Pages.LoginPage;
import com.qa.FreeCrmPro.Pages.RegPage;
import com.qa.FreeCrmPro.TestBase.TestBase;

public class CompanyDetailsTest extends TestBase{
	LoginPage loginPage;
	RegPage regPage;
	CompanyDetails companyDetails;
	@BeforeMethod
	public void setUp() {
		
		initilization(prop.getProperty("browser"), prop.getProperty("url"));

		loginPage = new LoginPage();
		companyDetails = regPage.clickOnSubmit();
	}

	@Test(dataProvider="getExcelData")
	public void EnterCompanyDetailsTest(String companyName, String phoneNo) {
		companyDetails.EnterCompanyDetails(companyName, phoneNo);
		
	}
	@DataProvider
	public Object[][] getExcelData() {
		
		//registration
		return dataprovider.getExcelData("CompanyDetails");

	}

}


