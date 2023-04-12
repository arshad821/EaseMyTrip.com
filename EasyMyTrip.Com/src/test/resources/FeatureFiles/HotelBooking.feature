@HotelBooking
Feature: This feature is about hotel booking in easymytrip.com

  Scenario: This scenario is to verify Hotel Booking
    Given User is navigating to easymytrip.com in any browser
    When User can click Hotel Option
    And User can give check-in and check-out date
    And User can select number of persons and number of rooms
    And User can click search option
    And user can select filters options and Area
    And user is clicking sorting option and view room button is pressed
    And user is selecting the room and booNow button is pressed
    And user is giving all details and payment button is pressed
    Then User can able to see the payment page now.
