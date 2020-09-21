Feature: Test PYRAMID Rest APIs

Background: General Setup
Given Basic Setup

@pyramid
Scenario Outline: Get Rating Release Info for Pyramid 
When Restcall is made for RatingRelInfoPyramid from "<startdate>" to "<enddate>"
Then Validate StatusLine and StatusCode for Pyramid
And Validate Body for Pyramid

Examples:
|startdate|enddate|
|20200514|20200515|
|20200626|20200627|