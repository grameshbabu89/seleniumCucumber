package com.pages;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.LinkedList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectProductPage extends BasePage {
	
	protected WebDriver driver;
	public SelectProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	private By getMenusX = By.xpath("//*[@class='subnav']/ul[1]/li/a");
	//private By getSubMenus = By.cssSelector(".contentpanel ul li a img");
	private By getSubMenusX = By.xpath("//*[@class='contentpanel']//li/div/a");
	

	private By allProductsX = By.xpath("//div[@class='pricetag jumbotron']/a");
	private By menuCheckoutBtn = By.xpath("//ul[@id='main_menu_top']//li[@data-id='menu_checkout']/a");
	private By cartCheckoutBtn = By.xpath("//a[@id='cart_checkout1']");
	
	private By ATCButton = By.cssSelector(".productpagecart a");
	private By logout = By.xpath("//a[text()='Logoff']");
	
	
	static LinkedList<String> productTitleList = new LinkedList<String>(); 
	static boolean checkoutMenu = true;
	
	public void chooseProductType(String menu, String product) throws InterruptedException {
		List<WebElement> getMenusE = driver.findElements(getMenusX);
		int proC=0;
		boolean flag= true;
		for ( WebElement menuE : getMenusE) {
			 proC++;
			 String getMenuT =menuE.getText().trim();
			 if(getMenuT.equals(menu)) {
				moveToElement(menuE);
				 By productsX = By.xpath("(//*[@class='subnav']/ul[1]/li/a)["+proC+"]/../div//a");
				 List<WebElement> getProdutsEle = driver.findElements(productsX);
				 for ( WebElement prodX : getProdutsEle) {
					 String getProT =prodX.getText().trim();
					 if(getProT.equals(product)) {
						 prodX.click(); 
						flag= false;
						break;
					 }
				 }	
			}				
		}
		if(flag) {
			assertFalse("No such product exists. Please search for the right product.", flag);
		}
	}
	
	public void selectMenu(String menu) throws InterruptedException {
		int menuCount = driver.findElements(getMenusX).size();
		boolean flag = true;
		for (int i=0; i<menuCount;i++) {
			List<WebElement> menuElements = driver.findElements(getMenusX);
			String getMenuT = menuElements.get(i).getText().trim();
			if(getMenuT.equalsIgnoreCase(menu)) {
				menuElements.get(i).click();
				Thread.sleep(3000);
				flag=false;
				break;
			}		
		}
		if(flag)
			assertTrue("No such Menu exists. Please search for the right Menu.", false);
	}
	
	
	public void selectSubMenu(String subMenu) throws InterruptedException {
		int subMenuCount = driver.findElements(getSubMenusX).size();
		boolean flag = true;
		for (int i=0; i<subMenuCount;i++) {
			List<WebElement> subMenuElements = driver.findElements(getSubMenusX);
			String getSubMenuT = subMenuElements.get(i).getText().trim();
			if(getSubMenuT.equalsIgnoreCase(subMenu)) {
				subMenuElements.get(i).click();
				Thread.sleep(3000);
				flag=false;
				break;
			}		
		}
		if(flag)
			assertTrue("No such Sub-Menu exists. Please search for the right sub-menu.", false);
	}
	public void selectProductAndAddToCart(Integer proNum) throws InterruptedException {
	
		int proCount = driver.findElements(allProductsX).size();
		if (proCount < 1 )
			assertTrue("No such product exists. Please search for the right product.", false);
		else if(proCount < proNum)
			assertTrue("The cart has only "+ proCount+" items, but you trying to select "+proNum+" st/nd/th - Product", false);
		else {
			String proTitle = getProDescription(proNum);
			productTitleList.add(proTitle);
			List<WebElement> allProducts = driver.findElements(allProductsX);
			//add to cart
			allProducts.get(proNum-1).click();
			Thread.sleep(1000);
			int isATCExist = driver.findElements(ATCButton).size();
			if(isATCExist>0) {
				driver.findElement(ATCButton).click();
				checkoutMenu=false;
				Thread.sleep(1000);
			}		
		}	    
	}
	public String getProDescription(int proNum) throws InterruptedException {
		
		WebElement ele = driver.findElement(By.xpath("(//div[@class='pricetag jumbotron']/a)["+proNum+"]/../../preceding-sibling::div[1]//a"));
		 String getT =ele.getText();
		 return getT;
		
	}
	public void clickCheckout() {
		if(checkoutMenu) {
			driver.findElement(menuCheckoutBtn).click();
		}else {
			driver.findElement(cartCheckoutBtn).click();
		}
		
		
	}
	 
	

	
	
}
