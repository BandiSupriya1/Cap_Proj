package com.ecommerce.runners;



import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features/Checkout.feature",
        glue = "com.ecommerce.stepDefinitions",
      // tags="@CheckoutFunctionsSignup",
     //   plugin = {"pretty", "html:target/cucumber-reports.html"},
        		//plugin = {
      		    //      "pretty",
      		    //      "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"
     		 // },
        		plugin = {"pretty", "json:target/cucumber-reports-json/Cucumber.json"} ,// Generate JSON report
        monochrome = true
)
public class CucumberTestRunner extends AbstractTestNGCucumberTests {
}
