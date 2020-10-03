Feature: Get Rating Actions For ORP
  Scenario: User calls web service to get rating actions for ORP 
	Given web service returns rating actions for RatingRelInfoORP between dates 20200923 and 20200925
	When a user requests for rating release data for ORP by Dates
	Then the status code for ORP is 200
	And response for ORP includes the following
	| ratingActionID		| 57557757588686 					|
	| analystLocation		| New York - 7 World Trade Center			|
    | ratingActionName      | Caja Rural de Navarra - Mortgage Covered Bonds|
	| officeName            | Moody's Deutschland GmbH|
	