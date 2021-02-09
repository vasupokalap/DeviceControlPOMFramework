package com.qa.devicecontrol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.devicecontrol.base.BasePage;
import com.qa.devicecontrol.utils.Constants;
import com.qa.devicecontrol.utils.ElementUtil;

public class HomePage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By header = By.xpath("//div[text()=' DEVICE MANAGER ']");
	private By profiles = By.xpath("//span[text()='Profiles']");
	private By qubicdevices = By.xpath("//span[text()=' Qbic Devices']");
	private By devices = By.xpath("//span[text()='Devices']");
	private By themes = By.xpath("//span[text()='Themes']");
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getHomePageTitle() {
		//return driver.getTitle();
		return elementUtil.waitforTitlePresent(Constants.HOME_PAGE_TITLE, 30);
	}
	
	public String getHeaderValue() {
		
		/*
		 * if(driver.findElement(header).isDisplayed()) { return
		 * driver.findElement(header).getText(); } return null;
		 */
		
		if(elementUtil.doIsDisplayed(header)) {
			return elementUtil.doGetText(header);
		}
		return null;
	}
	public boolean isProfilesTabExists() {
		//return driver.findElement(profiles).isDisplayed();
		return elementUtil.doIsDisplayed(profiles);
	}
	
	public boolean isQubicdevicesTabExists() {
		//return driver.findElement(qubicdevices).isDisplayed();
		return elementUtil.doIsDisplayed(qubicdevices);
	}
	
	public boolean isDevicesTabExists() {
		//return driver.findElement(devices).isDisplayed();
		return elementUtil.doIsDisplayed(devices);
	}
	
	public boolean isThemesTabExists() {
		//return driver.findElement(themes).isDisplayed();
		return elementUtil.doIsDisplayed(themes);
	}
	
	private void clickonProfilesOption() {
		elementUtil.waitforElementPresent(profiles, 15);
		elementUtil.doClick(profiles);
	}
	
	private void clickonThemesOption() {
		elementUtil.waitforElementPresent(themes, 15);
		elementUtil.doClick(themes);
	}
	
	public ProfilesPage gotoProfilesPage() {
		clickonProfilesOption();
		return new ProfilesPage(driver);	
	}
	
	public ThemesPage gotoThemesPage() {
		clickonThemesOption();
		return new ThemesPage(driver);	
	}

}
