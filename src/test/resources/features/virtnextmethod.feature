@virtnextmethod

Feature: A set of basic tests which related with all virtnextmethod

  Scenario: Funnel zulander should open correctly
    Given  I navigate to virtnextmethod "http://virtnextmethod.com/"
    Then   funnel virtnextmethod should be opened and logo present



  Scenario: After registration customer should receive two email on his email
    When    customer fill all required fields in virtnextmethod registration form
    And     user should see the virtnextmethod Deposit page