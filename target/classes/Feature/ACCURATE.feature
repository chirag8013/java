Feature: Test ACCURATE Rest APIs

Scenario: Get Rating Release Info for Accurate from 20200514 to 20200515
When Restcall is made for RatingRelInfoAccurate
Then Validate StatusLine and StatusCode for Accurate
And Validate Body for Accurate