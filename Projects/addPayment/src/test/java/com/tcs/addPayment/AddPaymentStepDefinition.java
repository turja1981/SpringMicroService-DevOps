package com.tcs.addPayment;

import org.junit.Assert;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tcs.addPayment.bean.Payment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class AddPaymentStepDefinition extends SpringBootBaseIntegrationTest {

	private final Logger log = LoggerFactory.getLogger(AddPaymentStepDefinition.class);

	private Payment pmt = new Payment();

	@When("User submit Payment Amount = (\\d+) with other details to the Add Payment Page")
	public void user_submit_payment_amount(int paymentAmount) {

		pmt.setFirstName("Johnathan");
		pmt.setLastName("Smith");
		pmt.setPolicyNumber("12345");
		pmt.setAmount(paymentAmount);
		pmt = savePayment(pmt);

		Assert.assertNotNull(pmt);
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
