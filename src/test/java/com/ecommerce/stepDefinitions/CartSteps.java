package com.ecommerce.stepDefinitions;

import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.ecommerce.pages.CartPage;
import com.ecommerce.pages.FunctionsPage;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartSteps{

	CartPage cp;
	ChromeDriver driver;
	@Given("the user navigates to home for cart {string}")
	public void userNavigatesTo(String url) {
		driver = new ChromeDriver();
		cp=new CartPage(driver);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Then("the home page should visible successfully for cart")
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
	@When("the user clicks on cart page")
	 public void click_cart_page() {
		 cp.cart();
		// driver.navigate().refresh();
	 }
	@When("the user scrolls down to the footer in cart")
    public void user_scrolls_down_to_footer() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }
	@Then("the text {string} should be visible in cart")
    public void the_text_should_be_visible(String expectedText) throws InterruptedException {
	 if (driver.getPageSource().contains(expectedText)) {
			System.out.println("Message found: " + expectedText);
		} else {
			System.out.println(" Expected message not found: " + expectedText);
		}
		Thread.sleep(5000);
    }
	@When("the user enters {string} in the subscription input and clicks the subscription arrow button in cart")
	 public void enter_email_in_sub_box(String mail) {
		 cp.fill_mail(mail);
	 }
	 @Then("the success message {string} should be visible in cart")
	 public void success_msg(String msg) throws InterruptedException {
		 if (driver.getPageSource().contains(msg)) {
				System.out.println("Message found: " + msg);
			} else {
				System.out.println(" Expected message not found: " + msg);
			}
			Thread.sleep(5000);
			//driver.quit();
	 }
	 
	 //Adding product to cart
	 @When("the user clicks on product page")
	 public void click_prod_page() {
		 cp.click_prod();
	 }
	 @When("the user adds first product to cart")
	 public void add_prod1_to_cart() {
		 cp.addFirstProductToCart();
	 }
	 @When("the user continues shopping")
	 public void con() {
		 cp.click_continue();
	 }
	 @When("the user adds second product to cart")
	 public void add_prod2_to_cart() {
		 cp.addSecondProductToCart();
	 }
	 @Then("both products should be added to the cart")
	 public void verify_cart() {
		 if(!cp.verify_cart())
			 System.out.println("Two products added to cart successfully...");
		 else
			 System.out.println("Products did not added to cart successfully!!");
	 }
	 @When("verify their prices, quantity, and total price")
	 public void check_prod() {
		 if(cp.check_cart_details()) {
			 System.out.println("Products details in cart displayed");
		 }
		 else {
			 System.out.println("Products details in cart not displayed");
		 }
		// driver.quit();
	 }
	 
	 //Verify Product quantity in Cart
	 @When("the user opens the product details of first product")
	 public void cick_on_view_product() {
		 cp.view_product();
	 }
	 @Then("product details should be displayed")
	 public void view_prod_details() {
		 cp.view_product_details();
	 }
	 @When("the user increases quantity to {string}")
	 public void increase_quantity(String s) {
		 cp.increase_quant(s);
	 }
	 @When("the user clicks on add to cart  button")
	 public void add_to_cart() {
		 cp.add_to_cart();
	 }
	 @Then("the product should be displayed in the cart with exact quantity {string}")
	 public void check_correct_quant(String s) {
		 if(cp.check_corr_quant(s))
			 System.out.println("Correct quantity selected");
		 else
			 System.out.println("Error in selecting quantity");
	//driver.quit();
	 }
	 
	 //remove prof from cart
	 @Then("Click x button corresponding to particular product")
	 public void remove_prod_from_cart() {
		 cp.remove_from_cart();
	 }
	 @Then("Verify that product is removed from the cart")
	 public void verify_removal() throws TimeoutException {
		 if(cp.remove_verify())
			 System.out.println("Product not removed");
		 else
			 System.out.println("Product removed");
		// driver.quit();
	 }
	 @When("refresh the cart")
	 public void refresh() {
		 driver.navigate().refresh();
	 }

}
