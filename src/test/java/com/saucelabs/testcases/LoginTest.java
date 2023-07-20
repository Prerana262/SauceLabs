package com.saucelabs.testcases;

import java.io.IOException;

import org.openqa.selenium.By;

import com.saucelabs.driverMgmt.BaseTest;

public class LoginTest extends BaseTest {
	By username = By.id("user-name");
	By Password = By.id("password");
	By loginbutton = By.id("login-button");
	By HomePageHeader = By.xpath("//div[text()='Swag Labs']");

	public void testlogin() throws IOException, InterruptedException {
		setupDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(username).sendKeys("standard_user");
		driver.findElement(Password).sendKeys("secret_sauce");
		capture();
		driver.findElement(loginbutton).click();
		// Add a check to verify if the homepage header is displayed to consider the
		// test case as passed.
		boolean isHomePageDisplayed = driver.findElement(HomePageHeader).isDisplayed();

		if (isHomePageDisplayed) {
			System.out.println("LoginTest: Test case passed successfully.");
		} else {
			System.out.println("LoginTest: Test case failed.");
		}
		capture();
		// You should always call tearDown() regardless of the test status.
		tearDown();
	}

	public static void main(String[] args) throws IOException {
		LoginTest loginTest = new LoginTest();
		try {
			loginTest.testlogin();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
