# language: en
@Newsletter @Full
Feature: Newsletter

  Rule: Users should always be able to sign up for Newsletter

    Background:
      Given User starts at Home page

    Scenario: User successfully signs up for newsletter
      When User enters valid email address while signing up for newsletter
      Then User sees newsletter success message
        """
        Newsletter : You have successfully subscribed to this newsletter.
        """

    Scenario: User fails to sign up for newsletter with invalid email address
      When User enters invalid email address while signing up for newsletter
      Then User sees newsletter error message
        """
        Newsletter : Invalid email address.
        """
