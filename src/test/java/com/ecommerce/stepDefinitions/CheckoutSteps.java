package com.ecommerce.stepDefinitions;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.CheckoutPage;
import com.ecommerce.pages.LoginPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutSteps {

	
	ChromeDriver driver;
	CheckoutPage c;
	@Given("the user navigates to home for checkout {string}")
	public void forCheckout_userNavigatesTo(String url) {
		driver = new ChromeDriver();
		c=new CheckoutPage(driver);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Then("the home page should visible successfully for checkout")
	public void for_checkouthomePageShouldBeVisibleSuccessfully() {
		try {
			WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));

			Assert.assertTrue(homePageElement.isDisplayed(), 
					" Home page is not visible.");
			System.out.println(" Home page is visible successfully");

		} catch (Exception e) {
			System.out.println(" Exception occurred while verifying home page: " + e.getMessage());
		}
	}
	@When("click on signuplogin button for checkout")
	public void click_signup_button() {
		c.clickSignup();
	}
	@When("the user adds products to cart for checkout")
	public void for_checkout_add_product_() {
		c.addProductsToCart();
	}@When("the user clicks on Cart button for checkout")
	public void click_on_cart_for_checkout() {
		c.clickCartButton();
		driver.navigate().refresh();
	}
	@Then("the user verifies that cart page is displayed for checkout")
	public void for_checkout_check_cart_page_() {
		if(!c.isCartPageVisible())
			 System.out.println("Two products added to cart successfully...");
		 else
			 System.out.println("Products did not added to cart successfully!!");
	 
	}
	@When("the user clicks on Proceed To Checkout button")
	public void proceed_to_checkout() {
		c.clickProceedToCheckout();
	}
	@When("the user clicks on Register Login button for checkout")
	public void click_on_register() {
		c.clickRegisterLogin();
	}
	@Then("user should see signup {string} for checkout")
	public void for_checkout_sign_up_msg_(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	
	@When("the user enters name as {string} and email as {string} for checkout")
	public void forCheckoutuserEntersNameAndEmail(String name, String email) throws InterruptedException {
		c.signupPage_(name, email);
		Thread.sleep(3000);
	}
	@Then("the user should see the {string} for checkout")
	public void ForCheckoutCheckMsg(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@When("the user fills the details for signup for checkout")
	public void fill_inform_for_checkout() throws InterruptedException {

		c.fillInfo_("Supri", "B", "sup@123", "6", "May", "2002", "main road", "India", "kmm", "tg", "507302", "1236547890");
		Thread.sleep(5000);
	}

	@Then("the user should see the message {string} for checkout")
	public void forCheckoutmsg(String message) throws InterruptedException {
		if (driver.getPageSource().contains(message)) {
			System.out.println("Message found: " + message);
		} else {
			System.out.println(" Expected message not found: " + message);
		}
		Thread.sleep(5000);
	}
	@Then("click on continue button for checkout")
	public void for_checkout_click_continue_() {

		c.click_on_conti_();
	}
	@Then("the user should see the message username {string} for checkout")
	public void ForCheckoutMessage(String expectedMessage) {
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
	@When("Verify Address Details and Review Your Order")
	public void for_checkoutverify_details() {
		c.verifyOrderSummary_();
	}
	@When("Enter description in comment text area and click Place Order")
	public void add_desc() {
		c.add_desc();
	}@When("Click Pay and Confirm Order button")
	public void pay_button() {
		c.clickPayAndConfirmOrder();
	}
	
	@Then("delete the account for checkout")
	public void delete_account_for_checkoutt() {
		c.delete_();
	}
	@Then("click on continue button after deleting the account for checkout")
	public void for_checkout_continue_delete_() {
		c.click_on_conti_();
	}
	@Then("the user should see the message deleted {string} for checkout")
	public void userShouldSeeMessageDeleted_forcheckout(String message) throws InterruptedException {
		if (driver.getPageSource().contains(message)) {
			System.out.println("Message found: " + message);
		} else {
			System.out.println(" Expected message not found: " + message);
		}
		Thread.sleep(5000);
}
	@When("the user enters email as {string} and password as {string} for checkout")
	public void login(String m,String p) {
		c.login(m,p);
	}
	//verifying billing adrress
	@When("Verify that the billing address is same address filled at the time registration of account")
	public void verify_billing_addr() {
		String expectedAddress = "YOUR BILLING ADDRESS\r\n"
				+ ". Supri B\r\n"
				+ "main road\r\n"
				+ "kmm tg 507302\r\n"
				+ "India\r\n"
				+ "1236547890";
		expectedAddress = expectedAddress.replaceAll("[\r\n]+", " ").trim();

        WebElement billingAddressElement = driver.findElement(By.id("address_invoice"));
        String deliveryAddress = billingAddressElement.getText().replaceAll("\\s+", " ").trim();

        Assert.assertEquals(deliveryAddress, expectedAddress, " Billing address does not match signup details.");
	}
	@When("Verify that the delivery address is same address filled at the time registration of account")
	public void verify_delivery_addr() {
		String expectedAddress = "YOUR DELIVERY ADDRESS\r\n"
				+ ". Supri B\r\n"
				+ "main road\r\n"
				+ "kmm tg 507302\r\n"
				+ "India\r\n"
				+ "1236547890";
		expectedAddress = expectedAddress.replaceAll("[\r\n]+", " ").trim();

        WebElement deliveryAddressElement = driver.findElement(By.id("address_delivery"));
        String deliveryAddress = deliveryAddressElement.getText().replaceAll("\\s+", " ").trim();

        Assert.assertEquals(deliveryAddress, expectedAddress, " Delivery address does not match signup details.");
	}
	@When("Click Download Invoice button and verify invoice is downloaded successfully.")
	public void invoice_download() {
		c.invoice();
		String downloadPath = System.getProperty("user.home") + "\\Downloads\\invoice.pdf";

        // Check if the file exists
        File file = new File(downloadPath);

        if (file.exists()) {
            System.out.println("Invoice downloaded successfully!");
            // Optional: Delete the file after checking
            file.delete();
        } else {
            Assert.fail(" Invoice was not downloaded.");
        }

	}
}
