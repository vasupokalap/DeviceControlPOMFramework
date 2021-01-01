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
	private By selectroomdisplay = By.xpath("//div[text()='Room Display']");
	private By profilenametextfield = By.id("profileName");
	private By profileSavebutton = By.xpath("//span[text()=' Save ']");
	private By profilename = By.xpath("(//span[@class='clamp-reference'])[position()=1]");
	//private By profiledelete = By.xpath("(//span[@class='delete-text'])[position()=1]");
	private By profiledelete = By.xpath("(//span[text()='Delete']");
	
	
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
	
	public void addRoomDisplayEventsProfile(String ProfileName) {
		elementUtil.doClick(addprofilebutton);
		elementUtil.waitforElementPresent(selectroomdisplay, 10);
		elementUtil.doClick(selectroomdisplay);
		elementUtil.waitforElementToBeVisible(profilenametextfield, 10);
		elementUtil.doSendKeys(profilenametextfield, ProfileName);
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(profilename, 10);
		for(int i=0;i<=3;i++) {
			try {
				elementUtil.doClick(profiledelete);
				break;
			}catch(Exception e){
				System.out.println(e.getMessage());
			}
			
		}
		
	}

}
