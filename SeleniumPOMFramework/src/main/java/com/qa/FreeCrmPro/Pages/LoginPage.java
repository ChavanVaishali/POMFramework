package com.qa.FreeCrmPro.Pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCrmPro.TestBase.TestBase;

public class LoginPage extends TestBase{
	//Page Factory
	@FindBy(name = "username")
	WebElement username;
	
	@FindBy(name = "password")
	WebElement password;
	
	@FindBy(xpath = "//input[@type ='submit']")
	WebElement loginbtn;
	
	@FindBy(xpath = "//input[@type ='reset']")
	WebElement resetbtn;
	
	@FindBy(xpath = "//a[contains(text(),'Sign Up')]")
	WebElement signupbtn;
	
	@FindBy(xpath = "//img[contains(@src,'https://d3lh3kd7bj2evy.cloudfront.net/img/logo.png')]")
	WebElement logo;
	
	@FindBy(xpath="//a[text()='Sign Up']")
	WebElement signUpLink;
	
	// PageFactory
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	//Actions
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	public boolean validateCrmImage()
	{
		return logo.isDisplayed();
		
	}
	public HomePage login(String usr, String pwd)
	{
		username.sendKeys(usr);
		password.sendKeys(pwd);
		loginbtn.submit();
		
		return new HomePage();
	}

public RegPage clickOnSignUpLink(){
		
		//sigUpLink.click();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", signUpLink);
		
		return new RegPage();
	}
}
