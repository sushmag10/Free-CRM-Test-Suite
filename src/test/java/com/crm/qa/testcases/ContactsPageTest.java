package com.crm.qa.testcases;

import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.basetest.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class ContactsPageTest extends TestBase{

	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
	TestUtil testUtil;
	
	public ContactsPageTest() {
		super();
	}
	
	@BeforeMethod
	public void setUp() {
		initialization();
		loginPage = new LoginPage();
		homePage = new HomePage();
		contactsPage = new ContactsPage();
		testUtil = new TestUtil();
		loginPage.validateLogin(prop.getProperty("username"), prop.getProperty("password"));
		homePage.validateClickonContactsLink();
	}
	
	@Test(priority=1)
	public void validateContactsLabelTest() {
	String contactslabel=contactsPage.validateContactsPageLabel();
	Assert.assertEquals(contactslabel, "Contacts");
	}
	
	@Test(priority=2)
	public void validateSingleContactTest() {
		contactsPage.validateSelectContactsCheckbox("Test1 Testlast");
	}
	
	@DataProvider
    public Object[][] providecontactsData() throws IOException, InvalidFormatException {
        // Provide the path to the Excel file and the sheet name
        return testUtil.getExcelData("C:\\Users\\sushm\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\testdata\\Free CRM test data.xlsx", "contacts");
    }

	
	
	@Test(priority=3, dataProvider = "providecontactsData")
	public void validateCreateContactTest(String ftname, String ltname, String descp) {
		contactsPage.validateClickonCreateContactLink();
		contactsPage.createNewContact(ftname, ltname, descp);
		contactsPage.clickSaveBtn();
	}
	
		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
	
	
}
