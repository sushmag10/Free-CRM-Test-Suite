package com.crm.qa.basetest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.EventFiringDecorator;

import com.crm.qa.util.EventListener;
import com.crm.qa.util.TestUtil;

public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	

	public TestBase() {
		
		prop = new Properties();
		try {
			FileInputStream ip = new FileInputStream("C:\\Users\\sushm\\eclipse-workspace\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\config\\config.properties");
		prop.load(ip);
		}		
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}catch (IOException e) {
			e.printStackTrace();
		}
	}
		
		public static void initialization() {
			String browsername = prop.getProperty("browser");
			if (browsername.contains("chrome")) {
				driver = new ChromeDriver();
			}
			
			//For event listener
			// Create an instance of the event listener
			EventListener eventListener = new EventListener();
			// Wrap the WebDriver instance with the EventFiringDecorator to listen to events
			WebDriver decorated = new EventFiringDecorator(eventListener).decorate(driver);
			driver = decorated;
			
			
			
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.page_Load_Timeout));
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.implicitly_Wait));
			driver.get(prop.getProperty("url"));
		
		}
		
	}
	
	
	
	

