@affordable
Feature: A set of basic tests which related with affordable-appliancemethod

  Scenario: Funnel affordable-appliancemethod should open correctly
    Given I navigate to affordable-appliancemethod "http://www.affordable-appliancemethod.com/"
    Then funnel affordable-appliancemethod should be opened and logo present
    And video affordable-appliancemethod should autorun

  Scenario: After registration customer should receive two email on his email
    When customer fill all required affordable-appliancemethod fields in registration form
    And user should see the Deposit page from affordable-appliancemethod