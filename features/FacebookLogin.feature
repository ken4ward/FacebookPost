@UATTesting
  Feature: Facebook wrong password login failure validation
    As an user of the facebook
    I want to login my user profile using a wrong password
    In order to validate that it will redirect me to login page

    Background: User navigates to Facebook home page
      Given I am on the Facebook home page page on URL
      Then Log In

      Scenario: Login page redirection
        When I fill in Email or Phone
        And I fill in Password
        And I click on the Log In button
        And It shall redirect to the homepage
        And I click on the post box
        And type hello world
        And click on the post button
