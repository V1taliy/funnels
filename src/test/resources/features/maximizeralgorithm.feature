@maximize
Feature: A set of basic tests which related with maximizeralgorithm

  Scenario: Funnel maximizeralgorithm should open correctly
    Given  I navigate to maximizeralgorithm "http://www.maximizeralgorithm.com/"
    Then   funnel maximizeralgorithm should be opened and logo present

  Scenario: After registration customer should receive two email on his email
    When    customer fill all required maximizeralgorithm fields in registration form
    And     user should see the Deposit page from maximizeralgorithm