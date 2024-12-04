package com.testorangehrm.library;

import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import io.cucumber.java.BeforeAll;
import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	WebDriver driver;
	ExtentSparkReporter extentSparkReporter;
	ExtentReports extentReports;
	ExtentTest extentTest;
	
	public void setupDriver() {
		ChromeOptions options=new ChromeOptions();
//		options.addArguments("--headless=new");
//		options.addArguments("--start-maximized");
//		options.addArguments("--disable-blink-features=AutomationControlled");
//		options.addArguments("--disable-web-security");
//		options.addArguments("--allow-running-insecure-content");
//        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
//        options.setExperimentalOption("useAutomationExtension", false);
        options.addArguments("user-agent=Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/127.0.0.0 Safari/537.36");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(6));
		driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		//setup extent report
		//create the htmlReporter object 
		  
		
		//Navigate to orangehrm demo
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		
		//create the htmlReporter object 
		  ExtentSparkReporter htmlReporter = new ExtentSparkReporter("extentReport.html");
		//create ExtentReports and attach reporter(s)
		  ExtentReports extent = new ExtentReports();
		  extent.attachReporter(htmlReporter);
		
	}
	
}
