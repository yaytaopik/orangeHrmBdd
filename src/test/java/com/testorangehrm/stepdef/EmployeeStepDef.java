package com.testorangehrm.stepdef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import com.testorangehrm.library.TestContext;
import com.testorangehrm.ui.EmployeeUi;

import com.testorangehrm.library.CommonUtilities;

public class EmployeeStepDef {
	public EmployeeUi employeeUi= new EmployeeUi();
	TestContext context;
	CommonUtilities commonUtilities;
	String getFirstName, getMiddleName, getLastName;
	
	public EmployeeStepDef(TestContext context) {
		this.context = context;
		commonUtilities = context.getCommonUtilities();
	}
	
	@When("Admin go to PIM menu and Add employee name")
	public void admin_go_to_pim_menu_and_add_employee_name() {
		commonUtilities.click(employeeUi.menu_pim);
		commonUtilities.click(employeeUi.btn_add_employee);
	}

	@When("Admin input data first name {string} and middle name {string} and last name {string}")
	public void admin_input_data_first_name_and_middle_name_and_last_name(String firstName, String middleName, String lastName) throws InterruptedException {
		//get data first name, middle name and last name for searching data
		getFirstName = firstName;
		getMiddleName = middleName;
		getLastName = lastName;
		commonUtilities.sendKeys(employeeUi.input_employee_firstname, firstName);
		commonUtilities.sendKeys(employeeUi.input_employee_middlename, middleName);
		commonUtilities.sendKeys(employeeUi.input_employee_lastname, lastName);
		commonUtilities.click(employeeUi.btn_employee_save);
		commonUtilities.threadSleepMedium();
	}

	@Then("new employee has been created and appear in employee list")
	public void new_employee_has_been_created_and_appear_in_employee_list() throws InterruptedException {
		String fullName = getFirstName + " " + getMiddleName;
		commonUtilities.click(employeeUi.tab_employee_list);
		commonUtilities.sendKeys(employeeUi.input_search_employee_name, fullName);
		commonUtilities.click(employeeUi.btn_search_employee);
		commonUtilities.isVerifyText(employeeUi.table_search_result, fullName);
		commonUtilities.threadSleepShort();
	}
}
