Feature: Test ACCURATE Rest APIs

Background: General Setup
Given Basic Setup

Scenario Outline: Get Rating Release Info for Accurate 
When Restcall is made for RatingRelInfoAccurate from "<startdate>" to "<enddate>"
Then Validate StatusLine and StatusCode for Accurate
And Validate Body for Accurate

Examples:
|startdate|enddate|
|20200505|20200506|
|20200511|20200512|
