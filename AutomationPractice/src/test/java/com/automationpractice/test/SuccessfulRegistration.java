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
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
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
		driver.findElement(By.id("email_create")).sendKeys("wfa33dd@ax3a.xax");
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.findElement(By.id("SubmitCreate")).click();
		driver.findElement(By.id("customer_firstname")).sendKeys("x");
		driver.findElement(By.id("customer_lastname")).sendKeys("x");
		driver.findElement(By.id("passwd")).sendKeys("xxxxx");
		driver.findElement(By.id("address1")).sendKeys("8 Swanson St.  Brookfield, WI 53045");
		driver.findElement(By.id("city")).sendKeys("X");
		driver.findElement(By.id("postcode")).sendKeys("11111");
		driver.findElement(By.id("phone_mobile")).sendKeys("+1543543543");
		Select state = new Select(driver.findElement(By.id("id_state")));
		state.selectByIndex(4);
		driver.findElement(By.id("submitAccount")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("account"));
		assertEquals("My account - My Store", driver.getTitle());
	}

}