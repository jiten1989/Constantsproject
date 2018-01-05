package com.local.auro;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.thoughtworks.selenium.SeleniumException;

public class BashPageObjectModel {

	public static WebDriver driver;
	private static final Logger log = Logger.getLogger(BashPageObjectModel.class);
	private static String browser;
	private static PropertyReader propertyInstance = new PropertyReader();
	private static final BrowserFactory browserFactory = new BrowserFactory();

	public BashPageObjectModel() throws IOException {
		browser = propertyInstance.getPropValues("browserName");
		browserFactory.setDriver(browser);
		driver = browserFactory.getDriver();
	}

	public void setup() throws IOException {
		log.info("Starting browser" + driver.toString());
		driver.get(propertyInstance.getPropValues("url"));
		log.info("driver invoked with :" + propertyInstance.getPropValues("url"));
	}

	public void clickOnButton(By xpath) throws InterruptedException {
		driver.findElement(xpath).click();
		log.info("element clicked with :" + xpath + " : xpath value");
	}

	public boolean isElementExists(By locator) {
		WebElement element = (WebElement) driver.findElements(locator);
		if (element.getText() != null) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isElementPresent(By locator) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WEB_DRIVER_WAIT);
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			return true;
		} catch (SeleniumException seleniumException) {
			seleniumException.printStackTrace();
			Assert.fail();
			log.warn(seleniumException.getMessage());
			return false;
		}
	}

	public void stop() {
		log.info("driver termination initiated");
		driver.quit();
		log.info("driver terminated.");
	}

	public boolean waitForPageToLoad() {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Constants.DEFAULT_WEB_DRIVER_WAIT);
			wait.until(ExpectedConditions.titleContains(Xpath.PAGE_TITLE));
			return true;
		} catch (SeleniumException seleniumException) {
			seleniumException.printStackTrace();
			Assert.fail();
			log.warn(seleniumException.getMessage());
			return false;

		}

	}

	public boolean sslAlertHandler() throws IOException {
		String url = null;
		String username = propertyInstance.getPropValues("username");
		String password = propertyInstance.getPropValues("password");
		try {
			url = "https://" + username + ":" + password + "@" + propertyInstance.getPropValues("baseurl");
			log.info("login to baseurl :" + url);
			driver.get(url);
			log.info("Skipped authentication alert successful.");
			return true;
		} catch (SeleniumException seleniumException) {
			seleniumException.printStackTrace();
			log.warn(seleniumException.getMessage());
			Assert.fail();
			return false;
		}
	}

	public WebDriverWait defaultWebDriverWait() {
		WebDriverWait wait = null;
		try {
			wait = new WebDriverWait(driver, Constants.DEFAULT_WEB_DRIVER_WAIT);
		} catch (SeleniumException seleniumException) {
			seleniumException.printStackTrace();
			Assert.fail();
		}
		return wait;
	}

	public boolean selectOptionWithText(String textToSelect, String inputXpath, String suggestionXpath) {
		boolean flag=false;
		try {
			WebElement autofillOptions = driver.findElement(By.id(inputXpath));
			defaultWebDriverWait().until(ExpectedConditions.visibilityOf(autofillOptions));
			
			
			List<WebElement> optionsToSelect = autofillOptions.findElements(By.tagName(suggestionXpath));
			for (WebElement option : optionsToSelect) {
				if (option.getText().equals(textToSelect)) {
					log.info("Trying to select: " + textToSelect);
					option.click();
					flag=true;
					break;
				}
			}
			return flag;
		} catch (NoSuchElementException e) {
			log.warn(e.getStackTrace());
			return flag;
		}
	}
}