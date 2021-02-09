package com.qa.devicecontrol.tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.devicecontrol.base.BaseTest;
import com.qa.devicecontrol.utils.Constants;
import com.qa.devicecontrol.utils.ExcelUtil;

public class AddThemesPageTest extends BaseTest {
	
	@BeforeClass
	public void homePageSetUp() {
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		themesPage = homePage.gotoThemesPage();
		addThemesPage = themesPage.gotoAddThemesPage();
	}
	
	
	
	@Test(priority=1)
	public void createRoomDisplayThemesTest() {
		addThemesPage.addRoomDisplayTheme(Constants.ROOMDISPLAY_THEMENAME);
	}	
	
	@Test(priority=2)
	public void createFloorDisplayThemesTest() {
		addThemesPage.addFloorDisplayTheme(Constants.FLOORDISPLAY_THEMENAME);
	}	
	
}
