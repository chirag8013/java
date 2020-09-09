Feature: Test ORP Rest APIs

Background: General Setup
Given Basic Setup

Scenario Outline: Get Rating Release Info for ORP 
When Restcall is made for RatingRelInfoORP from "<startdate>" to "<enddate>"
Then Validate StatusLine and StatusCode for ORP
And Validate Body for ORP

Examples:
|startdate|enddate|
|20200505|202005106|
