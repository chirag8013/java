Feature: Test ORP Rest APIs

Background: General Setup
Given Basic Setup

@orp
Scenario Outline: Get Rating Release Info for ORP 
When Restcall is made for RatingRelInfoORP from "<startdate>" to "<enddate>"
Then Validate StatusLine and StatusCode for ORP
And Validate Response Body from ORP and fetch record with ratingactionname "<ratingactionname>" 

Examples:
|startdate|enddate|ratingactionname|
|20200505|202005106|Centene Corporation|
