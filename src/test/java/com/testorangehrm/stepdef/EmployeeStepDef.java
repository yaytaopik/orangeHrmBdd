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
	String getFirstName, getMiddleName, getLastName, changedFirstName;
	String randomNumber;
	
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
		randomNumber = commonUtilities.generateRandomNumber();
		commonUtilities.sendKeys(employeeUi.input_employee_firstname, firstName);
		commonUtilities.sendKeys(employeeUi.input_employee_middlename, middleName);
		commonUtilities.sendKeys(employeeUi.input_employee_lastname, lastName);
		commonUtilities.generateRandomNumber();
		commonUtilities.clearField(employeeUi.input_employee_id);
		commonUtilities.sendKeys(employeeUi.input_employee_id, randomNumber);
		commonUtilities.click(employeeUi.btn_employee_save);
		commonUtilities.threadSleepMedium();
	}

	@Then("new employee has been created and appear in employee list")
	public void new_employee_has_been_created_and_appear_in_employee_list() throws InterruptedException {
		String fullName = getFirstName + " " + getMiddleName;
		System.out.println("Fullname" + fullName);
		commonUtilities.click(employeeUi.tab_employee_list);
		search_data_employee(fullName);
		commonUtilities.threadSleepLong();
		commonUtilities.isVerifyText(employeeUi.table_search_result, fullName);
		commonUtilities.threadSleepShort();
	}
	
	@When("admin search data employee first name {string} and middle name {string}")
	public void admin_search_data_employee_first_name_and_middle_name(String firstName, String middleName) throws InterruptedException {
		String srcName = firstName + " " + middleName;
		getMiddleName = middleName;
		commonUtilities.waitLong();
		commonUtilities.click(employeeUi.menu_pim);
		commonUtilities.click(employeeUi.tab_employee_list);
		search_data_employee(srcName);
		commonUtilities.threadSleepShort();
		commonUtilities.isVerifyText(employeeUi.table_search_result, srcName);
		commonUtilities.threadSleepShort();
		commonUtilities.click(employeeUi.btn_edit_employee);
	}

	@When("Admin change first name of employee to {string}")
	public void admin_change_first_name_of_employee_to(String firstName) throws InterruptedException {
	   changedFirstName = firstName;
	   commonUtilities.threadSleepMedium();
//	   commonUtilities.clearField(employeeUi.input_edit_firstName_employee);
	   commonUtilities.clearValue(employeeUi.input_edit_firstName_employee);
	   commonUtilities.threadSleepShort();
	   commonUtilities.sendKeys(employeeUi.input_edit_firstName_employee, firstName);
	   commonUtilities.click(employeeUi.btn_save_edited_employee);
	   commonUtilities.threadSleepMedium();
	}

	@Then("Updated first name of employee has been changed")
	public void updated_first_name_of_employee_has_been_changed() throws InterruptedException {
	    String editedName = changedFirstName + " " + getMiddleName;
	    commonUtilities.click(employeeUi.tab_employee_list);
		search_data_employee(editedName);
		commonUtilities.threadSleepLong();
		commonUtilities.isVerifyText(employeeUi.table_search_result, editedName);
		commonUtilities.threadSleepShort();
	}

	
	//methods
	
	public void search_data_employee(String employeeName) {
		commonUtilities.sendKeys(employeeUi.input_search_employee_name, employeeName);
		commonUtilities.click(employeeUi.btn_search_employee);
	}
}
