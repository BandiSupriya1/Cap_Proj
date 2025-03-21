
 Feature: CheckoutFunctions
   Background:
     Given the user navigates to home for checkout "https://www.automationexercise.com/"
     Then the home page should visible successfully for checkout
@CheckoutFunctionsSignup    
Scenario: Complete checkout process with account creation
    When the user adds products to cart for checkout
    And the user clicks on Cart button for checkout
    Then the user verifies that cart page is displayed for checkout
    When the user clicks on Proceed To Checkout button
    And the user clicks on Register Login button for checkout
    Then user should see signup "New User Signup!" for checkout
    When the user enters name as "Supriya" and email as "supriyaa6@example.com" for checkout
    Then the user should see the "Enter Account Information" for checkout
    And the user fills the details for signup for checkout
    Then the user should see the message "Account Created!" for checkout
    Then click on continue button for checkout
    Then the user should see the message username "Logged in as Supriya" for checkout
    And the user clicks on Cart button for checkout
    When the user clicks on Proceed To Checkout button
    And Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Click Pay and Confirm Order button
    Then the user should see the message 'Your order has been placed successfully!' for checkout
    Then delete the account for checkout
    Then click on continue button after deleting the account for checkout
    Then the user should see the message deleted "Account Deleted!" for checkout
    Then click on continue button for checkout
    
@CheckoutFunctionsFirstSignup    
  
  Scenario: : Place Order: Register before Checkout
    When click on signuplogin button for checkout
    Then user should see signup "New User Signup!" for checkout
    When the user enters name as "Supriya" and email as "supriyaa3@example.com" for checkout
    Then the user should see the "Enter Account Information" for checkout
    And the user fills the details for signup for checkout
    Then the user should see the message "Account Created!" for checkout
    Then click on continue button for checkout
    Then the user should see the message username "Logged in as Supriya" for checkout
    When the user adds products to cart for checkout
    And the user clicks on Cart button for checkout
    When the user clicks on Proceed To Checkout button
    And Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Click Pay and Confirm Order button
    Then the user should see the message  'Your order has been placed successfully!' for checkout
    Then delete the account for checkout
    Then click on continue button after deleting the account for checkout
    Then the user should see the message deleted "Account Deleted!" for checkout
    

@CheckoutFunctionsFirsLogin
Scenario:  Place Order: Login before Checkout
    When click on signuplogin button for checkout
    Then user should see signup "Login to your account" for checkout
    When the user enters email as "emailforcheckout@example.com" and password as "sup@123" for checkout
    Then the user should see the message username "Logged in as Supriya" for checkout
    When the user adds products to cart for checkout
    And the user clicks on Cart button for checkout
    When the user clicks on Proceed To Checkout button
    And Verify Address Details and Review Your Order
    And Enter description in comment text area and click Place Order
    And Click Pay and Confirm Order button
    Then the user should see the message  'Your order has been placed successfully!' for checkout
    Then delete the account for checkout
    Then click on continue button after deleting the account for checkout
    Then the user should see the message deleted "Account Deleted!" for checkout  
    
    
@SignUpAndCheckDetailsOfAddress

   Scenario: Verify address details in checkout page
   
   When click on signuplogin button for checkout
    Then user should see signup "New User Signup!" for checkout
    When the user enters name as "Supriya" and email as "supriyaa4@example.com" for checkout
    Then the user should see the "Enter Account Information" for checkout
    And the user fills the details for signup for checkout
    Then the user should see the message "Account Created!" for checkout
    Then click on continue button for checkout
    Then the user should see the message username "Logged in as Supriya" for checkout
    When the user adds products to cart for checkout
    And the user clicks on Cart button for checkout
    When the user clicks on Proceed To Checkout button
    And Verify that the billing address is same address filled at the time registration of account
    And Verify that the delivery address is same address filled at the time registration of account
    Then delete the account for checkout
    Then click on continue button after deleting the account for checkout
    Then the user should see the message deleted "Account Deleted!" for checkout  
    
          
@DownloadInvoice
  
  Scenario:  Download Invoice after purchase order
  
  When click on signuplogin button for checkout
    Then user should see signup "New User Signup!" for checkout
    When the user enters name as "Supriya" and email as "supriyaa5@example.com" for checkout
    Then the user should see the "Enter Account Information" for checkout
    And the user fills the details for signup for checkout
    Then the user should see the message "Account Created!" for checkout
    Then click on continue button for checkout
    Then the user should see the message username "Logged in as Supriya" for checkout
    When the user adds products to cart for checkout
    And the user clicks on Cart button for checkout
    When the user clicks on Proceed To Checkout button
    And Verify that the delivery address is same address filled at the time registration of account
    And Enter description in comment text area and click Place Order
    And Click Pay and Confirm Order button
    Then the user should see the message  'Your order has been placed successfully!' for checkout
    And Click Download Invoice button and verify invoice is downloaded successfully. 
    Then click on continue button for checkout 
    Then click on continue button after deleting the account for checkout
    Then the user should see the message deleted "Account Deleted!" for checkout
        
    