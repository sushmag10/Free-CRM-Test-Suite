package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basetest.TestBase;

public class LoginPage extends TestBase{
		
	//Object Repo or page factory
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[contains(text(),'Login')]")
	WebElement loginBtn;
	
	@FindBy(xpath="//a[contains(text(),'Sign Up')]")
	WebElement signUpbtn;
	
	
	//Initializing the page objects
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions
	public String validateLoginPagetitle() {
		return driver.getTitle();
	}
	
	
	public HomePage validateLogin(String userName, String Passwrd) {
		driver.get(prop.getProperty("registerurl"));
		email.sendKeys(userName);
		password.sendKeys(Passwrd);
		loginBtn.click();
		return new HomePage();
	}
	
	

}
