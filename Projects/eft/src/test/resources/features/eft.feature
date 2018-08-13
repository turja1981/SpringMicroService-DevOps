Feature: EFT Payment Set up for the Policy .
  
 Scenario: User enters Bank Routing Number and get the Bank Name.
   Given User finds the Billing details with PolicyNo = 123   
   When  User enters Bank Routing Number as 123456 
   Then  Bank Name should be populated as Bank of XYZ


 Scenario: User enters Invalid Bank Routing Number and does not get the Bank Name.
   Given User finds the Billing details with PolicyNo = 123
   When  User enters Bank Routing Number as 111111 
   Then  Bank Name should be populated as Not Found

 Scenario: User enters EFT Bank details and get the success response.
 	 Given User finds the Billing details with PolicyNo = 123   
	 When  User enters Bank Holder Name=John Smith , Bank Account No=12121212 , Account Type=Saving and Bank Name= Bank of XYZ
	 Then  Response status should contain the message = EFT details were Succfessfully Updated
	 And   User receives response with HTTP status code = 200 for the payment	