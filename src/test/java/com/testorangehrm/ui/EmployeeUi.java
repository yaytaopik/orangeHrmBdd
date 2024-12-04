package com.testorangehrm.ui;
import org.openqa.selenium.By;

public class EmployeeUi {
	//menu pim
	public By menu_pim = By.xpath("//span[normalize-space()='PIM']");
	//add new employee
	public By btn_add_employee = By.xpath("//button[normalize-space()='Add']");
	public By input_employee_firstname = By.xpath("//input[@placeholder='First Name']");
	public By input_employee_middlename = By.xpath("//input[@placeholder='Middle Name']");
	public By input_employee_lastname = By.xpath("//input[@placeholder='Last Name']");
	public By input_employee_id = By.xpath("//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@class='oxd-input oxd-input--active']");
	public By btn_employee_save = By.xpath("//button[normalize-space()='Save']");
	public By tab_employee_list = By.xpath("//a[normalize-space()='Employee List']");
	public By input_search_employee_name = By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/div[2]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/input[1]");
	public By btn_search_employee = By.xpath("//button[normalize-space()='Search']");
	public By table_search_result = By.xpath("/html/body/div[1]/div[1]/div[2]/div[2]/div/div[2]/div[3]/div/div[2]/div/div/div[3]/div");
	//edit
	public By btn_edit_employee = By.xpath("//div[@class='orangehrm-container']//button[1]");
	public By input_edit_firstName_employee = By.xpath("//input[@placeholder='First Name']");
	public By btn_save_edited_employee = By.xpath("//div[@class='orangehrm-horizontal-padding orangehrm-vertical-padding']//button[@type='submit'][normalize-space()='Save']");
}
