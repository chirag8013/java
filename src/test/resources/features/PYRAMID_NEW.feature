Feature: Get Rating Actions For Pyramid
  Scenario: User calls web service to get rating actions for Pyramid 
	Given web service returns rating actions for RatingRelInfoPyramid between dates 20200923 and 20200925
	When a user requests for rating release data for Pyramid by Dates
	Then the status code for Pyramid is 200
	And response for Pyramid includes the following
	| ratingActionID		| 906546255 					|
	| analystLocation		| San Francisco - One Front Street			|
    | ratingActionName      | Rutgers University, NJ CP self-liquidity 2020|

    
    @Second
    Scenario Outline: Validating the response from Openshift and Docker
    Given web service returns rating actions for RatingRelInfoPyramid between dates 20201019 and 20201019 for Openshift
    And web service returns rating actions for RatingRelInfoPyramid between dates 20201019 and 20201019 for Docker
	When a user requests for rating release data for Pyramid by Dates for Openshift and fetch "<field>"
	And a user requests for rating release data for Pyramid by Dates for Docker and fetch "<field>"
	Then validate the Pyramid response from Openshift and docker
	 
	Examples:
	|field|
    |sourceSystem|
	|orgId|
	|ratingActionDesc|
	|ratingActionID|
	|ratingActionName|
	|ratingCommitteeDate|
	|ratingOffice|
	|ratingReleaseDate|
	|lobname|
	|sublobname|
	|region|
	|leadAnalystID|
	|leadAnalystName|
	|leadAnalystUniqueId|
	|analystEmail|
	|analystLocation| 
	|approverID|
	|approverName|
	|officeName|
	|documentExceptionListingInd|
	|announcementInd|
	|automaticRating|
	|definitiveRatingPrevProvisional|
	|indicativeRatingInd|
	|definitiveRatingInd|
	|indicativeRatingInd|
	|definitiveRatingInd|
	|linkedAnotherActionInd|
	|privateRatingActionInd|
	|provisionalRatingInd|
	|secondaryactionind|
	|subsequentRatingInd|
	|contactPersonId|
	|complianceType|
	|complianceID|
	|ratingShellId|
	|ratingShellDS|
	|workItemStatus|
	|workItemType|
	|workItemSubType|
	|workItemReleaseDtm|
	|pressReleaseId|
	|securityClassNm|
	|shadowCd|
	|pressReleaseType|
	|pyrRatingType|
	|pacrEmail|
	|pacr|
	|chairEmail|
	|chair|
	|addendum|
	|addendumEmail|
	|backUpAnalyst|
	|prTxt|