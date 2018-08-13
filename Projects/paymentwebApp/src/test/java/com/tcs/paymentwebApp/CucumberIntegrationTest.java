package com.tcs.paymentwebApp;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/qa.feature" , plugin = { "pretty",
	    "html:target/site/cucumber-pretty",
	    "json:target/cucumber.json" }, tags = { "@QATesting" })
public class CucumberIntegrationTest {

}
