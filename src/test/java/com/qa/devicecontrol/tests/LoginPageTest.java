package com.qa.devicecontrol.tests;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BasePage;
import com.qa.devicecontrol.base.BaseTest;
import com.qa.devicecontrol.pages.LoginPage;
import com.qa.devicecontrol.utils.Constants;

public class LoginPageTest extends BaseTest{
	
	
	@Test(priority=1)
	public void verifyLoginPageTitleTest() {
		String title = loginPage.getLoginPageTitle();
		System.out.println("Login page title is: \t" +title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE);
	}
	
	@Test(priority=2)
	public void verifyUsernamefieldTest() {
		Assert.assertTrue(loginPage.isUsernameFieldExist());
	}
	
	@Test(priority=3)
	public void loginTest(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	

}
