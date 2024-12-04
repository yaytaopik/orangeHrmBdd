package com.testorangehrm.library;

import org.openqa.selenium.WebDriver;



public class TestContext extends DriverManager {
	
	private  CommonUtilities commonUtilities;
	
	public TestContext()
	  {
		setupDriver();
	  }

	  public WebDriver getDriver()
	  {
	    return driver;
	  }
	  
	  public CommonUtilities getCommonUtilities()
	  {
	    if(commonUtilities==null)
	    {
	    	commonUtilities = new CommonUtilities(driver);
	    }
	    return commonUtilities;
	  } 

}
