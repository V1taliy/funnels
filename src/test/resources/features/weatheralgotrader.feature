@weatheralgotrader
Feature: A set of basic tests which related with all weatheralgotrader

  Scenario: Funnel weatheralgotrader should open correctly
    Given  I navigate to weatheralgotrader"http://www.weatheralgotrader.com/"
    Then   funnel weatheralgotrader should be opened and logo present
    And    video weatheralgotrader should autorun


  Scenario: After registration customer should receive two email on his email
    When    customer fill all required fields in weatheralgotrader registration form
    And     user should see the weatheralgotrader Deposit page