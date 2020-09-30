Feature: Test ACCURATE Rest APIs

Background: General Setup
Given Basic Setup

@accurate
Scenario Outline: Get Rating Release Info for Accurate 
When Restcall is made for RatingRelInfoAccurate from "<startdate>" to "<enddate>"
Then Validate StatusLine and StatusCode for Accurate
And Validate Response Body from Accurate and fetch record with ratingactionname "<ratingactionname>" 

Examples:
|startdate|enddate|ratingactionname|
|20200505|20200506|Strandhill RMBS Designated Activity Company|
|20200511|20200512|Strandhill RMBS Designated Activity Company|


@accurate1
Scenario Outline: Get Rating Release Info for Accurate 
When Restcall is made for RatingRelInfoAccurate from "<startdate>" to "<enddate>"
Then Validate "<StatusLine>" and "<StatusCode>" for Accurate
And Validate Response from Accurate which includes Ratingactionid "<ratingactionid>" and Analystlocation "<analystlocation>" 

Examples:
|startdate|enddate|ratingactionid|StatusLine  |StatusCode|analystlocation                |
|20200923|20200925|3446283       |HTTP/1.1 200|200       |New York - 7 World Trade Center|
