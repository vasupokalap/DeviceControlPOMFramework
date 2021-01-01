package com.qa.devicecontrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BaseTest;
import com.qa.devicecontrol.utils.Constants;
import com.qa.devicecontrol.utils.ExcelUtil;

public class ProfilesPageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		profilesPage = homePage.gotoProfilesPage();
	}
	
	@Test(priority=1)
	public void verifyProfilesPageheaderTest() {
		
		String header = profilesPage.getProfilesPageHeader();
		Assert.assertEquals(header, Constants.PROFILES_PAGE_HEADER);	 
	}
	
	@DataProvider()
	public Object[][] getProfileTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.PROFILES_SHEET_NAME);
		
		return data;
	}
	
	@Test(dataProvider="getProfileTestData")
	public void createProfileTest(String ProfileName) {
		profilesPage.addRoomDisplayEventsProfile(ProfileName);
	}	
}
