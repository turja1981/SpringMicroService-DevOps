Feature: Credit/Debit Card Payment Set up for the Policy .


 Scenario: User enters Card details and get the success response.
 	 Given User finds the Billing details with PolicyNo = 123
	 When  User enters Card Holder Name =John Smith , Card No =33333334444 , Expiration Date =08/20 and ZipCode =96713
	 Then  Response status should contain the message = Card details were Successfully Updated 
	 And   User receives response with HTTP status code = 200 for the payment