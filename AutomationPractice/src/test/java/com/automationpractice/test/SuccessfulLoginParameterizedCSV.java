package com.automationpractice.test;

import static org.junit.Assert.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(Parameterized.class)
public class SuccessfulLoginParameterizedCSV {

	WebDriver driver;
	private String email;
	private String password;

	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
		driver = new ChromeDriver();
	}

	@After
	public void tearDown() throws Exception {
		driver.close();
		driver.quit();
	}

	@Parameters
	public static Collection testData() throws IOException {
		return getTestData("src/test/resources/testData.csv");
	}

	public SuccessfulLoginParameterizedCSV(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public static Collection<String[]> getTestData(String fileName) throws IOException {
		List<String[]> records = new ArrayList<String[]>();
		String record;
		BufferedReader file = new BufferedReader(new FileReader(fileName));
		while ((record = file.readLine()) != null) {
			String fields[] = record.split(",");
			records.add(fields);
		}
		file.close();
		return records;
	}

	@Test
	public void test() {
		driver.get("http://automationpractice.com/index.php");
		driver.findElement(By.partialLinkText("Sign in")).click();
		WebElement emailField = driver.findElement(By.id("email"));
		emailField.sendKeys(email);
		WebElement passwordField = driver.findElement(By.id("passwd"));
		passwordField.sendKeys(password);
		driver.findElement(By.id("SubmitLogin")).click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.titleContains("account"));
		assertEquals("My account - My Store", driver.getTitle());
	}

}
