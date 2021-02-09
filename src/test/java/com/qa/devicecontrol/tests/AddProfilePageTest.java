package com.qa.devicecontrol.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BaseTest;
import com.qa.devicecontrol.pages.AddProfilePage;
import com.qa.devicecontrol.utils.Constants;
import com.qa.devicecontrol.utils.ExcelUtil;

public class AddProfilePageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		profilesPage = homePage.gotoProfilesPage();
		addProfilepage = profilesPage.gotoAddProfilesPage();
	}
	
	
	@DataProvider()
	public Object[][] getProfileTestData() {
		Object data[][] = ExcelUtil.getTestData(Constants.MRD_PROFILES_SHEET_NAME);
		return data;
		
	}
	
	/*
	 * @Test(dataProvider="getProfileTestData", priority=1) public void
	 * createRoomDisplaEventsViewProfileTest(String EventsProfileName) {
	 * addProfilepage.addRoomDisplayEventsProfile(EventsProfileName); }
	 */
	
	@Test(priority=1)
	public void createRoomDisplayEventsViewProfileTest() {
		addProfilepage.addRoomDisplayEventsProfile(Constants.MRD_EVENTSVIEW_PROFILENAME);
	}
	
	@Test(priority=2, enabled=false)
	public void createRoomDisplayCalenderViewProfileTest() {
		addProfilepage.addRoomDisplayCalenderProfile(Constants.MRD_CALENDERVIEW_PROFILENAME);
	}	
	
	@Test(priority=3,enabled=false)
	public void createFloorDisplayProfileTest() {
		addProfilepage.addFloorDisplayProfile(Constants.FLOORDISPLAY_PROFILENAME);
	}	
	
	@Test(priority=4,enabled=false)
	public void createFeedbackDisplayProfileTest() {
		addProfilepage.addFeedbackDisplayProfile(Constants.FEEDBACKDISPLAY_PROFILENAME);
	}	

}
