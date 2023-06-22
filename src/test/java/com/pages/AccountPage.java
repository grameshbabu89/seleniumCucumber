package com.pages;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class AccountPage extends BasePage {

	protected WebDriver driver;

	public AccountPage(WebDriver driver) {
		super(driver);
		this.driver = driver;

	}

	private By LogInUser = By.cssSelector(".heading1 span:nth-child(2)");

	public String getLoggedInUser() {
		return driver.findElement(LogInUser).getText();

	}
	public void verifyMyAccountHeading() {
		String act = getPageHeading();
		String exp = "MY ACCOUNT";
		assertEquals("You are not In My account page", exp, act);
		
	}
	public void verifyfirstNameDisplayedinAccountPage() {
		String actualFName = driver.findElement(LogInUser).getText();
		String expectedFName =RegistrationPage.firstName;
		assertEquals("The first name is mismatched with the logged-in user in the account section.", expectedFName, actualFName);

	}
}
