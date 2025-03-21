@LoginSignup
Feature: User Signup and Login

  Background:
    Given the user navigates to "https://www.automationexercise.com/"
    Then the home page should be visible successfully
    Given the user clicks on "Signup / Login" button

  @Signup
  Scenario: New User Signup
  
    Then user should see signup "New User Signup!"
    When the user enters name as "Supriya" and email as "supriyaa@example.com" in the signup form
    Then the user should see the "Enter Account Information"
    And the user fills the details for signup:
     #| FirstName | LastName | Password | Address1 | State | City | Zipcode | mobile |
     #| Supriya   | B        | sup@123  | Main Road| TG    | KMM  | 222222  |12345698|
    Then the user should see the message "Account Created!"
    Then click on continue button
    Then the user should see the message username "Logged in as Supriya"
    Then delete the account
    Then click on continue button after deleting the account
    Then the user should see the message deleted "Account Deleted!"
    
    @ValidLogin
    Scenario: Valid Login Functionality
        
    Then user should see this "Login to your account"
    When the user enters email as "supriyaa@example.com" and password as "sup@123" in the signin form
    Then click on login button
    Then the user should see the message username "Logged in as Supriya"
    Then delete the account
    Then click on continue button after deleting the account
    Then the user should see the message deleted "Account Deleted!"
    
    @InValidLogin
    Scenario: Invalid Login Functionality
    
    Then user should see this "Login to your account"
    When the user enters email as "shona1@example.com" and password as "cap@123" in the signin form
    Then click on login button
    Then Verify error 'Your email or password is incorrect!' is visible
    
    @Logout
    
    Scenario: Logout functionality
    
    Then user should see this "Login to your account"
    When the user enters email as "shona3@example.com" and password as "shona@123" in the signin form
    Then click on login button
    Then the user should see the message username2 "Logged in as shona3"
    Then click on logout button
    Then verify user navigated to login page "Login to your account"
    
    @ExistingUserReg
    
    Scenario: Existing user signing up
    
    Then user should see signup "New User Signup!"
    When the user enters name as "shona3" and email as "shona3@example.com" in the signup form
    Then  Verify error 'Email Address already exist!' is visible
    