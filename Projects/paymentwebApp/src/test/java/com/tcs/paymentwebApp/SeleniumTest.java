package com.tcs.paymentwebApp;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.junit.Ignore;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.springframework.beans.factory.annotation.Autowired;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

@Ignore
public class SeleniumTest {

	@Autowired
	private WebDriver driver;

//	private WebElement firstName;
//	private WebElement lastName;
//	private WebElement policyNumber;
//	private WebElement amount;

	@Given("^EFT section is expanded$")
	public void card_section_is_expanded() throws Exception {
		
		System.out.println("Eft section is expanded");
		setUp();
		driver.get("http://localhost:3340/");

		WebElement firstName = driver.findElement(By.name("txt_search_customer"));
		firstName.sendKeys("123");

		WebElement searchButton = driver.findElement(By.name("btn_search_customer"));
		searchButton.click();		
		
		WebElement eftElements = driver.findElement(By.id("eftElements"));
		eftElements.click();
	}
	
	@When("^User enters Bank Holder Name=(.*) , Bank Account No=(.*) , Account Type=(.*) and Bank Name=(.*)$")
	public void user_enters_Card_Holder_Name_Card_No_Expiration_Date_ZipCode(String bankHolderName, String bankAccountNo,
			String accountType, String bankName) {

		System.out.println("User enters Card Holder Name =");
		
		
		WebElement elmBankHolderName = driver.findElement(By.name("txt_bankHolderName"));
		elmBankHolderName.clear();
		elmBankHolderName.sendKeys(bankHolderName);

		WebElement elmBankAccountNo = driver.findElement(By.name("txt_bankAccountNo"));
		elmBankAccountNo.clear();
		elmBankAccountNo.sendKeys(bankAccountNo);

		WebElement elmAccountType = driver.findElement(By.name("txt_accountType"));
		elmAccountType.clear();
		elmAccountType.sendKeys(accountType);

		WebElement elmBankName = driver.findElement(By.name("txt_bankName"));
		elmBankName.clear();
		elmBankName.sendKeys(bankName);
		
		WebElement eftButton = driver.findElement(By.name("btn_sendEFTPayment"));
		eftButton.click();

	}

	@Then("^Response status should contain the message = (.*)$")
	public void response_status_should_contain_the_messag(String msg) {
		System.out.println("Response status should contain the message =");
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		WebElement elmStatus = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.name("lbl_status"));
			}
		});		
		// assertNumberOfTimes(quantity, something, true);
		String strStatus = elmStatus.getText();
		Assert.assertEquals(strStatus, msg);
		
		afterTest();
	}


	public void setUp() {
		try {
			ChromeOptions options = new ChromeOptions();
			DesiredCapabilities dc = DesiredCapabilities.chrome();
			options.addArguments("start-maximized");
			options.addArguments("disable-infobars");
			
			dc.setCapability(ChromeOptions.CAPABILITY, options);

			driver = new RemoteWebDriver(new URL("http://172.18.0.1:5555/wd/hub"), dc);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}


	public void afterTest() {
		driver.close();
	}
}
