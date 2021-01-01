package com.qa.devicecontrol.utils;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.devicecontrol.base.BasePage;

public class ElementUtil {
	
	WebDriver driver;
	JavaScriptUtil jsUtil;
	
	public ElementUtil(WebDriver driver) {
		this.driver = driver;
		jsUtil = new JavaScriptUtil(driver);
		
	}
	
	public  WebElement getElement(By locator) {
		WebElement ele = driver.findElement(locator);
		
		if(Boolean.parseBoolean(BasePage.flastElement)) {
			jsUtil.flash(ele);	
		}
		return ele;	
	}
	
	public  void doSendKeys(By locator, String value) {
		getElement(locator).sendKeys(value);
	}
	
	public void doClick(By locator) {
		getElement(locator).click();
	}
	
	public void doActionsSendKeys(By locator, String text) {
		Actions act = new Actions(driver);
		act.sendKeys(driver.findElement(locator), text).perform();;
	}
	public void doActionsClick(By locator) {
		Actions act = new Actions(driver);
		act.click(driver.findElement(locator)).perform();	
	}
	
	public String doGetText(By locator) {
		return getElement(locator).getText();
	}
	
	public boolean doIsDisplayed(By locator) {
		return getElement(locator).isDisplayed();
	}
	
	public void doLinkClick(List<WebElement> langList, String text) {
		
		   System.out.println(langList.size());
		   for(WebElement ele : langList) { 
			String text1 = ele.getText();
			System.out.println(text1);
			
			if(text.equals("Telugu")) {
				ele.click();
				break;
			}
			
		}
		
	}
	
	//*************************Drop down utils ***************************//
	
	public  void selectDropDownValueByVisibleText(By Locator, String text) {
		Select select = new Select(getElement(Locator));
		select.selectByVisibleText(text);
	}

	public  void selectDropDownValueByIndex(By Locator, int index) {
		Select select = new Select(getElement(Locator));
		select.selectByIndex(index);
	}
	
	public  void selectDropDownValueByValue(By Locator, String text) {
		Select select = new Select(getElement(Locator));
		select.selectByValue(text);
	}
	
	public  int getDropDownOptionsCount(By Locator) {
		Select select = new Select(getElement(Locator));
		List<WebElement> optionsCount = select.getOptions();
		return optionsCount.size();
	}
	
	public  List<String> getDropDownOpitonsValues(By Locator) {
		List<String> textList = new ArrayList<String>();
		Select select = new Select(getElement(Locator));
		List<WebElement> optionsCount = select.getOptions();
		
		for(WebElement ele: optionsCount) {
			String text = ele.getText();
			textList.add(text);
		}
		return textList;
	}
	
	public void selectValuefromDropdownWithoutSelect(By locator, String value) {
		List<WebElement> countryList = driver.findElements(locator);
		
		for(WebElement ele: countryList) {
			String text = ele.getText();
			if(text.equals(value)) {
				ele.click();
				break;
			}
		}
	}
	
	//**************************** Wait Utils ******************************************
	
	public  List<WebElement> visiblityOfAllElements(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
	}
	
	public  void getPageLinksText(By locator, int timeOut) {
		visiblityOfAllElements(locator, timeOut).stream().forEach(ele -> System.out.println(ele.getText()));
	}
	
	public  WebElement waitforElementPresent(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.presenceOfElementLocated(locator));	
	}
	
	public  String waitforTitlePresent(String title, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		wait.until(ExpectedConditions.titleIs(title));
		return driver.getTitle();
	}	
	
	public  WebElement waitforElementToBeVisible(By locator, int timeOut) {
		WebElement element = getElement(locator);
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.visibilityOf(element));	
	}
	
	public  boolean waitForUrl(String url, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.urlContains(url));	
	}
	
	public  Alert waitForAlertToBePresent(int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.alertIsPresent());
	}
	
	public  WebElement waitForElementToBeClickable(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		return wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	public  void clickWhenReady(By locator, int timeOut) {
		WebDriverWait wait = new WebDriverWait(driver, timeOut);
		WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
	}
}
