package com.billing.payment.card;

import org.junit.Assert;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.billing.payment.card.bean.Payment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class CardPaymentStepDefinition extends SpringBootBaseIntegrationTest {

	private final Logger log = LoggerFactory.getLogger(CardPaymentStepDefinition.class);

	private Payment pmt ;


	@Given("^User finds the Billing details with PolicyNo = (.*)")
	public void user_finds_the_Billing_details(String policyNO) {
	
		System.out.println("policyNO :-"+policyNO);
		pmt = findBillingDetails(policyNO);
		
		Assert.assertNotNull(pmt);

	}
	

		//User enters Card Holder Name =John Smith , Card No =33333334444 , Expiration Date =08/20 , ZipCode =96713
	@When("User enters Card Holder Name =(.*) , Card No =(.*) , Expiration Date =(.*) and ZipCode =(.*)")
	public void user_submit_payment_amount(String cardHolderName , String cardNo , String expirationDate , String cardZip) {

		pmt.setCardHolderName(cardHolderName);
		pmt.setCardNo(cardNo);
		pmt.setExpirationDate(expirationDate);
		pmt.setCardZip(cardZip);
		pmt = saveCardSetUp(pmt);

	}
	
	@Then("^Response status should contain the message = (.*)")
	public void response_status_should_contain_the_messag(String msg) {
		// assertNumberOfTimes(quantity, something, true);
		Assert.assertEquals(pmt.getStatus(), msg);
	}
	@And("^User receives response with HTTP status code = (\\d+) for the payment$")
	public void user_receives_response_with_HTTP_status_code(int statusCode) {
		// assertNumberOfTimes(quantity, something, true);
		Assert.assertTrue("Check Http Response Status", getResponseStatus() == statusCode);
	}


}
