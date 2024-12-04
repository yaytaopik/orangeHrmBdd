package com.testorangehrm.library;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.NoSuchElementException;
import java.util.Random;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.JavascriptExecutor;

public class CommonUtilities {
	
	
	//this is for driver
	public WebDriver driver;

	public CommonUtilities(WebDriver driver) {
		this.driver = driver;
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public void sendKeys(By locator, String input) {
		driver.findElement(locator).sendKeys(input);
	}
	
	public String generateRandomNumber() {
		Random rand = new Random();

		// Generate random integers in range 0 to 999
		int random_integer = rand.nextInt(10000);
		System.out.println("Random Integers: "+random_integer);
		
		return String.valueOf(random_integer);
	}
	
	//clearfield
	public void clearField(By locator) {
		WebElement txt = driver.findElement(locator);
		txt.clear();
	}
	
	public void clearValue(By locator) throws InterruptedException {
		WebElement val = driver.findElement(locator);
		val.sendKeys(Keys.COMMAND + "a");
		threadSleepMedium();
		val.sendKeys(Keys.DELETE);
	}
	
	//assert
	
	public void isDisplayed(By locator) {
		driver.findElement(locator).isDisplayed();
	}
	
	public void isVerifyText(By locator, String expected) {
		waitShort();
		String text = driver.findElement(locator).getText();
		Assert.assertEquals(text, expected );
	}
	//delay
	
	public void waitShort() {

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
	}
	
	
	public void waitMedium() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(4));
	}
	
	public void waitLong() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
	}
	
	public void threadSleepShort() throws InterruptedException {

		Thread.sleep(1500);
	}
	
	public void threadSleepMedium() throws InterruptedException {
		Thread.sleep(4000);
	}
	
	public void threadSleepLong() throws InterruptedException {
		Thread.sleep(6000);
	}
	
	
	public void closeBrowser() {
		driver.close();
	} 
	
}
