@yourlegacymethod

Feature: A set of basic tests which related with all zulandermethod

  Scenario: Funnel yourlegacymethod should open correctly
    Given  I navigate to yourlegacymethod "http://www.yourlegacymethod.com/"
    Then   funnel yourlegacymethod should be opened and logo present


  Scenario: After registration customer should receive two email on his email
    When    customer fill all required fields in yourlegacymethod registration form
    And     24 algo robot should open