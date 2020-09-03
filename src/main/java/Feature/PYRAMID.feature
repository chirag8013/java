Feature: Test PYRAMID Rest APIs

Scenario: Get Rating Release Info Pyramid
When Restcall is made for RatingRelInfoPyrmaid
Then Validate StatusLine and StatusCode Pyramid
And Validate Body Pyramid