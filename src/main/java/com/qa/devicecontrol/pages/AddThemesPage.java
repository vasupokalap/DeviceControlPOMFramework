package com.qa.devicecontrol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.devicecontrol.utils.ElementUtil;

public class AddThemesPage {
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By addthemebutton = By.xpath("//span[text()='Add Theme']");
	private By selectroomdisplay = By.xpath("//div[text()='Room Display']");
	private By selectFloorDisplay = By.xpath("//div[text()='Floor Display']");
	
	private By roomdisplaythemenametextfield = By.id("themeName");
	private By floordisplaythemenametextfield = By.id("fdThemeName");
	private By profileSavebutton = By.xpath("//span[text()=' Save ']");
	private By themename = By.xpath("(//span[@class='clamp-reference'])[position()=1]");

	
	
	public AddThemesPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public void addRoomDisplayTheme(String RooomdisplayProfileName) {
		/*
		 * elementUtil.doClick(addthemebutton);
		 * elementUtil.waitforElementPresent(selectroomdisplay, 10);
		 */
		elementUtil.doClick(selectroomdisplay);
		elementUtil.waitforElementToBeVisible(roomdisplaythemenametextfield, 10);
		elementUtil.doSendKeys(roomdisplaythemenametextfield, RooomdisplayProfileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(themename, 10);
		
	}
	
	public void addFloorDisplayTheme(String FloorDisplayProfileName) {
		elementUtil.waitforElementPresent(addthemebutton, 20);
		elementUtil.doClick(addthemebutton);
		elementUtil.waitforElementPresent(selectFloorDisplay, 10);
		elementUtil.doClick(selectFloorDisplay);
		elementUtil.waitforElementToBeVisible(floordisplaythemenametextfield, 10);
		elementUtil.doSendKeys(floordisplaythemenametextfield, FloorDisplayProfileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(themename, 10);
		
	}
}
