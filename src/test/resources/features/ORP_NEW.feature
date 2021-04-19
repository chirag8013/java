Feature: Get Rating Actions For ORP

 @First
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
    Scenario Outline: Validating the response from Openshift and Docker
    Given web service returns rating actions for RatingRelInfoORP between dates 20201019 and 20201019 for Openshift
    And web service returns rating actions for RatingRelInfoORP between dates 20201019 and 20201019 for Docker
	When a user requests for rating release data for ORP by Dates for Openshift and fetch "<field>"
	And a user requests for rating release data for ORP by Dates for Docker and fetch "<field>"
	Then validate the ORP response from Openshift and docker
	 
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