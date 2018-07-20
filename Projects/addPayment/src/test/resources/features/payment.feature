Feature: User submit payment for the Policy .
  
 Scenario: User submit payment with Valid Payment Amount and get the successful payment response.
   When User submit Payment Amount = 100 with other details to the Add Payment Page
   Then Response status should contain the message = Success
   And User receives response with HTTP status code = 200 for the payment

 Scenario: User submit payment with InValid Payment Amount and get the failure  payment response.
	 When User submit Payment Amount = 0 with other details to the Add Payment Page
	 Then Response status should contain the message = Payment Amount must be greater than Zero
	 And User receives response with HTTP status code = 200 for the payment	