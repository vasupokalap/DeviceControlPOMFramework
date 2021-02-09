package com.qa.devicecontrol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.devicecontrol.utils.ElementUtil;

public class ProfilesPage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By profilesheader = By.xpath("//span[text()='Profiles']");
	private By profilesearchbox = By.xpath("//input[@class='inputsearch-box']");
	private By addprofilebutton = By.xpath("//span[text()='Add Profile']");
	private By editroomdisplaybutton = By.xpath("(//span[text()='Room Display']/../../..//span[@class='edit-text'])[1]");
	
	
	public ProfilesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getProfilesPageHeader() {
		elementUtil.waitforElementPresent(profilesheader, 10);
		return elementUtil.doGetText(profilesheader);
	}
	
	public boolean isProfileSearchBoxExists() {
		return elementUtil.doIsDisplayed(profilesearchbox);
	}
	
	public boolean isAddProfileButtonExists() {
		return elementUtil.doIsDisplayed(addprofilebutton);
		
	}
	
	private void clickonAddProfilesOption() {
		elementUtil.doClick(addprofilebutton);
	}
	
	private void clickonEditRoomDisplayProfilesOption() {
		elementUtil.doClick(editroomdisplaybutton);
	}
	
	public AddProfilePage gotoAddProfilesPage() {
		clickonAddProfilesOption();
		return new AddProfilePage(driver);
	}
	
	public EditProfilePage gotoEditRoomDisplayProfilesPage() {
		clickonEditRoomDisplayProfilesOption();
		return new EditProfilePage(driver);
	}

}
