<<<<<<< HEAD
Feature: Get Rating Actions For Accurate
  Scenario: User calls web service to get rating actions for Accurate 
	Given web service returns rating actions for RatingRelInfoAccurate between dates 20200923 and 20200925
	When a user requests for rating release data for Accurate by Dates
	Then the status code for Accurate is 200
	And response for Accurate includes the following
	| ratingActionID		| 3371271 					|
	| analystLocation		| New York - 7 World Trade Center			|
    | ratingActionName      | Caja Rural de Navarra - Mortgage Covered Bonds|
	| officeName            | Moody's Deutschland GmbH|
=======
Feature: Get Rating Actions For Accurate
  Scenario: User calls web service to get rating actions for Accurate 
	Given web service returns rating actions for RatingRelInfoAccurate between dates 20200923 and 20200925
	When a user requests for rating release data for Accurate by Dates
	Then the status code is 200
	And response includes the following
	| ratingActionID		| 3371271 					|
	| analystLocation		| New York - 7 World Trade Center			|
    | ratingActionName      | Caja Rural de Navarra - Mortgage Covered Bonds|
	| officeName            | Moody's Deutschland GmbH|
>>>>>>> 348541d2a1941c2c3c52c4f8ff380c6d7f80156a
	