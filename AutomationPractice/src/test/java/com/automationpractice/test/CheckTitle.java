package com.automationpractice.test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CheckTitle {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
		driver = new ChromeDriver();
	}

	@Test
	public void test() {
		driver.get("http://automationpractice.com/index.php");
		Assert.assertEquals("My Store", driver.getTitle());
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

}
