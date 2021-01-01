package com.qa.devicecontrol.base;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.devicecontrol.pages.HomePage;
import com.qa.devicecontrol.pages.LoginPage;
import com.qa.devicecontrol.pages.ProfilesPage;

public class BaseTest {
	
	WebDriver driver;
	public Properties prop;
	public BasePage basePage;
	public LoginPage loginPage;
	public HomePage homePage;
	public ProfilesPage profilesPage;
	
	@BeforeTest
	public void setUp() {
		
		basePage = new BasePage();
		basePage.init_prop();
		driver = basePage.init_driver();
		prop=basePage.prop;
		loginPage = new LoginPage(driver);	
	}
	
	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
