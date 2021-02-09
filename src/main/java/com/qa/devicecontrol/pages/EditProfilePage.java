package com.qa.devicecontrol.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.devicecontrol.utils.ElementUtil;

public class EditProfilePage {
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//Room Display Elements
	private By editroomdisplaybutton = By.xpath("(//span[text()='Room Display']/../../..//span[@class='edit-text'])[1]");
	private By selectdisplaytypedropdown = By.xpath("(//div[@class='mat-form-field-infix'])[2]");
	private By selectroomdisplaycalenderview = By.xpath("//p[text()='Room Display - Calendar View']");
	
	private By selectIdentiCheckBoxes = By.xpath("//div[@class='mat-checkbox-inner-container']");
	
	private By bookmeetingselectscanQRCode = By.xpath("(//div[@class='mat-checkbox-inner-container'])[3]");
	private By profileSavebutton = By.xpath("//span[text()=' Save ']");
	
	//Floor Display Elements
	private By editfloordisplaybutton = By.xpath("(//span[text()='Floor Display']/../../..//span[@class='edit-text'])[1]");
	private By selectGridViewOption = By.xpath("(//div[@class='mat-slide-toggle-thumb-container'])[3]");
	private By selectFeedbackTileOption = By.xpath("(//div[@class='mat-slide-toggle-thumb'])[6]");
	
	//Feedback Display Elements
	private By editfeedbackdisplaybutton = By.xpath("(//span[text()='Feedback Display']/../../..//span[@class='edit-text'])[1]");
	private By uploadLogoOption = By.xpath("//input[@id='upload-logo-file-btn']");
	
	
	public EditProfilePage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	
	public void editRoomDisplayEventsProfile() {
		
		elementUtil.waitforElementPresent(selectdisplaytypedropdown, 10);
		elementUtil.doClick(selectdisplaytypedropdown);
		elementUtil.waitforElementToBeVisible(selectroomdisplaycalenderview, 10);
		elementUtil.doClick(selectroomdisplaycalenderview);
		//elementUtil.doClick(bookmeetingselectscanQRCode);
		
		List<WebElement> IdentiCheckboxCount = driver.findElements(selectIdentiCheckBoxes);
		
		for(int i=0;i<IdentiCheckboxCount.size();i++) {
			IdentiCheckboxCount.get(i).click();
		}
		
		elementUtil.doClick(profileSavebutton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void editFloorDisplayProfile() {
		
		elementUtil.waitforElementPresent(editfloordisplaybutton, 10);
		elementUtil.doClick(editfloordisplaybutton);
		elementUtil.waitforElementPresent(selectGridViewOption, 20);
		elementUtil.doClick(selectGridViewOption);
		elementUtil.doClick(selectFeedbackTileOption);
		 
		List<WebElement> IdentiCheckboxCount = driver.findElements(selectIdentiCheckBoxes);
		
		for(int i=0;i<IdentiCheckboxCount.size()-5;i++) {
			IdentiCheckboxCount.get(i).click();
		}
		
		elementUtil.doClick(profileSavebutton);
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
public void editFeedbackDisplayProfile() {
		
		elementUtil.waitforElementPresent(editfeedbackdisplaybutton, 20);
		elementUtil.doClick(editfeedbackdisplaybutton);
		elementUtil.waitforElementToBeVisible(uploadLogoOption, 20);		
		driver.findElement(uploadLogoOption).sendKeys("C:\\Users\\VPA\\Desktop\\SpacewellLogo.jpg");
		elementUtil.doClick(profileSavebutton);
		 
		
	}
	
}
