@mitluka
Feature: A set of basic tests which related with mitlukashermann

  Scenario: Funnel mitlukashermann should open correctly
  Given     I navigate to mitlukashermann "http://www.mitlukashermann.com/"
  Then      funnel mitlukashermann should be opened and logo present

  Scenario: After registration customer should receive two email on his email
  When      customer fill all required mitlukashermann fields in registration form
  And       video mitlukashermann should autorun
  And       finish with registration
  And       user should see the Deposit page from mitlukashermann