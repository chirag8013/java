Feature: Get Rating Release Details

Background: General Setup
Given Basic Setup

@ratingrelease
Scenario Outline: Get Rating release details Summary
When Rest Get Call is made from "<startdate>" to "<enddate>"
Then Validate Status Line and Status Code for rating release
And Validate Body for rating release details

Examples:
|startdate|enddate|
|20200505|20200505|