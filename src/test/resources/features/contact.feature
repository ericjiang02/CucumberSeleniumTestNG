Feature: Contact Form Testing

  @run
  Scenario: Test Case 1 - Verify Error Messages
    Given I am on the home page
    When I go to the contact page
    And I click the submit button
    Then I should see error messages
    And I populate mandatory fields with name "John", email "john@test.com" and message "Hello World"
    And I should not see error messages

  @run
  Scenario Outline: Test Case 2 - Verify Successful Submission
    Given I am on the home page
    When I go to the contact page
    And I populate mandatory fields with name "John", email "john@example.com" and message "Hello World"
    And I click the submit button
    Then I should see a successful submission message

    Examples:
      | Iterations |
      | 1          |
      | 2          |
      | 3          |
      | 4          |
      | 5          |

  @run
  Scenario: Test Case 3 - Verify Cart Functionality
    Given I am on the home page
    When I go to the shop page
    And I add the following products to the cart:
      | Quantity | Product       | ExpectedPrice |
      | 2        | Stuffed Frog  | 10.99        |
      | 5        | Fluffy Bunny  | 9.99         |
      | 3        | Valentine Bear | 14.99       |
    And I go to the cart page
    Then I should verify the subtotal for each product is correct
      | $21.98 |
      | $49.95 |
      | $44.97 |
    And I should verify the price for each product
      | $10.99        |
      | $9.99         |
      | $14.99        |
    And I should verify that total is sum of subtotals 116.9
