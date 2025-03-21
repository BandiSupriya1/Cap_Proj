@CartFunctions
 Feature: CartFunctions
   Background:
     Given the user navigates to home for cart "https://www.automationexercise.com/"
     Then the home page should visible successfully for cart
 @CartSubscription
 Scenario: Subscription in cart page
    When the user clicks on cart page
    When the user scrolls down to the footer in cart
    Then the text "Subscription" should be visible in cart
    When the user enters "test1@example.com" in the subscription input and clicks the subscription arrow button in cart
    Then the success message "You have been successfully subscribed!" should be visible in cart
@AddToCart  
Scenario: add product in cart
   When the user clicks on product page
   And the user adds first product to cart
   And the user continues shopping
   And the user adds second product to cart
   And the user continues shopping
   And the user clicks on cart page
   Then both products should be added to the cart
   And verify their prices, quantity, and total price
   
 @VerifyProductQuantity  
Scenario: Verify Product quantity in Cart
   When the user clicks on product page
    And the user opens the product details of first product
    Then product details should be displayed
    When the user increases quantity to "4"
    And the user clicks on add to cart  button
    And the user continues shopping
    And the user clicks on cart page
    Then the product should be displayed in the cart with exact quantity "4"
    
@RemoveProdFromCart    
Scenario: Remove products from cart
    
    When the user clicks on product page
   And the user adds first product to cart
   And the user continues shopping
   And the user clicks on cart page
   And refresh the cart
   Then Click x button corresponding to particular product
   Then Verify that product is removed from the cart
   
      