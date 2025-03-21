package com.ecommerce.stepDefinitions;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.*;
import io.cucumber.messages.types.Duration;
import java.util.Map;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.ecommerce.pages.LoginPage;

public class LoginSteps {

	ChromeDriver driver;
	LoginPage lp;
	@Given("the user navigates to {string}")
	public void userNavigatesTo(String url) {
		driver = new ChromeDriver();
		lp=new LoginPage(driver);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Then("the home page should be visible successfully")
	public void homePageShouldBeVisibleSuccessfully() {
		try {
			WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));

			Assert.assertTrue(homePageElement.isDisplayed(), 
					" Home page is not visible.");
			System.out.println(" Home page is visible successfully");

		} catch (Exception e) {
			System.out.println(" Exception occurred while verifying home page: " + e.getMessage());
		}
	}
	@Then("user should see signup {string}")
	public void sign_up_msg(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@Given("the user clicks on {string} button")
	public void the_user_clicks_on_button(String button) {
		if (button.equals("Signup / Login")) {
			lp.clickLogin_SignupButton();
		} else if (button.equals("Login")) {
			lp.login_button();
		}
	}
	@When("the user enters name as {string} and email as {string} in the signup form")
	public void userEntersNameAndEmail(String name, String email) throws InterruptedException {
		lp.signupPage(name, email);
		Thread.sleep(3000);
	}
	@Then("the user should see the {string}")
	public void checkmsg(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@When("the user fills the details for signup:")
	public void the_user_fills_the_details_for_signup() throws InterruptedException {

		lp.fillInfo("Supri", "B", "sup@123", "6", "May", "2002", "main road", "India", "kmm", "tg", "507302", "1236547890");
		Thread.sleep(5000);
	}

	@Then("the user should see the message {string}")
	public void userShouldSeeMessage(String message) throws InterruptedException {
		if (driver.getPageSource().contains(message)) {
			System.out.println("Message found: " + message);
		} else {
			System.out.println(" Expected message not found: " + message);
		}
		Thread.sleep(5000);
	}
	@Then("click on continue button")
	public void click_on_continue() {

		lp.click_on_conti();
	}
	@Then("the user should see the message username {string}")
	public void userShouldSeeMessageUsername(String expectedMessage) {
		try {
			WebElement messageElement = driver.findElement(By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[10]/a"));
			String actualMessage = messageElement.getText().trim();
			System.out.println("Actual Message: " + actualMessage);
			Assert.assertTrue(actualMessage.equalsIgnoreCase(expectedMessage),
					" Expected message not displayed. Found: " + actualMessage);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
	}
	@Then("delete the account")
	public void delete_the_account() {

		lp.delete();
	}
	@Then("click on continue button after deleting the account")
	public void continue_after_delete() {
		lp.click_on_conti();
	}
	@Then("the user should see the message deleted {string}")
	public void userShouldSeeMessageDeleted(String message) throws InterruptedException {
		if (driver.getPageSource().contains(message)) {
			System.out.println("Message found: " + message);
		} else {
			System.out.println(" Expected message not found: " + message);
		}
		Thread.sleep(5000);
		//driver.close();
	}
	
	//@ValidLogin
	@Then("user should see this {string}")
	public void login_msg(String s) throws InterruptedException {
		if (driver.getPageSource().contains(s)) {
			System.out.println("Message found: " + s);
		} else {
			System.out.println(" Expected message not found: " + s);
		}
		Thread.sleep(5000);
	}	
	@When("the user enters email as {string} and password as {string} in the signin form")
	public void fill_login(String mail,String pass) {
		lp.fill_login_details(mail, pass);
	}
	@Then("click on login button")
	public void login() {
		lp.login_button();
	}
	/*@Then("the user should see the message username2 {string}")
	public void see_message(String m) throws InterruptedException {
		try {
			WebElement messageElement = driver.findElement(By.xpath("//*[contains(text(),'Logged in as')]"));
			String actualMessage = messageElement.getText().trim();
			System.out.println("Actual Message: " + actualMessage);
			Assert.assertTrue(actualMessage.equalsIgnoreCase(m),
					" Expected message not displayed. Found: " + actualMessage);
		} catch (Exception e) {
			System.out.println("Exception occurred: " + e.getMessage());
		}
		Thread.sleep(5000);
	
	}*/
	
	//@Invalid Login Functionality
	
	@Then("Verify error {string} is visible")
	public void verify_credentials(String s) throws InterruptedException {
		if (driver.getPageSource().contains(s)) {
			System.out.println("Message found: " + s);
		} else {
			System.out.println(" Expected message not found: " + s);
		}
		Thread.sleep(5000);
		//driver.close();
	}
	
	//@Logout functionality
	
	@Then("click on logout button")
	public void logging_out() {
		lp.logout_user();
	}
	@Then("verify user navigated to login page {string}")
	public void verify_login_page(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
		//driver.close();
	}
	
//	@After
//	public void tearDown() throws InterruptedException {
//		Thread.sleep(3000);
//		driver.quit();
//	}
}
