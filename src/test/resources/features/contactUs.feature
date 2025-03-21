@ContactUs
Feature: Contact Us

  Background:
    Given the user navigates to home "https://www.automationexercise.com/"
    Then the home page should be visible successfully for contact_us
    
    Scenario: Contact Us
    Given the user clicks on "Contact Us" buttons
    Then Verify 'Get In Touch' is visible
    And enter details
    Then click ok on alert box
    Then verify success msgs 'Success! Your details have been submitted successfully.'
    Then click on Home button and verify whether loaded or not
    
  
    
    