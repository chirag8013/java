Feature: Get Rating Release Details

Background: General Setup
Given Basic Setup

@ratingrelease
Scenario: Get Rating release details from 20200505 to 20200506
When Rest Get Call is made for the mentioned date
Then Validate Status Line and Status Code for rating release
And Validate Body for rating release details