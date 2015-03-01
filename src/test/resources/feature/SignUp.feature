@signup
  Feature: User Sign up

    @fb
    Scenario: I get an error after email confirmation if I sign up for FB using same email account
      Given I am on sign up page
      When I sign up
      And I get the confirmation email
      Then I complete the registration
      And I see an error