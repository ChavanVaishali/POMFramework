package com.qa.FreeCrmPro.Pages;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.qa.FreeCrmPro.TestBase.TestBase;

public class RegPage extends TestBase{
	
			 @FindBy(how = How.ID, using = "payment_plan_id") 
			 WebElement selectDD;
			 
			 @FindBy(how = How.NAME, using = "first_name") 
			 WebElement fname;
			 
			 @FindBy(how = How.NAME, using = "surname") 
			 WebElement lname;
			 
			 @FindBy(how = How.NAME, using = "email") 
			 WebElement eid;
			 
			 @FindBy(how = How.NAME, using = "email_confirm") 
			 WebElement confirmEid;
			 
			 
			 @FindBy(how = How.NAME, using = "username") 
			 WebElement userName;
			 
			 @FindBy(how = How.NAME, using = "password") 
			 WebElement userPwd;
			 
			 @FindBy(how = How.NAME, using = "passwordconfirm") 
			 WebElement confirmUserPwd;
			 
			 @FindBy(how = How.NAME, using = "agreeTerms") 
			 WebElement checkBox;
			 
			 
			 @FindBy(how = How.NAME, using = "submitButton") 
			 WebElement submitBtn;
			 
			 @FindBy(how = How.NAME, using = "company_name") 
			 WebElement cname;
			 
			 @FindBy(how = How.NAME, using = "phone") 
			 WebElement phone;
			 
			 @FindBy(how = How.NAME, using = "btnSubmit") 
			 WebElement Btncontinue;
			 public RegPage(){
				 
				 PageFactory.initElements(driver, this);
			 }
			 
			 public CompanyDetails clickOnSubmit(){
					
					//sigUpLink.click();
					
					JavascriptExecutor js = (JavascriptExecutor)driver;
					js.executeScript("arguments[0].click();", submitBtn);
					return new CompanyDetails();
			 }
			 public void createNewFreeCrmProNewUSer(String dd_Text,String firstName, String lastName, 
					 String emailId, String confirmEmailID, String username, String u_pwd, String confirmUser_pwd){
				 
				Select sel= new Select(selectDD);
				
				sel.selectByVisibleText(dd_Text);
				
				fname.sendKeys(firstName);
				
				lname.sendKeys(lastName);
				
				eid.sendKeys(emailId);
				
				confirmEid.sendKeys(confirmEmailID);
				
				userName.sendKeys(username);
				
				userPwd.sendKeys(u_pwd);
				
				confirmUserPwd.sendKeys(confirmUser_pwd);
				
				checkBox.click();
				
				submitBtn.click();
				
			 }
			 public void EnterCompanyDetails(String companyName,String phoneNo){
				 
				 cname.sendKeys(companyName);
				 phone.sendKeys(phoneNo);
				 Btncontinue.click();
				
			 }
			 
			 

}
