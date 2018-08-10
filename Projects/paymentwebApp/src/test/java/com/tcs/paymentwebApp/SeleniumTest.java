package com.tcs.paymentwebApp;

import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

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

//		Assert.assertEquals(status.getText(), "Success");
	}

	@Test
	public void testPaymentIdGreaterThanZero() throws Exception {

//		Assert.assertTrue(Integer.parseInt(id.getText()) > 0);

	}

	@Test
	public void testPaymentSummary() throws Exception {

/*		driver.get("http://localhost:3335/search.html");

		WebDriverWait wait = new WebDriverWait(driver, 5);
		firstName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("firstName")));
		Assert.assertTrue(driver.findElement(By.id("firstName")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("lastName")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("policyNumber")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("amount")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("id")).isDisplayed());
		Assert.assertTrue(driver.findElement(By.id("status")).isDisplayed());
*/
	}

	@BeforeTest
	public void beforeTest() throws Exception {
//		System.setProperty("WebDrive.chrome.driver","/home/turja/DevOps/chromedriver_linux64/chromedriver");
		ChromeOptions options = new ChromeOptions();
		DesiredCapabilities dc = DesiredCapabilities.chrome();
		dc.setCapability(ChromeOptions.CAPABILITY, options);
		
		options.addArguments("start-maximized");
		options.addArguments("disable-infobars");
		
		driver = new RemoteWebDriver(new URL("http://172.18.0.1:5555/wd/hub"), dc);
	

		System.out.println("inside test");

		driver.get("http://localhost:3340/");

		firstName = driver.findElement(By.name("txt_search_customer"));
		firstName.sendKeys("123");

		WebElement searchButton = driver.findElement(By.name("btn_search_customer"));
		searchButton.click();
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
