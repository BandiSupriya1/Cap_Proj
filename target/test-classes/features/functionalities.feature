

Feature: Functions
   Background:
     Given the user navigates "https://www.automationexercise.com/"
     Then the home page should visible successfully
     
@CheckTCPage
   
    Scenario: TestCases
    Then Click on Test Cases button
    Then Verify user is navigated to test cases page successfully 'Test Cases'
    
@ViewAllProducts    

    Scenario: View Product page and choose first porduct
    Then Click on Product button
    Then Verify user is navigated to 'All Products' page successfully
    Then The products list is visible
    Then Click on View Product of first product
    Then User is landed to product detail page
    
 @SearchProduct
    
    Scenario: Search Product
    Then Click on Product button
    Then Verify user is navigated to 'All Products' page successfully
    Then Enter product name in search input and click search button
    Then Verify 'Searched Products' visibility
    Then Verify search related products displayed or not
    
 @SubscriptionOnHome
   
    Scenario: Subscription in home page
    When the user scrolls down to the footer
    Then the text "Subscription" should be visible
    When the user enters "test@example.com" in the subscription input and clicks the subscription arrow button
    Then the success message "You have been successfully subscribed!" should be visible
 
@ViewProductCategories  
 Scenario:  View Category Products
    Then Click on Product button
    When user clicks on women category
    Then user selects dress category under that
    And check 'Women - Dress Products' is visible or not
    Then user selects men category
    And user selects jeans category under that
    And check 'Men - Jeans Products' is visible or not
    
@VerifyDifferentBrands
Scenario: View different brands
     Then Click on Product button
     When user clicks on any brand
     And check 'Brand - Polo Products' is visible or not
     Then user selects other brand
     And check 'Brand - H&M Products' is visible or not
      
@SearchAndAddToCart

Scenario:  Search Products and Verify Cart After Login
    Then Click on Product button
   Then Verify user is navigated to 'All Products' page successfully
   Then Enter product name in search input and click search button
   Then Verify 'Searched Products' visibility
    Then Verify search related products displayed or not
    When adding products to cart
    Then click on signin button from search
    When enter user enters email as "shona3@example.com" and password as "shona@123" for search
    Then click on cart button for search
    Then verify products visible or not for search
    
@AddReview
   
   Scenario: Add review on product 
    Then Click on Product button
    Then Verify user is navigated to 'All Products' page successfully
    Then The products list is visible
    Then Click on View Product of first product
    And Verify 'Write Your Review' is visible for review
    And Enter name and email and review
    Then Click Submit button for review
    Then Verify success message 'Thank you for your review.'
  
 @RecommendedProducts   
  Scenario:  Add to cart from Recommended items
     Then Scroll to bottom of page for review
     Then Verify 'recommended items' are visible for review
     Then  Click on Add To Cart on Recommended product
     When Click on View Cart button
     Then Verify that product is displayed in cart page
 
 @ScrollUp
 
 Scenario: Verify Scroll Up using Arrow button and Scroll Down functionality
 
    When the user scrolls down to the footer
    Then the text "Subscription" should be visible       
    And Click on arrow at bottom right side to move upward
    Then the home page should visible successfully
    
@ScrollDownAndScrollUpWithoutArrow

 Scenario: Verify Scroll Up without Arrow button and Scroll Down functionality
   When Scroll down without arrow or functionality
   Then the text "Subscription" should be visible
   Then Scroll up without arrow or functionality
   Then the home page should visible successfully
   
       