package com.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage extends BasePage {
	
	protected WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	
	private By itemsDescriptions = By.xpath("//a[@class='checkout_heading']");
	public static LinkedList<String> descriptionsList = new LinkedList<String>(); 
	
	

	public void verifyTheItemsInTheCheckoutPage() throws InterruptedException {
		
		List<WebElement> descriptionsEle = driver.findElements(itemsDescriptions);
		for(WebElement itemDes: descriptionsEle) {
			descriptionsList.add(itemDes.getText().toUpperCase());
		}	
		LinkedList<String> itemsAdded = SelectProductPage.productTitleList;
		boolean containsAll = descriptionsList.containsAll(itemsAdded);
		if(containsAll) {
			System.out.println("All the items are displayed on the checkout page, and you can proceed with payment.");
			System.out.println("Item list from Cart: "+itemsAdded);
			System.out.println("Item list from Checkout: "+ descriptionsList);
		}else {
			System.err.println("Item list from Cart: "+itemsAdded);
			System.err.println("Item list from Checkout: "+ descriptionsList);
			assertTrue("Items added to the cart are missing from the checkout page.", false);
		}
	}

	public void verifyOrderConfirmationHeading() {
		String act = getPageHeading();
		String exp = "CHECKOUT CONFIRMATION";
		assertEquals("Your shopping cart is empty!", exp, act);
		
	}	
}
