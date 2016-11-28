@tradeconfidentialmethod

Feature: A set of basic tests which related with all tradeconfidentialmethod

  Scenario: Funnel zulander should open correctly
    Given  I navigate to tradeconfidentialmethod "http://www.tradeconfidentialmethod.com"
    Then   funnel tradeconfidentialmethod should be opened and logo present
    And    video tradeconfidentialmethod should autorun

  Scenario: After registration customer should receive two email on his email
    When    customer fill all required fields in tradeconfidentialmethod registration form
    And     user should see the tradeconfidentialmethod Deposit page