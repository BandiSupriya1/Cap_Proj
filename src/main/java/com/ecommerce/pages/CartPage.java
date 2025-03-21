package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

//import io.cucumber.messages.types.Duration;

public class CartPage{

	WebDriver driver;
	WebDriverWait wait;
	public CartPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	By cart_page=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a/i");
	By prod_page=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a");
	By prod1=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]");
	By product1_cart=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]/div/a");
	By prod2=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
	By continu=By.xpath("//*[@id=\"cartModal\"]/div/div/div[3]/button");
	By prod_in_cart=By.xpath("//*[@id=\"cart_items\"]");
	By prod_price=By.xpath("//td[@class='cart_price']/p");
	By prod_quant=By.xpath("//td[@class='cart_quantity']/button");
	By prod_total=By.xpath("//td[@class='cart_total']/p");

	By arrow_click=By.xpath("//*[@id=\"subscribe\"]/i");
	By sub_mail=By.xpath("//*[@id=\"susbscribe_email\"]");

	By view_product=By.xpath("//*[@id=\\\"header\\\"]/div/div/div/div[2]/div/ul/li[2]/a/i");
	By product_details=By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
	By quantityField = By.id("quantity");
	By addToCartButton = By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div/span/button");
	By firstProduct = By.xpath("(//div[@class='productinfo text-center'])[1]");
	By productDetailsLink = By.xpath("(//a[contains(text(),'View Product')])[1]");
	
	By remove=By.xpath("//*[@id=\"product-1\"]/td[6]/a/i");
	By productRow = By.xpath("//tr[@class='cart_item']");

	public void cart() {
		//driver.findElement(cart_page).click();
		driver.navigate().to("https://www.automationexercise.com/view_cart");
	}
	public void fill_mail(String m) {
		driver.findElement(sub_mail).sendKeys(m);
		driver.findElement(arrow_click).click();
	}

	public void addFirstProductToCart() {
		Actions action = new Actions(driver);

		// Hover over the first product
		WebElement product = driver.findElement(prod1);
		action.moveToElement(product).perform(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		js.executeScript("arguments[0].click();", addToCartButton);
	}
	public void addSecondProductToCart() {
		Actions action = new Actions(driver);
		WebElement product = driver.findElement(prod2);
		action.moveToElement(product).perform(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-product-id='2']"));
		js.executeScript("arguments[0].click();", addToCartButton);
	}
	public void click_continue() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement continueShoppingButton = driver.findElement(By.xpath("//button[contains(text(),'Continue Shopping')]"));
		js.executeScript("arguments[0].click();", continueShoppingButton);

	}
	public void click_prod() {
		driver.findElement(prod_page).click();
	}
	public boolean verify_cart() {
		int count= driver.findElements(prod_in_cart).size();
		return count==2;
	}
	public boolean check_cart_details() {
		driver.navigate().refresh();
		String price1 = driver.findElements(prod_price).get(0).getText();
		String price2 = driver.findElements(prod_price).get(1).getText();
		String quantity1 = driver.findElements(prod_quant).get(0).getText();
		String quantity2 = driver.findElements(prod_quant).get(1).getText();
		String total1 = driver.findElements(prod_total).get(0).getText();
		String total2 = driver.findElements(prod_total).get(1).getText();

		System.out.println("Price1: " + price1 + " | Quantity1: " + quantity1 + " | Total1: " + total1);
		System.out.println("Price2: " + price2 + " | Quantity2: " + quantity2 + " | Total2: " + total2);

		return !price1.isEmpty() && !price2.isEmpty() &&
				!quantity1.isEmpty() && !quantity2.isEmpty() &&
				!total1.isEmpty() && !total2.isEmpty();
	}

	public void view_product() {
		WebElement productDetailsLink = driver.findElement(By.xpath("//a[@href='/product_details/1']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", productDetailsLink);
	}

	public boolean view_product_details() {
		return driver.findElement(product_details).isDisplayed();
	}
	public void increase_quant(String quantity) {
		WebElement quantityInput = wait.until(ExpectedConditions.visibilityOfElementLocated(quantityField));
		quantityInput.clear();
		quantityInput.sendKeys(quantity);
	}
	public void add_to_cart() {
		driver.findElement(addToCartButton).click();
	}
	public boolean check_corr_quant(String q) {
		try {
			List<WebElement> quantities = driver.findElements(prod_quant);
			if (!quantities.isEmpty()) {
				String quantity = quantities.get(0).getText();
				return quantity.equals(q); // Use equals for String comparison
			}
			return false;
		} catch (Exception e) {
			System.out.println("Failed to verify quantity: " + e.getMessage());
			return false;
		}
	}
	public void remove_from_cart() {
		driver.findElement(remove).click();
	}
	public boolean remove_verify() throws TimeoutException {
		wait.until(ExpectedConditions.invisibilityOfElementLocated(productRow));
		return true;
	}
}
