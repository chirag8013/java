Feature: Get Rating Actions For Accurate
  Scenario: User calls web service to get rating actions for Accurate 
	Given web service returns rating actions for RatingRelInfoAccurate between dates 20200923 and 20200925
	When a user requests for rating release data for Accurate by Dates
	Then the status code is 200
	And response includes the following
	| ratingActionID		| 3456835 					|
	| analystLocation		| New York - 7 World Trade Center			|
   And response includes the following in any order
    | ratingActionName      | "Italian Real Estate Leasing NPL (Orig:Alba Leasing, Banco BPM; Arr: SCGIB)"|
	| officeName            | "Moody's Deutschland GmbH"|
	