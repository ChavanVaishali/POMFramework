package com.qa.FreeCrmPro.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCrmPro.TestBase.TestBase;

public class CompanyDetails extends TestBase{
	
	
	 
	 @FindBy(how = How.NAME, using = "company_name") 
	 WebElement cname;
	 
	 @FindBy(how = How.NAME, using = "phone") 
	 WebElement phone;
	 
	 
	 
	 
	 @FindBy(how = How.NAME, using = "btnSubmit") 
	 WebElement Btnsubmit;
	 
	 
	 public CompanyDetails(){
		 
		 PageFactory.initElements(driver, this);
	 }
	 
	 
	 public void EnterCompanyDetails(String companyName,String phoneNo){
		 
		 cname.sendKeys(companyName);
		 phone.sendKeys(phoneNo);
		 Btnsubmit.click();
		
	 }

}

