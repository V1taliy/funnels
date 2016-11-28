@wonderclickalgotrader

Feature: A set of basic tests which related with all wonderclickalgotrader

  Scenario: Funnel wonderclickalgotrader should open correctly
    Given  I navigate to wonderclickalgotrader"http://www.wonderclickalgotrader.com/"
    Then   funnel wonderclickalgotrader should be opened and logo present
    And    video wonderclickalgotrader should autorun


  Scenario: After registration customer should receive two email on his email
    When    customer fill all required fields in wonderclickalgotrader registration form
