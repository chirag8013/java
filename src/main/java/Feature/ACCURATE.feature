Feature: Test ACCURATE Rest APIs

Scenario: Get Rating Release Info Accurate
When Restcall is made for RatingRelInfoAccurate
Then Validate StatusLine and StatusCode Accurate
And Validate Body Accurate