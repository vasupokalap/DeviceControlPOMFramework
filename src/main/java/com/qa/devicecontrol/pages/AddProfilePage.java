package com.qa.devicecontrol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.devicecontrol.utils.ElementUtil;

public class AddProfilePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	private By addprofilebutton = By.xpath("//span[text()='Add Profile']");
	private By selectroomdisplay = By.xpath("//div[text()='Room Display']");
	private By selectroomdisplaycalenderview = By.xpath("//div[text()='Calendar view']");
	private By selectFloorDisplayview = By.xpath("//div[text()='Floor Display']");
	private By selectFeedbackDisplayview = By.xpath("//div[text()='Feedback Display']");
	
	private By enableToogleButtons = By.xpath("//div[@class='mat-slide-toggle-bar']//input[@aria-checked='false']");
	private By enableToogleButton = By.xpath("//input[@type='checkbox'][@aria-checked='false']");
	
	private By profilenametextfield = By.id("profileName");
	private By profileSavebutton = By.xpath("//span[text()=' Save ']");
	private By profilename = By.xpath("(//span[@class='clamp-reference'])[position()=1]");

	
	
	public AddProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public void addRoomDisplayEventsProfile(String EventsviewProfileName) {
		//elementUtil.doClick(addprofilebutton);
		elementUtil.waitforElementPresent(selectroomdisplay, 10);
		elementUtil.doClick(selectroomdisplay);
		elementUtil.waitforElementToBeVisible(profilenametextfield, 10);
		elementUtil.doSendKeys(profilenametextfield, EventsviewProfileName);
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * elementUtil.waitforElementToBeVisible(enableToogleButton, 10);
		 * 
		 * List<WebElement> EnableToogleCount = driver.findElements(enableToogleButton);
		 * 
		 * for(int i=0;i<EnableToogleCount.size();i++) {
		 * EnableToogleCount.get(i).click(); }
		 */
		
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(profilename, 10);
		
	}
	
	public void addRoomDisplayCalenderProfile(String CalenderViewProfileName) {
		elementUtil.waitforElementPresent(addprofilebutton, 20);
		elementUtil.doClick(addprofilebutton);
		elementUtil.waitforElementPresent(selectroomdisplaycalenderview, 10);
		elementUtil.doClick(selectroomdisplaycalenderview);
		elementUtil.waitforElementToBeVisible(profilenametextfield, 10);
		elementUtil.doSendKeys(profilenametextfield, CalenderViewProfileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(profilename, 10);
		
	}
	
	public void addFloorDisplayProfile(String FloorDisplayProfileName) {
		elementUtil.waitforElementPresent(addprofilebutton, 20);
		elementUtil.doClick(addprofilebutton);
		elementUtil.waitforElementPresent(selectFloorDisplayview, 10);
		elementUtil.doClick(selectFloorDisplayview);
		elementUtil.waitforElementToBeVisible(profilenametextfield, 10);
		elementUtil.doSendKeys(profilenametextfield, FloorDisplayProfileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(profilename, 10);
		
	}
	
	public void addFeedbackDisplayProfile(String FeedbackDisplayProfileName) {
		elementUtil.waitforElementPresent(addprofilebutton, 20);
		elementUtil.doClick(addprofilebutton);
		elementUtil.waitforElementPresent(selectFeedbackDisplayview, 10);
		elementUtil.doClick(selectFeedbackDisplayview);
		elementUtil.waitforElementToBeVisible(profilenametextfield, 10);
		elementUtil.doSendKeys(profilenametextfield, FeedbackDisplayProfileName);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		elementUtil.doClick(profileSavebutton);
		elementUtil.waitforElementToBeVisible(profilename, 10);
		
	}

}
