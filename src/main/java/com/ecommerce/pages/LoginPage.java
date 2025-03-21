package com.ecommerce.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        
    }
   // WebElement homePageElement = driver.findElement(By.xpath("//h2[contains(text(),'Full-Fledged practice website for Automation Engineers')]"));
    //By loginButton = By.xpath("//a[contains(text(),'Signup / Login')]");
    
    By sinup_login_btn=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    By login_button=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/button");
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
    By crt_acnt=By.tagName("button");
    By continu=By.xpath("//*[@id=\"form\"]/div/div/div/div/a");
    By del_acnt=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[5]/a");
    
    By login_email=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[2]");
    By login_pw=By.xpath("//*[@id=\"form\"]/div/div/div[1]/div/form/input[3]");
    
    By logout=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[4]/a");
    public void clickLogin_SignupButton() {
        driver.findElement(sinup_login_btn).click();
    }
    public void signupPage(String namee,String mail) {
    	driver.findElement(name).sendKeys(namee);
    	driver.findElement(email).sendKeys(mail);
    	driver.findElement(signup_btn).click();
    }
    public void login_button() {
    	driver.findElement(login_button).click();
    }
    public void fill_login_details(String mail,String pw) {
    	driver.findElement(login_email).sendKeys(mail);
        driver.findElement(login_pw).sendKeys(pw);
    }
    public void fillInfo(String fn,String ln,String ps,String d,String m,String y,String add1,String c,String cit,String st,String zc,String num) {
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
    public void click_on_conti() {
    	driver.findElement(continu).click();
    }
    public void delete() {
    	driver.findElement(del_acnt).click();
    }
    public void logout_user() {
    	driver.findElement(logout).click();
    }
    
}
