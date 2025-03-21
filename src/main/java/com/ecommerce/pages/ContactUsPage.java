package com.ecommerce.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactUsPage {

	
	WebDriver driver;

    public ContactUsPage(WebDriver driver) {
        this.driver = driver;
        
    }
    
    By contact_us=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[8]/a");
    By name=By.xpath("//*[@id=\"contact-us-form\"]/div[1]/input");
    By email=By.name("email");
    By subj=By.name("subject");
    By msg=By.id("message");
    By upload=By.name("upload_file");
    By submit=By.cssSelector(".btn.btn-primary.pull-left.submit_form");
    By home=By.xpath("//*[@id=\"header\"]/div/div/div/div[2]/div/ul/li[1]/a");
   
    public void click_contact_us() {
    	driver.findElement(contact_us).click();
    }
    public void fill_details_in_form(String n,String e,String s,String m,String u) {
    	driver.findElement(name).sendKeys(n);
    	driver.findElement(email).sendKeys(e);
    	driver.findElement(subj).sendKeys(s);
    	driver.findElement(msg).sendKeys(m);
    	driver.findElement(upload).sendKeys(u);
    	driver.findElement(submit).click();
    	
    }
    public void click_ok() {
    	Alert alert = driver.switchTo().alert();
    	alert.accept();
    }
    public void click_home() {
    	driver.findElement(home).click();
    }
}
