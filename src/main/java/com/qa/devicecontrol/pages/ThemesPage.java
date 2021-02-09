package com.qa.devicecontrol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.devicecontrol.utils.ElementUtil;

public class ThemesPage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By Themesheader = By.xpath("//span[text()='Themes']");
	private By Themesearchbox = By.xpath("//input[@class='inputsearch-box']");
	private By Addthemebutton = By.xpath("//span[text()='Add Theme']");
	
	
	public ThemesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	public String getThemesPageHeader() {
		elementUtil.waitforElementPresent(Themesheader, 10);
		return elementUtil.doGetText(Themesheader);
	}
	
	public boolean isThemesearchBoxExists() {
		return elementUtil.doIsDisplayed(Themesearchbox);
	}
	
	public boolean isAddThemeButtonExists() {
		return elementUtil.doIsDisplayed(Addthemebutton);
		
	}
	
	private void clickonAddThemesOption() {
		elementUtil.doClick(Addthemebutton);
	}
	
	public AddThemesPage gotoAddThemesPage() {
		clickonAddThemesOption();
		return new AddThemesPage(driver);
	}

}
