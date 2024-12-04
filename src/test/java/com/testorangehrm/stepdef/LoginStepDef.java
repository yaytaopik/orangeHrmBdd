package com.testorangehrm.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.testorangehrm.library.TestContext;
import com.testorangehrm.library.CommonUtilities;
import com.testorangehrm.ui.LoginUi;

public class LoginStepDef {
	public WebDriver driver;
	public LoginUi loginUi= new LoginUi();
	TestContext context;
	CommonUtilities commonUtilities;
	
	public LoginStepDef(TestContext context) {
		this.context = context;
		commonUtilities = context.getCommonUtilities();
	}
	
	@Given("Admin login using username {string} and password {string}")
	public void admin_login_using_username_and_password(String username, String password) {
		commonUtilities.sendKeys(loginUi.txtbox_username, username);
		commonUtilities.sendKeys(loginUi.txtbox_password, password);
		commonUtilities.click(loginUi.button_login);
	}

	@Given("Admin successfully login")
	public void admin_successfully_login() {
		commonUtilities.isDisplayed(loginUi.headertext_dashboard);
	}
	
	@Given("Alert message username required should displayed")
	public void alert_message_username_required_should_displayed() {
		commonUtilities.isDisplayed(loginUi.alert_invalid_credential);
	}
	
	@Then("Scenario is completed")
	public void scenario_is_completed() {
	    commonUtilities.closeBrowser();
	}
}
