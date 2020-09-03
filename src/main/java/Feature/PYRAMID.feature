Feature: Test PYRAMID Rest APIs

Scenario: Get Rating Release Info for Pyramid from 20200514 to 20200515
When Restcall is made for RatingRelInfoPyrmaid
Then Validate StatusLine and StatusCode for Pyramid
And Validate Body for Pyramid