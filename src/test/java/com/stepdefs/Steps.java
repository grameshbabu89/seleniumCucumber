package com.stepdefs;



import static org.junit.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import com.pages.AccountPage;
import com.pages.BasePage;
import com.pages.CheckoutPage;
import com.pages.LoginPage;
import com.pages.RegistrationPage;
import com.pages.SelectProductPage;

import cucumber.api.DataTable;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;


public class Steps {
	WebDriver driver;
	LoginPage loginPage;
	AccountPage accountPage;
	RegistrationPage registrationPage;
	SelectProductPage selectProductPage;
	CheckoutPage checkoutPage;

	@Before
	public void setupDriver() {
		ChromeOptions options = new ChromeOptions();
		//https://groups.google.com/g/chromedriver-users/c/xL5-13_qGaA?pli=1
		options.addArguments("--remote-allow-origins=*");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver(options);
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
		
	}
	
	@Given("I launch the application")
	public void i_launch_the_application() {
		driver.get("https://automationteststore.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofMillis(30000));
	}

	@When("I click signIn")
	public void i_click_signIn() throws InterruptedException {
		loginPage = new LoginPage(driver);
		loginPage.clickSignIn();
	}
	

	@When("I login with (.*) and (.*)")
	public void login_to_app(String username, String password) throws InterruptedException {
		loginPage.login(username, password);
		accountPage = new AccountPage(driver);
		accountPage.verifyMyAccountHeading();
	    
	}
	@Then("I validate the firstName is displayed in the account section")
	public void i_validate_the_firstName_is_displayed_in_the_account_section() {
		accountPage = new AccountPage(driver);
		accountPage.verifyMyAccountHeading();
		accountPage.verifyfirstNameDisplayedinAccountPage();
		
		
	}
	
	@Then("I click continue to new registration")
	public void i_click_continue_to_new_registration() throws InterruptedException {
		loginPage.clickContinue();
	}


	@When("I enter (.*), (.*), (.*), (.*) and other mandatory fields then submit")
	public void enterLoginNamePasswordAndOtherMandatoryFields(String email, String fname, String loginName, String password) throws InterruptedException {
		registrationPage = new RegistrationPage(driver);
		registrationPage.verifyRegistrationPageHeading();
		registrationPage.newCustomerRegistration(email,fname,loginName,password);
		registrationPage.verifyRegSuccessHeading();
		registrationPage.getLoginNameAndPassword();
		Thread.sleep(2000);
		registrationPage.clickContinue();
	}
	
	@When("I mouseover on the (.*) and select (.*)")
	public void mouseoverOnTheMenuAndSelectProduct(String menu, String subMenu) throws InterruptedException {
		
		
	}
	@When("I click on the (.*) and select (.*)")
	public void clickTheMenuAndSelectProduct(String menu, String subMenu) throws InterruptedException {
		selectProductPage = new SelectProductPage(driver);
		selectProductPage.selectMenu(menu);
		selectProductPage.selectSubMenu(subMenu);
	}

	@Then("I select (.*) product and add to the Cart")
	public void selectProductAndAddToCart(String productNum) throws InterruptedException {
		int proNum = Integer.parseInt(productNum.replaceAll("\\D+",""));
		selectProductPage.selectProductAndAddToCart(proNum);
	}

	@Then("I proceed to checkout")
	public void proceedToccheckout() {
		selectProductPage.clickCheckout();
	}

	@Then("I verify the products in the checkout page")
	public void verify_the_products_in_the_payment_page() throws InterruptedException {
		checkoutPage = new CheckoutPage(driver);
		checkoutPage.verifyOrderConfirmationHeading();
		checkoutPage.verifyTheItemsInTheCheckoutPage();		
	}

	@Then("I logout the application")
	public void i_logout_the_application() throws InterruptedException {
		loginPage.logOff();
	}
	
	@After
	public void tearDown() {
		driver.quit();

	}
}
