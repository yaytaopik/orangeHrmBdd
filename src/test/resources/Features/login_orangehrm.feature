@orangehrm @login

Feature: 1. Login orange hrm

	Scenario: 1.1 Admin login into orange hrm with valid credentials
		Given Admin login using username "Admin" and password "admin123"
		And Admin successfully login
		Then Scenario is completed
		
		Scenario: 1.2 Admin login into orange hrm with invalid username credentials
		Given Admin login using username "Admiral" and password "admin123"
		And Alert message username required should displayed
		Then Scenario is completed
		
		Scenario: 1.3 Admin login into orange hrm with invalid password credentials
		Given Admin login using username "Admin" and password "admin12345"
		And Alert message username required should displayed
		Then Scenario is completed
		
		