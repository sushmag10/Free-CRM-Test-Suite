package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basetest.TestBase;

public class HomePage extends TestBase{
	
	@FindBy(xpath="//span[contains(@class,'user-display')]")
	WebElement userNameLabel;
	
	@FindBy(xpath="//a[@href='/contacts']")
	WebElement contactsLink;
	
	//Initializing the page objects
			public HomePage() {
				PageFactory.initElements(driver, this);
			}

	//Actions
			public String validateUserName() {
				return userNameLabel.getText();
			}
			
			public ContactsPage validateClickonContactsLink() {
				 contactsLink.click();
				 return new ContactsPage();
			}
	
}
