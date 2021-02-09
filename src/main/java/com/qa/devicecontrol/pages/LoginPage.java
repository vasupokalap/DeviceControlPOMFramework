package com.qa.devicecontrol.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.qa.devicecontrol.base.BasePage;
import com.qa.devicecontrol.utils.Constants;
import com.qa.devicecontrol.utils.ElementUtil;

public class LoginPage extends BasePage{
	
	private WebDriver driver;
	ElementUtil elementUtil;
	
	//By Locators - OR
	private By username = By.name("username");
	//private By username2 = By.className("Vasu");
	private By password = By.name("password");
	private By loginbutton = By.xpath("//span[@class='mat-button-wrapper']");
	private By qubicdevicesoption = By.xpath("//span[text()=' Qbic Devices']");
	
	//Constructor of the page:
	public LoginPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	//Page Actions
	
	public String getLoginPageTitle() {
		return elementUtil.waitforTitlePresent(Constants.LOGIN_PAGE_TITLE, 30);
	}
	
	public boolean isUsernameFieldExist() {
		return elementUtil.doIsDisplayed(username);
	}
	
	public HomePage doLogin(String un, String pwd) {
		//driver.findElement(username).sendKeys(un);
		elementUtil.doSendKeys(username, un);
		//driver.findElement(password).sendKeys(pwd);
		elementUtil.doSendKeys(password, pwd);
		elementUtil.doClick(loginbutton);
		//driver.findElement(loginbutton).click();
		elementUtil.waitforElementPresent(qubicdevicesoption, 20);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new HomePage(driver);
	}

}
