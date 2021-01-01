package com.qa.devicecontrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BaseTest;
import com.qa.devicecontrol.pages.HomePage;
import com.qa.devicecontrol.utils.Constants;

public class HomePageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void verifyHomePageTitleTest() {
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page Title is: \t" + title);
		
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
			
	}
	
	@Test(priority=2)
	public void verifyHeaderTest() {
		String header = homePage.getHeaderValue();
		System.out.println("Home Page Header \t"+header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	@Test(priority=5)
	public void verifyProfilesTabTest() {
		Assert.assertTrue(homePage.isProfilesTabExists());
	}
	
	@Test(priority=3)
	public void verifyQubicDeviesTabTest() {
		Assert.assertTrue(homePage.isQubicdevicesTabExists());
	}
	
	@Test(priority=4)
	public void verifyDeviesTabTest() {
		Assert.assertTrue(homePage.isDevicesTabExists());
	}
	
	@Test(priority=6)
	public void verifyThemesTabTest() {
		Assert.assertTrue(homePage.isThemesTabExists());
	}
	
	
}
