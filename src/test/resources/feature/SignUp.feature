@signup
  Feature: User Sign up

    @fb
    Scenario: I want to sign up for FB
      Given I am on sign up page
      When I sign up
      And I get the confirmation email
      Then I get confirm


    @wizters
    Scenario: I want to sign up for xink
      Given I am on wizters sign up page
      When I enter details for wizters
      And I get the confirmation email from wizters
      Then I confirm email from wizters