package com.ecommerce.pages;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CheckoutPage {

	WebDriver driver;
	WebDriverWait wait;
	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));

	}
	By name=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[2]");
    By email=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/input[3]");
    By signup_btn=By.xpath("//*[@id=\"form\"]/div/div/div[3]/div/form/button");
    By password=By.id("password");
    By f_name=By.id("first_name");
    By l_name=By.id("last_name");
    By days=By.id("days");
    By months=By.id("months");
    By years=By.id("years");
    By adr1=By.id("address1");
    By country=By.id("country");
    By city=By.id("city");
    By state=By.id("state");
    By zipcode=By.id("zipcode");
    By mbl=By.id("mobile_number");
    By crt_acnt=By.xpath("//*[@id=\"form\"]/div/div/div/div[1]/form/button");
    By continu=By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    By del_acnt=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    By login_button=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");

    By login_email=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By login_pw=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    
    By logout=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By prod1=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[1]/div[2]");
    By prod_in_cart=By.xpath("//*[@id=\"cart_items\"]");
    By place_order=By.xpath("//*[@id=\"cart_items\"]/div/div[7]/a");
    
    By signup=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    
    By name_on_card=By.name("name_on_card");
    By card_num=By.name("card_number");
    By cvv=By.name("cvc");
    By expiry_month=By.name("expiry_month");
    By expiry_year=By.name("expiry_year");
     
    By download_inv=By.xpath("//*[@id=\"form\"]/div/div/div/a");
    public void login(String mail,String pass) {
    	driver.findElement(login_email).sendKeys(mail);
    	driver.findElement(login_pw).sendKeys(pass);
    	driver.findElement(login_button).click();
    }
    public void clickSignup() {
    	driver.findElement(signup).click();
    }
	public void addProductsToCart() {
		Actions action = new Actions(driver);

		// Hover over the first product
		WebElement product = driver.findElement(prod1);
		action.moveToElement(product).perform(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement addToCartButton = driver.findElement(By.xpath("//a[@data-product-id='1']"));
		js.executeScript("arguments[0].click();", addToCartButton);
    }
	 public void clickCartButton() {
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 WebElement cart= driver.findElement(By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u"));
		 js.executeScript("arguments[0].click();", cart);
	    }
	 public boolean isCartPageVisible() {
				int count= driver.findElements(prod_in_cart).size();
				return count>0;
			
	    }
	 public void clickProceedToCheckout() {
	        driver.findElement(By.xpath("//*[@id=\"do_action\"]/div[1]/div/div/a")).click();
	    }
	 public void clickRegisterLogin() {
	        driver.findElement(By.linkText("Register / Login")).click();
	    }

	 public void signupPage_(String namee,String mail) {
	    	driver.findElement(name).sendKeys(namee);
	    	driver.findElement(email).sendKeys(mail);
	    	driver.findElement(signup_btn).click();
	    }
	    public void login_button_() {
	    	driver.findElement(login_button).click();
	    }
	    public void fill_login_details_(String mail,String pw) {
	    	driver.findElement(login_email).sendKeys(mail);
	        driver.findElement(login_pw).sendKeys(pw);
	    }
	    public void fillInfo_(String fn,String ln,String ps,String d,String m,String y,String add1,String c,String cit,String st,String zc,String num) {
	    	driver.findElement(f_name).sendKeys(fn);
	    	driver.findElement(l_name).sendKeys(ln);
	    	driver.findElement(password).sendKeys(ps);
	    	driver.findElement(days).sendKeys(d);
	    	driver.findElement(months).sendKeys(m);
	    	driver.findElement(years).sendKeys(y);
	    	driver.findElement(adr1).sendKeys(add1);
	    	driver.findElement(country).sendKeys(c);
	    	driver.findElement(city).sendKeys(cit);
	    	driver.findElement(state).sendKeys(st);
	    	driver.findElement(zipcode).sendKeys(zc);
	    	driver.findElement(mbl).sendKeys(num);
	    	driver.findElement(crt_acnt).click();
	    }
	    public void click_on_conti_() {
	    	driver.findElement(continu).click();
	    }
	    public void delete_() {
	    	driver.findElement(del_acnt).click();
	    }
	    public void add_desc() {
	    	driver.findElement(By.xpath("//*[@id=\"ordermsg\"]/textarea")).sendKeys("No description");
	    	driver.findElement(place_order).click();
	    }
	public boolean verifyOrderSummary_() {
		 try {
		        WebElement orderSummarySection = driver.findElement(By.xpath("//h2[text()='Review Your Order']"));
		        return orderSummarySection.isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false;
		    }
	}
	public void clickPayAndConfirmOrder() {
	
		driver.findElement(name_on_card).sendKeys("Supriya B");
		driver.findElement(card_num).sendKeys("12345678901");
		driver.findElement(cvv).sendKeys("333");
		driver.findElement(expiry_month).sendKeys("02");
		driver.findElement(expiry_year).sendKeys("2026");
		driver.findElement(By.xpath("//*[@id=\"submit\"]")).click();	
		
	}
	public boolean isOrderSuccessMessageVisible() {
		 try {
		        WebElement successMessage = driver.findElement(By.xpath("//*[contains(text(),'Your order has been placed successfully!')]"));
		        return successMessage.isDisplayed();
		    } catch (NoSuchElementException e) {
		        return false;
		    }
	}
	public void invoice() {
		driver.findElement(download_inv).click();
	}
	
}
