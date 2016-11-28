@google
Feature: A set of basic tests which related with googletrademethod

  Scenario: Funnel googletradermethod should open correctly
    Given  I navigate to googletradermethod "http://www.googletradermethod.com"
    Then   funnel googletradermethod should be opened and logo present

  Scenario: After registration customer should receive two email on his email
    When    customer fill all required googletradermethod fields in registration form
    And     user should see the Deposit page from googletradermethod