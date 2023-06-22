package com.pages;

import static org.junit.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegistrationPage extends BasePage {
	
	protected WebDriver driver;
	public RegistrationPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	
	static String firstName;
	static String loginName;
	
	private By enterFirstName = By.cssSelector("#AccountFrm_firstname");
	private By enterLastName = By.cssSelector("#AccountFrm_lastname");
	private By enterEmail = By.cssSelector("#AccountFrm_email");
	private By enterAddress = By.cssSelector("#AccountFrm_address_1");
	private By enterCity = By.cssSelector("#AccountFrm_city");
	
	private By selectState = By.cssSelector("#AccountFrm_zone_id");
	private By enterPostcode = By.cssSelector("#AccountFrm_postcode");
	private By selectCountry = By.cssSelector("#AccountFrm_country_id");
	private By enterLoginName = By.cssSelector("#AccountFrm_loginname");
	private By enterPassword = By.cssSelector("#AccountFrm_password");
	
	private By enterConfPassword = By.cssSelector("#AccountFrm_confirm");
	private By subscribeYes = By.cssSelector("#AccountFrm_newsletter1");
	private By subscribeNo = By.cssSelector("#AccountFrm_newsletter0");
	private By selectTermsCondition = By.cssSelector("#AccountFrm_agree");
	private By clickRegister = By.cssSelector("#submitAccount");
	private By regError = By.cssSelector("[data-dismiss='alert']");
	private By continueBtn = By.cssSelector("button[title='Continue']");
	private By continueToAccount = By.cssSelector("a[title='Continue']");
	
	
	public void verifyRegistrationPageHeading() {
		String act = getPageHeading();
		String exp = "CREATE ACCOUNT";
		assertEquals("Registration page was NOT displayed", exp, act);
		
	}
	public void verifyRegSuccessHeading() {
		String act = getPageHeading();
		String exp = "YOUR ACCOUNT HAS BEEN CREATED!";
		assertEquals("Registration was NOT successful", exp, act);
		
	}
   
    public void newCustomerRegistration(String email, String fname, String lgnName, String password) throws InterruptedException {
       int random =generate3DigitRandomNumber();
       
       firstName = fname+random;
       loginName = lgnName+random;
       
    	enterText(enterFirstName,firstName);
    	enterText(enterLastName,"LN");
    	enterText(enterEmail,email+random+"@test.com");
    	enterText(enterAddress,"Laporte Avenue, Gandhinagar");
    	enterText(enterCity,"Chennai");
    	enterText(enterPostcode,"70054");
    	selectByVisibleText(selectCountry,"India");
    	Thread.sleep(2000);
    	selectByVisibleText(selectState,"Tamil Nadu");
    	Thread.sleep(2000);
    	enterText(enterLoginName,loginName);
    	enterText(enterPassword,password);
    	enterText(enterConfPassword,password);
    	click(subscribeNo);
    	click(selectTermsCondition);
    	click(continueBtn);
    	Thread.sleep(2000);
    	     
    }	
	public void clickContinue() throws InterruptedException {
		driver.findElement(continueToAccount).click();				
	}	
	public int generate3DigitRandomNumber() throws InterruptedException {
		 //return (int) (Math.random()*1000);	
		return (int)(Math.random()*(999-101)+100);  
	}	
	public void getLoginNameAndPassword() {
		System.out.println("First Name: "+firstName);
		System.out.println("Login Name: "+loginName);	
					
	}
	
}
