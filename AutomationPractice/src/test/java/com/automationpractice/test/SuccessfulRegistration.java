package com.automationpractice.test;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

class SuccessfulRegistration {

	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
	}

	@AfterEach
	void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Test
	void test() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.partialLinkText("Sign in")).click();
		WebElement emailField = driver.findElement(By.id("email_create"));
		emailField.sendKeys("x2@x2.x2");
		driver.findElement(By.id("SubmitCreate")).click();
		WebElement firstNameField = driver.findElement(By.id("customer_firstname"));
		firstNameField.sendKeys("x");
		WebElement lastNameField = driver.findElement(By.id("customer_lastname"));
		lastNameField.sendKeys("x");
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys("xxxxx");
		WebElement addressField = driver.findElement(By.id("address1"));
		addressField.sendKeys("8 Swanson St.  Brookfield, WI 53045");
		WebElement cityField = driver.findElement(By.id("city"));
		cityField.sendKeys("X");
		WebElement postalCodeField = driver.findElement(By.id("postcode"));
		postalCodeField.sendKeys("11111");
		WebElement mobilePhoneField = driver.findElement(By.id("phone_mobile"));
		mobilePhoneField.sendKeys("+1543543543");
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByIndex(4);
		driver.findElement(By.id("submitAccount")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("account"));
		assertEquals("My account - My Store", driver.getTitle());
	}

}