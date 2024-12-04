package com.testorangehrm.ui;
import org.openqa.selenium.By;

public class LoginUi {
	public By txtbox_username = By.xpath("//input[@placeholder='Username']");
	public By txtbox_password = By.xpath("//input[@placeholder='Password']");
	public By button_login = By.xpath("//button[normalize-space()='Login']");
	//button
	public By headertext_dashboard = By.xpath("//h6[normalize-space()='Dashboard']");
	//alert
	public By alert_invalid_credential = By.xpath("//p[@class='oxd-text oxd-text--p oxd-alert-content-text']");
}
