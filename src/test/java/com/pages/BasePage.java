package com.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
	
	protected WebDriver driver;
	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	private By pageHeading = By.cssSelector(".heading1 span");
	
	public void selectByIndex(By locator, int index) {
		
		WebElement dp = driver.findElement(locator);
		Select option = new Select(dp);
		option.selectByIndex(index);	
	}
	public void selectByVisibleText(By locator, String text) {
		
		WebElement dp = driver.findElement(locator);
		Select option = new Select(dp);
		option.selectByVisibleText(text);	
	}
	
	public String getPageHeading() {
		WebElement dp = driver.findElement(pageHeading);
		return dp.getText();
		
	}
	
	public void enterText(By locator,String text) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(text);
	}
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	public void moveToElement(WebElement element) throws InterruptedException {
		Actions actions = new Actions(driver); 
		actions.moveToElement(element);
		actions.build().perform();
		Thread.sleep(1000);

	}
}
