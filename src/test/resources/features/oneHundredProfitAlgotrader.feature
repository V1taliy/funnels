@oneHundred
Feature: A set of basic tests which related with OneHundredProfitalgotrader

#  As a product owner
#  In order to test the main functionality
#  I want to be sure that basic functionality works correctly and meets the requirements

  Scenario: Funnel oneHundredProfitalgotrader should open correctly
  Given  I navigate to oneHundredProfitalgotrader "http://www.100profitalgotrader.com/"
  Then   funnel oneHundredProfitalgotrader should be opened and logo present
  And    video oneHundredProfitalgotrader should autorun

  Scenario: After registration customer should receive two email on his email
  When    customer fill all required oneHundredProfitalgotrader fields in registration form
  And     user should see the Deposit page from oneHundredProfitalgotrader