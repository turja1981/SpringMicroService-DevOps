package com.tcs.showPayment;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.tcs.showPayment.bean.Payment;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class ShowPaymentStepDefinition extends SpringBootBaseIntegrationTest {

	private final Logger log = LoggerFactory.getLogger(ShowPaymentStepDefinition.class);

	private List<Payment> pmtList = null;

	@When("^User browse the Payment Summary page$")
	public void user_browse_payment_summary() {

		pmtList = getAllPayments();

		Assert.assertNotNull(pmtList);
	}

	@Then("^User finds all the successful payments$")
	public void user_finds_all_the_successful_payments() {
		// assertNumberOfTimes(quantity, something, true);
		Assert.assertTrue("Payment List size is greater than zero ", pmtList.size() > 0);
	}

}
