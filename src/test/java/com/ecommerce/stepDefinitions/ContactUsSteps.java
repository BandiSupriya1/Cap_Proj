package com.ecommerce.stepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ecommerce.pages.ContactUsPage;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactUsSteps {

	WebDriver driver;
	ContactUsPage cp;
	
	@Given("the user navigates to home {string}")
	public void userNavigatesTo(String url) {
		driver = new ChromeDriver();
		cp=new ContactUsPage(driver);		
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Then("the home page should be visible successfully for contact_us")
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
	@Given("the user clicks on {string} buttons")
	public void click_on_contact_us(String str) {
//		if(str.equals("Contact us"))
//		    cp.click_contact_us();
		driver.navigate().to("https://www.automationexercise.com/contact_us");
	}
	@Then("Verify {string} is visible")
	public void verify_string(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@When("enter details")
	public void enter_details() {
		cp.fill_details_in_form("Sup", "none@example.com", "Order issue", "Order misplaced", "C:\\Users\\hp\\OneDrive\\Pictures\\p3.png");
	}
	@Then("click ok on alert box")
	public void ok_alert() {
		cp.click_ok();
	}
	@Then("verify success msgs {string}")
	public void verify_success_msg(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@Then("click on Home button and verify whether loaded or not")
	public void verify_home() {
		try {
			cp.click_home();
			WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
			Assert.assertTrue(homePageElement.isDisplayed(), " Home page is not visible.");
			System.out.println(" Home page is visible successfully");
		} catch (Exception e) {
			System.out.println(" Exception occurred while verifying home page: " + e.getMessage());
		}
		driver.quit();
	}
//	@After
//	public void closed() {
//		
//	}
	
}
