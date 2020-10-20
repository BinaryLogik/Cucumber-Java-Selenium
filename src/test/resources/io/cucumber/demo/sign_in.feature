# language: en
@SignIn @Full
Feature: Sign In

  Rule: Sign In should allow only correct credentials to login

    Background:
      Given User starts at Login page

    @Smoke
    Scenario: User successfully signs into site
      When User uses valid credentials
      Then 'My account - My Store' page is loaded

    Scenario: User enters incorrect password
      When User enters wrong password while signing in
      Then User sees login error message 'Authentication failed.'

    Scenario: User enters invalid email address
      When User enters invalid email address while signing in
      Then User sees login error message 'Invalid email address.'

    Scenario: User enters incorrect email address
      When User enters incorrect email address while signing in
      Then User sees login error message 'Authentication failed.'
