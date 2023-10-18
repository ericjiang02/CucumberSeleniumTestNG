Feature: Contact Form Testing

  Scenario: Test Case 1 - Verify Error Messages
    Given I am on the home page
    When I go to the contact page
    And I click the submit button
    Then I should see error messages
    And I populate mandatory fields with name "John", email "john@test.com" and message "Hello World"
    And I should not see error messages

  Scenario: Test Case 2 - Verify Successful Submission
    Given I am on the home page
    When I go to the contact page
    And I populate mandatory fields with name "John", email "john@example.com" and message "Hello World"
    And I click the submit button
    Then I should see a successful submission message

  Scenario: Test Case 3 - Verify Cart Functionality
    Given I am on the home page
    When I go to the shop page
    And add 2 Stuffed Frog, 5 Fluffy Bunny, 3 Valentine Bear
    And I go to the cart page
    Then I should verify the subtotal for each product is correct
    And I should verify the price for each product
    And I should verify that total = sum(subtotals)
