package com.billing.payment;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.billing.payment.bean.Payment;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class PaymentStepDefinition extends SpringBootBaseIntegrationTest {

	private final Logger log = LoggerFactory.getLogger(PaymentStepDefinition.class);

	private Payment pmt=null ;

    
	@When("^User enters PolicyNumber as (.*)$")
	public void user_enters_PolicyNumber_as(String policyNo) {
		
		pmt = new Payment();
		
		
		pmt = findBillingDetails(policyNo);

		Assert.assertNotNull(pmt);
	}

	@Then("^Billing details populated with firstName =(.*) lastName=(.*) , city=(.*) and zip=(.*)$")
	public void billing_details_populated(String firstNBame , String lastName , String city ,String zip) {
		// assertNumberOfTimes(quantity, something, true);
		 Assert.assertEquals(pmt.getFirstName(), firstNBame);
		 Assert.assertEquals(pmt.getLastName(), lastName);
		 Assert.assertEquals(pmt.getCity(), city);
		 Assert.assertEquals(pmt.getZip(), zip);
	}

}
