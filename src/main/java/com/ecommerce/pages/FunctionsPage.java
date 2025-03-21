package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class FunctionsPage {

	WebDriver driver;

	public FunctionsPage(WebDriver driver) {
		this.driver = driver;

	}

	By tc_link=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
	
    By view_prod=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[2]/a/i");
    //By click_product=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[2]/div/div[2]/ul/li/a");
    By prod_info=By.xpath("/html/body/section/div/div/div[2]/div[2]/div[2]/div");
    By search_box=By.xpath("//*[@id=\"search_product\"]");
    By search_button=By.xpath("//*[@id=\"submit_search\"]/i");
    By sub_mail=By.xpath("//*[@id=\"susbscribe_email\"]");
    
    By arrow_click=By.xpath("//*[@id=\"subscribe\"]/i");
    
    By women_cate=By.xpath("//*[@id=\"accordian\"]/div[1]/div[1]/h4/a");
    By women_dress=By.xpath("//*[@id=\"Women\"]/div/ul/li[1]/a");
    By men_cate=By.xpath("//*[@id=\"accordian\"]/div[2]/div[1]/h4/a");
    By men_jeans=By.xpath("//*[@id=\"Men\"]/div/ul/li[2]/a");
    
    By brand1=By.xpath("//a[contains(@href, 'brand_products/5')]");
    By brand2=By.xpath("//a[contains(@href, 'brand_products/3')]");
    
    By prod2=By.xpath("/html/body/section[2]/div/div/div[2]/div/div[3]/div/div[1]/div[2]/div/a");
    By click_cart=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[3]/a");
    
    By signup_button=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    
    By login_email=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By login_pw=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    
    By login_button=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
    
    By prod_in_cart=By.xpath("//*[@id=\"cart_items\"]");
    
    By submit=By.id("button-review");
    
    By name=By.id("name");
    By email=By.id("email");
    By rev=By.id("review");
    
    By add_to_cart_rec=By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[1]/div[1]/div/div/div/a");
    By view_cart=By.xpath("//*[@id=\"cartModal\"]/div/div/div[2]/p[2]/a/u");
    
    By scroll_up=By.cssSelector(".fa.fa-angle-up");
    
    By searched_prod=By.cssSelector(".product-overlay");
    //By cart_but=By.xpath("")
    public void tc() {
    	driver.findElement(tc_link).click();
    }
    public void view_prod() {
    	driver.findElement(view_prod).click();
    	//driver.navigate().refresh();
    }
    public boolean product_info_check() {
    	Boolean b=driver.findElement(prod_info).isDisplayed();
		return b;
    }
    public void search_bar_click() {
    	driver.findElement(search_box).sendKeys("t shirt");
    	driver.findElement(search_button).click();
    }
    public void fill_email(String m) {
    	driver.findElement(sub_mail).sendKeys(m);
    	driver.findElement(arrow_click).click();
    }
    
    public void click_women_cate() {
    	driver.findElement(women_cate).click();
    }
    public void click_dress_under_women_cate() {
    	driver.findElement(women_dress).click();
    }
    public void click_men_cate() {
    	driver.findElement(men_cate).click();
    }
    public void click_jeans_under_men_cate() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement jeans = driver.findElement(By.xpath("//a[contains(text(),'Jeans')]"));
    	js.executeScript("arguments[0].click();", jeans);  
    }
    
    public void click_one_brand() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement poloBrand = driver.findElement(By.xpath("//a[text()='Polo']"));
    	js.executeScript("arguments[0].click();", poloBrand);

    }
    public void click_other_brand() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement poloBrand = driver.findElement(By.xpath("//a[text()='H&M']"));
    	js.executeScript("arguments[0].click();", poloBrand);

    }
    public void add_product_to_cart() {
    	Actions action = new Actions(driver);
		WebElement product = driver.findElement(searched_prod);
		action.moveToElement(product).perform(); 
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement addToCartButton = driver.findElement(By.cssSelector(".btn.btn-default.add-to-cart"));
		js.executeScript("arguments[0].click();", addToCartButton);
    }
    public void click_on_cart() {
    	driver.findElement(click_cart).click();
    	driver.navigate().refresh();
    }
    public void signup() {
    	driver.findElement(signup_button).click();
    }
    public void fill_email_password(String mail,String pw) {
        	driver.findElement(login_email).sendKeys(mail);
            driver.findElement(login_pw).sendKeys(pw);   
            driver.findElement(login_button).click();
    }
    public boolean verify_cart() {
		int count= driver.findElements(prod_in_cart).size();
		return count>0;
	}
    public void sub() {
    	driver.findElement(submit).click();
    }
    public void details(String e,String n,String review) {
    	driver.findElement(email).sendKeys(e);
    	driver.findElement(name).sendKeys(n);
    	driver.findElement(rev).sendKeys(review);
    }
    
    public void add_cart() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement add_to_cart= driver.findElement(By.xpath("//*[@id=\"recommended-item-carousel\"]/div/div[2]/div[1]/div/div/div/a"));
    	js.executeScript("arguments[0].click();", add_to_cart);
    }
    public void click_cart() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
    	WebElement view_cart= driver.findElement(By.tagName("u"));
    	js.executeScript("arguments[0].click();", view_cart);
    	driver.navigate().refresh();
    }
    //scroll up
    public void scroll_up_arr() {
    	((JavascriptExecutor) driver).executeScript("document.querySelector('ins.adsbygoogle').remove();");
    	WebElement element = driver.findElement(By.cssSelector(".fa.fa-angle-up"));
    	((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    	element.click();
    }
  
}
