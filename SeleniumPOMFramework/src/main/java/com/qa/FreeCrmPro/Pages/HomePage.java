package com.qa.FreeCrmPro.Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.FreeCrmPro.TestBase.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath = "//td[contains(text(),'User: Vaishali Chavan')]")
	WebElement user;
	
	@FindBy(xpath = "//a[contains(text(),'Campaigns')]")
	WebElement companies;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contacts;
	
	@FindBy(xpath = "//a[contains(text(),'Deals')]")
	WebElement deals;

	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public String validateHomePageTitle()
	{
		return driver.getTitle();
		
	}
	
	public Companies clickOnCompanies()
	{
		companies.click();
		return new Companies();
		
	}
	
	public Contacts clickOnContacts()
	{
		contacts.click();
		return new Contacts();
	}
	
	public Deals clickOnDeals()
	{
		deals.click();
		return new Deals();
	}
	
	public boolean verifyCurrentUser()
	{
		return user.isDisplayed();
	}
	
	public void clickOnNewContactLink(){
		Actions action = new Actions(driver);
		action.moveToElement(contactsLink).build().perform();
		newContactLink.click();
		
	}

}
