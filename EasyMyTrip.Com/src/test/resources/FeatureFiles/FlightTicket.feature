@bookticket
Feature: This feature is to book flight  ticket

  Scenario: This test is to verify ticket booking for national trip
    When user can navigate to easymytrip.com in browser
    Given user select from and to airport
    And user can select no.of passenegers and select class
    And User checks filter options and select desired flight and select booknow
    And user must fill passenger details
    And user may selects desired seats and click Continue Booking
    Then user should see the payment page now
