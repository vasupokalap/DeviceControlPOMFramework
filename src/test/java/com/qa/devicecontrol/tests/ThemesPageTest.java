package com.qa.devicecontrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BaseTest;
import com.qa.devicecontrol.utils.Constants;

public class ThemesPageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		themesPage = homePage.gotoThemesPage();
	}
	
	@Test(priority=1)
	public void verifyThemesPageheaderTest() {
		
		String header = themesPage.getThemesPageHeader();
		Assert.assertEquals(header, Constants.THEMES_PAGE_HEADER);	 
	}

}
