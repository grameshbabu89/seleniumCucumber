package com.pages;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class LoginPage extends BasePage{
	
	protected WebDriver driver;
	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	
	}
	

	//Your details
	private By clickSignIn = By.xpath("//a[text()='Login or register']");
	private By inputUsername = By.cssSelector("#loginFrm_loginname");
	private By inputPassword = By.cssSelector("#loginFrm_password");
	private By btnSubmit = By.cssSelector("button[title='Login']");
	private By continueBtn = By.cssSelector("button[title='Continue']");
	
	private By logout = By.xpath("//a[text()='Logoff']");
	
	
	public void login(String username, String password) throws InterruptedException {
		driver.findElement(inputUsername).sendKeys(username);
		driver.findElement(inputPassword).sendKeys(password);
		driver.findElement(btnSubmit).click();
		Thread.sleep(1000);
	}
	public void clickSignIn() throws InterruptedException {
		driver.findElement(clickSignIn).click();
						
	}
	
	public void clickContinue() throws InterruptedException {
		driver.findElement(continueBtn).click();
		
	}
	
	public void logOff() throws InterruptedException {
		driver.findElement(logout).click();
						
	}
	
}
