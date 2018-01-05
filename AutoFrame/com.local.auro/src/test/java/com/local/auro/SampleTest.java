package com.local.auro;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleTest extends BashPageObjectModel {

	public static final Logger log = Logger.getLogger(SampleTest.class);

	String URL = "http://jqueryui.com/autocomplete/";
	private By frameLocator = By.className("demo-frame");
	private By tagText = By.id("tags");
	String needToSearchFromSuggestion = "Java";
	String inputXpath = "ui-id-1";
	String suggestionXpath = "li";

	public SampleTest() throws IOException {
	}

	// @Test
	public void login() throws IOException, InterruptedException {
		setup();
		// clickOnButton(Xpath.ABOUT_US);

		Assert.assertTrue(sslAlertHandler());
		// Assert.assertTrue(waitForPageToLoad());
		stop();
	}

	// @Test
	public void autoFillTest() {
		driver.navigate().to(URL);
		WebElement frameElement = driver.findElement(frameLocator);
		driver.switchTo().frame(frameElement);
		defaultWebDriverWait().until(ExpectedConditions.presenceOfElementLocated(tagText));
		WebElement textBoxElement = driver.findElement(tagText);
		textBoxElement.sendKeys("a");
		Assert.assertTrue(selectOptionWithText(needToSearchFromSuggestion, inputXpath, suggestionXpath));
		log.info("element found");
	}

	//@Test
	public void autofill() throws IOException {
		// open browser windows with following url
		driver.navigate().to(new PropertyReader().getPropValues("url"));
		// navigate search box on web page
		driver.findElement(By.name("q")).sendKeys("a");

		WebElement searchbox = driver.findElement(By.className(""));

		WebDriverWait wait = defaultWebDriverWait();
		wait.until(ExpectedConditions.visibilityOf(searchbox));

		List<WebElement> list = driver.findElements(By.tagName("tr"));

		for (WebElement webElement : list) {

			System.err.println("XXX" + webElement.toString());
			if (webElement.equals("airtel")) {
				log.info("element found in suggestion list.");
				break;
			}
		}
}
	
	@Test  
	  public void SearchSuggestion() {  

		String searchtext="amazon";
	  driver.get("http://google.com");  
	  driver.findElement(By.name("q")).sendKeys("a");  

	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	   WebElement table = driver.findElement(By.className("sbsb_b"));   
	   List<WebElement> rows = table.findElements(By.tagName("li"));   
	   Iterator<WebElement> i = rows.iterator();   
	   while(i.hasNext()) {   
		   if(i.next().getText().equalsIgnoreCase(searchtext))
		   {
			   System.err.println("text found as : "+searchtext);
			   break;
		   } 
	   }   
	  }   
	}


