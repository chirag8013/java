Feature: Get Rating Actions For ORP
  Scenario: User calls web service to get rating actions for ORP 
	Given web service returns rating actions for RatingRelInfoORP between dates 20200923 and 20200925
	When a user requests for rating release data for ORP by Dates
	Then the status code for ORP is 200
	And response for ORP includes the following
	| ratingActionID		| RTG-991 					|
	| analystLocation		| New York US New York - 7 World Trade Center			|
    | ratingActionName      | Everest Reinsurance Company|
	| officeName            | Moody's Investors Service, Inc.|
	
	
	@Second
    Scenario: Validating the response from Openshift and Docker
    Given web service returns rating actions for RatingRelInfoORP between dates 20200923 and 20200923 for Openshift
    And web service returns rating actions for RatingRelInfoORP between dates 20200923 and 20200923 for Docker
	When a user requests for rating release data for ORP by Dates through Openshift
	And a user requests for rating release data for ORP by Dates through Docker
	Then validate the response from Openshift and docker