package com.billing.payment.card;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/card.feature" , plugin = { "pretty",
	    "html:target/site/cucumber-pretty",
	    "json:target/cucumber.json" }, tags = { "~@ignore" })
public class CucumberIntegrationTest {

}
