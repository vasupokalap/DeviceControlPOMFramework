package com.qa.devicecontrol.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BaseTest;

public class EditProfilePageTest extends BaseTest{
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		profilesPage = homePage.gotoProfilesPage();
		editProfile = profilesPage.gotoEditRoomDisplayProfilesPage();
	}
	
	@Test(priority=1, enabled=true)
	public void editRoomDisplayProfileTest() throws InterruptedException {
		editProfile.editRoomDisplayEventsProfile();
	}	
	
	
	@Test(priority=2)
	public void editFloorDisplayProfileTest() {
		editProfile.editFloorDisplayProfile();
	}	
	
	@Test(priority=3)
	public void editFeedbackDisplayProfile() {
		editProfile.editFeedbackDisplayProfile();
	}	

}
