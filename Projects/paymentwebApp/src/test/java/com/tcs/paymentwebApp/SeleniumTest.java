package com.tcs.paymentwebApp;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumTest {

	@Autowired
	private WebDriver driver;

	private WebElement id;

	private WebElement status;
	private WebElement firstName;
	private WebElement lastName;
	private WebElement policyNumber;
	private WebElement amount;

	@Test
	public void testPaymentStatusEqualToSuccess() throws Exception {

		Assert.assertEquals(status.getText(), "Success");
	}

	@Test
	public void testPaymentIdGreaterThanZero() throws Exception {

		Assert.assertTrue(Integer.parseInt(id.getText()) > 0);

	}

	@Test
	public void testPaymentSummary() throws Exception {

		driver.get("http://localhost:3335/search.html");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		Assert.assertTrue(driver.findElement(By.id("firstName")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("lastName")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("policyNumber")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("amount")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("id")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("status")).isDisplayed());

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		driver = new RemoteWebDriver(new URL("http://localhost:5556/wd/hub"), dc);

		System.out.println("inside test");

		driver.get("http://localhost:3335/");

		firstName = driver.findElement(By.name("firstName"));
		firstName.sendKeys("John");
		lastName = driver.findElement(By.name("lastName"));
		lastName.sendKeys("Smith");
		policyNumber = driver.findElement(By.name("policyNumber"));
		policyNumber.sendKeys("1234567");
		amount = driver.findElement(By.name("amount"));
		amount.sendKeys("2709.31");

		WebElement saveButton = driver.findElement(By.name("save"));
		saveButton.click();
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(15, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);

		status = wait.until(new Function<WebDriver, WebElement>() {

			public WebElement apply(WebDriver driver) {
				// TODO Auto-generated method stub
				return driver.findElement(By.id("status"));
			}
		});

		id = driver.findElement(By.id("id"));
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
}
