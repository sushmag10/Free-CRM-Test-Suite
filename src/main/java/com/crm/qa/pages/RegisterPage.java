package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basetest.TestBase;

public class RegisterPage extends TestBase{
	
	@FindBy(xpath="//a[@href='https://ui.freecrm.com/register/']")
	WebElement StartHerebtn;
	
	//Initializing the page objects
		public RegisterPage() {
			PageFactory.initElements(driver, this);
		}
		
	
	public LoginPage validateStartHereBtn() {
		StartHerebtn.click();
		return new LoginPage();
	}
	
	
	

}
