@signup
  Feature: User Sign up

    @fb
    Scenario: I want to sign up for FB
      Given I am on sign up page
      When I sign up
      And I get the confirmation email
      Then I confirm the details