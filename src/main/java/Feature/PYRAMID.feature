Feature: Test PYRAMID Rest APIs

Background: General Setup
Given Basic Setup

@pyramid
Scenario Outline: Get Rating Release Info for Pyramid 
When Restcall is made for RatingRelInfoPyramid from "<startdate>" to "<enddate>"
Then Validate StatusLine and StatusCode for Pyramid
And Validate Response Body from Pyramid and fetch record with ratingactionname "<ratingactionname>" 

Examples:
|startdate|enddate|ratingactionname|
|20200514|20200515|Municipal Energy Agency of Mississippi|
|20200626|20200627|Blue Ridge (NC) 2020 SALE|