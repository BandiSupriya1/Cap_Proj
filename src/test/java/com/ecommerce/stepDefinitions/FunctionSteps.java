package com.ecommerce.stepDefinitions;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.ecommerce.pages.FunctionsPage;
import com.ecommerce.pages.LoginPage;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.messages.types.Duration;

public class FunctionSteps {

	ChromeDriver driver;
	FunctionsPage fp;
	@Given("the user navigates {string}")
	public void userNavigatesTo(String url) {
		driver = new ChromeDriver();
		fp=new FunctionsPage(driver);
		driver.manage().window().maximize();
		driver.get(url);
	}
	@Then("the home page should visible successfully")
	public void homePageShouldBeVisibleSuccessfully() {
		try {
			WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
			 String actual=homePageElement.getText();
			 System.out.println(actual);
			 String expected="Full-Fledged practice website for Automation Engineers";
			if(actual==expected)
			System.out.println(" Home page is visible successfully");
           
		} catch (Exception e) {
			System.out.println(" Exception occurred while verifying home page: " + e.getMessage());
		}
	}

	//TC page related TC
	
	@Then("Click on Test Cases button")
	public void tc_button() {
		fp.tc();
	}
	@Then("Verify user is navigated to test cases page successfully {string}")
	public void tc_page_check(String message) throws InterruptedException {
		if (driver.getPageSource().contains(message)) {
			System.out.println("Message found: " + message);
		} else {
			System.out.println(" Expected message not found: " + message);
		}
		Thread.sleep(5000);
		//driver.quit();
	}
	
	//Product page related TC
	
	@Then("Click on Product button")
	public void choose_product() {
		fp.view_prod();
	}
	@Then("Verify user is navigated to {string} page successfully")
	public void verify_prod_page(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@Then("The products list is visible")
	public void verify_prod_list_availability() {
		 List<WebElement> products = driver.findElements(By.cssSelector(".product-image-wrapper"));

         if (products.size() > 0) {
             System.out.println("Product list is available. Total products: " + products.size());
         } else {
             System.out.println("Product list is not available.");
         }
	}
	@Then("Click on View Product of first product")
	public void cick_on_first_prod() {
		driver.navigate().to("https://www.automationexercise.com/product_details/1");
	}
	@Then("User is landed to product detail page")
	public void check_info() {
		if(!fp.product_info_check()) {
			System.out.println("Product information page not displayed");
		}
		else {
			System.out.println("Product information page displayed");
		}
		//driver.quit();
	}
	
	//Search related TC
	
	@Then("Enter product name in search input and click search button")
	public void search() {
		fp.search_bar_click();
	}
	@Then("Verify {string} visibility")
	public void verify_search(String str) throws InterruptedException {
		if (driver.getPageSource().contains(str)) {
			System.out.println("Message found: " + str);
		} else {
			System.out.println(" Expected message not found: " + str);
		}
		Thread.sleep(5000);
	}
	@Then("Verify search related products displayed or not")
	public void verify_search_list() {
		List<WebElement> searchResults = driver.findElements(By.cssSelector(".product-image-wrapper"));
        Assert.assertTrue(searchResults.size() > 0, "No products found for the search term.");
        System.out.println("Total products found: " + searchResults.size());
      //  driver.quit();
	}
	
	//Subscription
	
	@When("the user scrolls down to the footer")
    public void user_scrolls_down_to_footer() throws InterruptedException {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
    }
	 @Then("the text {string} should be visible")
	    public void the_text_should_be_visible(String expectedText) throws InterruptedException {
		 if (driver.getPageSource().contains(expectedText)) {
				System.out.println("Message found: " + expectedText);
			} else {
				System.out.println(" Expected message not found: " + expectedText);
			}
			Thread.sleep(5000);
	    }
	 @When("the user enters {string} in the subscription input and clicks the subscription arrow button")
	 public void enter_email_in_sub_box(String mail) {
		 fp.fill_email(mail);
	 }
	 @Then("the success message {string} should be visible")
	 public void success_msg(String msg) throws InterruptedException {
		 if (driver.getPageSource().contains(msg)) {
				System.out.println("Message found: " + msg);
			} else {
				System.out.println(" Expected message not found: " + msg);
			}
			Thread.sleep(5000);
		//	driver.quit();
	 }
	 
	 //Categories
	 
	 @When("user clicks on women category")
	 public void women_category() {
		 fp.click_women_cate();
	 }
	 @Then("user selects dress category under that")
	 public void dress_category() {
		 fp.click_dress_under_women_cate();
	 }
	 @When("check {string} is visible or not")
	 public void check_women_cate(String str) throws InterruptedException {
		 if (driver.getPageSource().contains(str)) {
				System.out.println("Message found: " + str);
			} else {
				System.out.println(" Expected message not found: " + str);
			}
			Thread.sleep(5000);
	 }
	 @Then("user selects men category")
	 public void select_men() {
		 fp.click_men_cate();
	 }
	 @When("user selects jeans category under that")
	 public void select_jeans() {
		 fp.click_jeans_under_men_cate();
		// driver.quit();
	 }
	 
	 //choose diff brands
	 @When("user clicks on any brand")
	 public void click_one_one_brand() {
		 fp.click_one_brand();
	 }
	 
	 @Then("user selects other brand")
	 public void click_other_one_brand() {
		 fp.click_other_brand();
		// driver.quit();
	 }
	 @When("adding products to cart")
	 public void add_to_cart() {
		 fp.add_product_to_cart();
	 }
	 @Then("click on signin button from search")
	 public void click_signin_button() {
		 fp.signup();
	 }
	 @When("enter user enters email as {string} and password as {string} for search")
	 public void fill_det(String em,String ps) {
		 fp.fill_email_password(em, ps);
		
	 }
	 @Then("click on cart button for search")
	 public void cart() {
		 fp.click_on_cart();
	 }
	 @Then("verify products visible or not for search")
	 public void visible_or_not() {
		 if(!fp.verify_cart())
		 System.out.println("Not added");
		 else
			 System.out.println("Added");
	 }
	 //Review
	 @When("Verify {string} is visible for review")
	 public void review(String str) {
		 if (driver.getPageSource().contains(str)) {
				System.out.println("Message found: " + str);
			} else {
				System.out.println(" Expected message not found: " + str);
			}
	 }
	 @When("Enter name and email and review")
	 public void review_det() {
		 fp.details("sup@gmail.com","Supriyaaa","No review");
	 }
	 @Then("Click Submit button for review")
	 public void submit() {
		 fp.sub();
	 }
	 @Then("Verify success message {string}")
	 public void success_review(String str) {
		 if (driver.getPageSource().contains(str)) {
				System.out.println("Message found: " + str);
			} else {
				System.out.println(" Expected message not found: " + str);
			}
	 }
	 //Scroll
	 @Then("Scroll to bottom of page for review")
	 public void scroll_down() throws InterruptedException {
		 WebElement element = driver.findElement(By.xpath("/html/body/section[2]/div/div/div[2]/div[2]/h2"));
		 ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
	 }
	 @Then("Verify {string} are visible for review")
	 public void verify_review(String str) {
		 if (driver.getPageSource().contains(str)) {
				System.out.println("Message found: " + str);
			} else {
				System.out.println(" Expected message not found: " + str);
			}
	 }
	 @Then("Click on Add To Cart on Recommended product")
	 public void click_add_cart() {
		 fp.add_cart();
	 }
	 @When("Click on View Cart button")
	 public void view_cart() {
		 fp.click_cart();
	 }
	 @Then("Verify that product is displayed in cart page")
	 public void verify_it() {
		 if(fp.verify_cart())
			 System.out.println("Product Added Successfully.....");
		 else 
			 System.out.println("Not Added");
		// driver.quit();
	 }
	 
	 //Scroll Up
	 @When("Click on arrow at bottom right side to move upward")
	 public void scroll_up_arrow_click() {
		 fp.scroll_up_arr();
	 }
	 //26th TC
	 @When("Scroll down without arrow or functionality")
	 public void scroll_d() throws InterruptedException {
		 Actions actions = new Actions(driver);
		 actions.scrollByAmount(0, 7000).perform(); 
		 Thread.sleep(3000);
	 }
	 @Then("Scroll up without arrow or functionality")
	 public void scroll_u() {
		 Actions actions = new Actions(driver);
		 actions.scrollByAmount(0, -7000).perform(); 
		// driver.quit();
	 }
//	 @After()
//		 public void tearDown() {
//			 driver.quit();
//		 }
//	 
}
