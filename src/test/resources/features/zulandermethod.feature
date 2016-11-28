@zulander

Feature: A set of basic tests which related with all zulandermethod

  Scenario: Funnel zulander should open correctly
    Given  I navigate to "http://www.zulandermethod.com"
    Then   funnel zulander should be opened and logo present
    And    video should autorun

  Scenario: After registration customer should receive two email on his email
    When    customer fill all required fields in registration form
    And     user should see the Deposit page


