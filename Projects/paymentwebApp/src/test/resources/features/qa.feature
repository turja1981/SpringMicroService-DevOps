@QATesting
Feature: Find Billing Details from the  Policty No in Account Set up Screen .

 
 Scenario: User enters EFT Bank details and get the success response.
 	 Given EFT section is expanded
	 When  User enters Bank Holder Name=John Smith , Bank Account No=12121212 , Account Type=Savings and Bank Routing Number=123456
	 Then  Response status should contain the message = EFT details were Successfully Updated
	 