package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.basetest.TestBase;
import com.crm.qa.util.TestUtil;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//span[contains(text(),'Contacts')]")
	WebElement contactsPageLabel;
	
	@FindBy(xpath="//button[contains(text(),'Create')]")
	WebElement createContactLink;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="last_name")
	WebElement lastName;
	
	@FindBy(name="description")
	WebElement description;
	
	@FindBy(xpath="//button[contains(text(),'Save')]")
	WebElement saveBtn;
	
	//Initializing the page objects
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}

	public String validateContactsPageLabel() {
		return contactsPageLabel.getText();
	}
	
	public void validateSelectContactsCheckbox(String name) {
		WebElement contactname = driver.findElement(By.xpath("//a[contains(text(),'"+name+"')]/parent::td//preceding-sibling::td//input[@name='id']"));
		TestUtil.clickelementbyJS(contactname, driver);
	}
	
	public void validateClickonCreateContactLink() {
		createContactLink.click();
	}
	
	public void createNewContact(String fname, String lname, String desc) {
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		description.sendKeys(desc);
		
	}
	
	public void clickSaveBtn() {
		saveBtn.click();
	}
	
}
