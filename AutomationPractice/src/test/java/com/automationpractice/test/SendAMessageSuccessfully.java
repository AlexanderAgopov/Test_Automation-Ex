package com.automationpractice.test;

import static org.junit.Assert.assertEquals;

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

class SendAMessageSuccessfully {

	WebDriver driver;

	@BeforeEach
	void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
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
		driver.findElement(By.partialLinkText("Contact us")).click();
		Select state = new Select(driver.findElement(By.id("id_contact")));
		state.selectByIndex(2);
		driver.findElement(By.id("email")).sendKeys("x2@x2.x2");
		driver.findElement(By.id("id_order")).sendKeys("44321");
		driver.findElement(By.id("message")).sendKeys("This is only a test!");
		driver.findElement(By.id("submitMessage")).click();
	}

}
