Feature: Get Rating Actions For Pyramid
  Scenario: User calls web service to get rating actions for Pyramid 
	Given web service returns rating actions for RatingRelInfoPyramid between dates 20200923 and 20200925
	When a user requests for rating release data for Pyramid by Dates
	Then the status code for Pyramid is 200
	And response for Pyramid includes the following
	| ratingActionID		| 906546255 					|
	| analystLocation		| San Francisco - One Front Street			|
    | ratingActionName      | Rutgers University, NJ CP self-liquidity 2020|