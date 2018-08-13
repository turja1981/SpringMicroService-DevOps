package com.billing.payment.eft;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/eft.feature" , plugin = { "pretty",
	    "html:target/site/cucumber-pretty",
	    "json:target/cucumber.json" }, tags = { "~@ignore"})
public class CucumberIntegrationTest {

}
