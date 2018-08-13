package com.billing.payment.eft;

import org.junit.Assert;
import org.junit.Ignore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.billing.payment.eft.bean.Payment;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class EFTPaymentStepDefinition extends SpringBootBaseIntegrationTest {

	private final Logger log = LoggerFactory.getLogger(EFTPaymentStepDefinition.class);

	private Payment pmt ;


	@Given("^User finds the Billing details with PolicyNo = (.*)")
	public void user_finds_the_Billing_details(String policyNO) {
	
		System.out.println("policyNO :-"+policyNO);
		pmt = findBillingDetails(policyNO);
		
		Assert.assertNotNull(pmt);

	}
	
	@When("^User enters Bank Routing Number as (.*)")
	public void user_enters_Bank_Routing_Number(String bankRoutingNo) {

		System.out.println("bankRoutingNo :-"+bankRoutingNo);
		
		pmt.setBankRoutingNo(bankRoutingNo);
		String bankName  =  getBankDetails(bankRoutingNo).getBankName();
		System.out.println(bankName);
		pmt.setBankName(bankName);

	}
	
	@Then("^Bank Name should be populated as (.*)")
	public void bank_Name_should_populated_as(String bankName) {
		
		System.out.println("bankName :-"+bankName);

		Assert.assertEquals(pmt.getBankName(), bankName);
	}
	
	@When("User enters Bank Holder Name=(.*) , Bank Account No=(.*) , Account Type=(.*) and Bank Name=(.*)")
	public void user_submit_payment_amount(String bankHolderName , String bankAcctNo , String bankAcctType , String bankName) {

		pmt.setBankHolderName(bankHolderName);
		pmt.setBankName(bankName);
		pmt.setBankAccountNo(bankAcctNo);
		pmt.setAccountType(bankAcctType);
		pmt = saveEFTSetUp(pmt);

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
