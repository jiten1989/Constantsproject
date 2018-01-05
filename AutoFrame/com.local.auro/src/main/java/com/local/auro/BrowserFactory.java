package com.local.auro;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BrowserFactory {

	public static WebDriver driver;
	final static Logger log = Logger.getLogger(BrowserFactory.class);

	public void setDriver(String browser) {

		DesiredCapabilities desiredCapabilities;
		log.info("Browser : " + browser);
		if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:/Selenium/geckodriver.exe");
			driver = new FirefoxDriver();
			log.info("driver : " + driver);
		}
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability("marionette", true);
			driver = new ChromeDriver();
			log.info("driver : " + driver);
		} else {
			System.setProperty("webdriver.chrome.driver", "C:/Selenium/chromedriver.exe");
			desiredCapabilities = DesiredCapabilities.chrome();
			desiredCapabilities.setCapability("marionette", true);
			driver = new ChromeDriver();
			log.info("default driver : " + driver);
		}
	}

	public WebDriver getDriver() {
		driver.manage().window().maximize();
		return driver;
	}
}
