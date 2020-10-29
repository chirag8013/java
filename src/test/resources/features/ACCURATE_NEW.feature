Feature: Get Rating Actions For Accurate
  @First
  Scenario: User calls web service to get rating actions for Accurate 
	Given web service returns rating actions for RatingRelInfoAccurate between dates 20201018 and 20201021
	When a user requests for rating release data for Accurate by Dates 
	Then the status code for Accurate is 200
	And response for Accurate includes the following
	| ratingActionID		| 3371271 					|
	| analystLocation		| New York - 7 World Trade Center			|
    | ratingActionName      | Caja Rural de Navarra - Mortgage Covered Bonds|
	| officeName            | Moody's Deutschland GmbH|
	
	
	@Second
    Scenario Outline: Validating the response from Openshift and Docker
    Given web service returns rating actions for RatingRelInfoAccurate between dates 20200923 and 20200923 for Openshift
    And web service returns rating actions for RatingRelInfoAccurate between dates 20200923 and 20200923 for Docker
	When a user requests for rating release data for Accurate by Dates for Openshift and fetch "<field>"
	And a user requests for rating release data for Accurate by Dates for Docker and fetch "<field>"
	Then validate the response from Openshift and docker
	 
	Examples:
	|field|
	|addendumEmail|
	|provisionalRatingInd|
     
	