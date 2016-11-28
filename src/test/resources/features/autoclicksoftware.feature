@autoclick
Feature: A set of basic tests which related with all autoclicksoftware


  Scenario: Funnel autoclicksoftware should open correctly
  Given     I navigate to AutoClickSoftWare "http://www.autoclicksoftware.com/"
  Then      funnel autoclicksoftware should be opened and logo present
  And       video autoclicksoftware should autorun

  Scenario: After registration customer should receive two email on his email
  When      customer fill all required autoclicksoftware fields in registration form
    And     user should see the Deposit page from autoclicksotfare