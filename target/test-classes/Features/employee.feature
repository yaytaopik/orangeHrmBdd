@orangehrm

Feature: 
	@employee
	Scenario: 2.1 Admin add employee 
		Given Admin login using username "Admin" and password "admin123"
		And Admin successfully login
		When Admin go to PIM menu and Add employee name
		And Admin input data first name "Helena" and middle name "Rachel" and last name "Woodrow"
		Then new employee has been created and appear in employee list
#		And Scenario is completed