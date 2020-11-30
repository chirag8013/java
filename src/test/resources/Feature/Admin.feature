Feature: Admin functionalities

Background: Validate Admin Utils
When User enter the valid credentials that maps to Admin role in QATS
And is able to view the Admin Landing page
And I am able to login to QATS as an Admin


@First
Scenario Outline: Validate Source-to-QATS domain value mapping 
When Admin chooses the option Mapping QATS to Source from Admin Utils Menu
And selects "<DomainName>" and clicks on Search
And changes mapping of "<SourceValue>" with "<QATSValue>" and click submit to save changes
Then I Should Go back to the Create QA Review and Select Region as "<SourceValue>" and Create the case
And check the QATSValue of created case as expected on Dashboard


Examples:
|DomainName|SourceValue|QATSValue|
|Region|Europe|US/Canada|
|Region|Europe|EMEA|


@Second
Scenario Outline: Delete Source-to-QATS Value Mapping 
When Admin chooses the option Mapping QATS to Source from Admin Utils Menu
And Admin selects "<DomainName>" and clicks on Search
And after clicking the first record the Admin clicks on delete the mapping of record  with "<sourcevalue>"and submit
Then Admin clicks on submit on QATS vs Source Mapping Page to save the changes

Examples:
|DomainName|sourcevalue|
|LOB|SFG|
|Sub LOB|Housing|
|Region|Delhi|


@Third
Scenario Outline: Add Source-to-QATS domain value mapping by Admin
When Admin chooses the option Mapping QATS to Source from Admin Utils Menu
Then Admin selects "<DomainName>" and clicks on Search
And after the Admin clicks on Add Item
Then Admin selects "<sourcevalue>" and "<qatsvalue>" for "<DomainName>" and click on submit
And Admin clicks on submit on QATS vs Source Mapping Page to save the changes

Examples:
|DomainName|sourcevalue|qatsvalue|
|LOB|SFG|SFG|
|Sub LOB|Housing|Housing|
|Region|Delhi|APAC|

@Fourth
Scenario Outline: Making QATS Value Active or Inactive by Admin in Maintain QATS Value for Region and Analyst Location
When Admin clicks on Admin Utils and then Maintain QATS Value
And Admin selects a "<DomainName>"
Then Admin change the status of "<QATSValue>" Active or Inactive

Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value 1|
|Region|Sample QATS Value 1| 


@Fifth
Scenario Outline: Adding new QATS Value by Admin in Maintain QATS Value for Region and Analyst Location
When Admin clicks on Admin Utils and then Maintain QATS Value
And After selecting "<DomainName>" Admin clicks on Add Button by Admin
Then Admin Adds new "<QATSValue>" and submit

Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value|
|Region|Sample QATS Value|


@ignore
Scenario Outline: Review Date Adjustment
Given User clicks on Admin Utils and then Edit Review Date
When User enters "<AnalystCode>" and "<RatingDate>" and "<NewReviewDate>" and click on Submit Update
Then Review Date is updated successfully for all the sorted cases

Examples:
|AnalystCode|RatingDate|NewReviewDate|
|New York - 7 World Trade Center|3/18/2020|6/27/2020|
|New York - 7 World Trade Center|4/23/2020|2/12/2020|
|Remote WorkerB-USA40|3/11/2020|6/14/2020|
|Remote WorkerB-USA40|4/22/2020|2/12/2020|










 







|


  






 	
