package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.basetest.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.pages.RegisterPage;

public class LoginPageTest extends TestBase{
	
	LoginPage loginPage;
	RegisterPage registerPage;
	HomePage homePage;
	public LoginPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		registerPage = new RegisterPage();
		
	}
	
	@Test(priority=1)
	public void loginPageTitleTest() {
		String title = loginPage.validateLoginPagetitle();
		Assert.assertEquals(title, "#1 Free CRM Business Software - FreeCRM.com");
		
	}
	
	@Test(priority=2)
	public void loginPageNavigation() {
		registerPage.validateStartHereBtn();
		String title = driver.getTitle();
		Assert.assertEquals(title, "Cogmento CRM");
		
		
	}
	
	@Test(priority=3)
	public void login() {
		homePage = loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
	

}
