Feature: Admin functionalities

Background: Launch the browser
Given User Launch Chrome Browser
When User enter the the MeerQATS login page
And After Verifying login page title
And Admin enters Username and Password and click login


@First
Scenario Outline: Change of Source-to-QATS domain value mapping by Admin
When Admin clicks on Admin Utils and then Mapping QATS vs Source
Then Admin selects "<DomainName>" and clicks on Search
And After Clicking on the Source Value and QATS value mapped Record Admin update the mapping of "<SourceValue>" with "<QATSValue>" and click submit
Then Admin clicks on submit on QATS vs Source Mapping Page to save the changes
And Go back to the Create QA Review and Select Region as "<SourceValue>" and Create the case
Then Go back to Dashboard and check the QATSValue of created case as expected


Examples:
|DomainName|SourceValue|QATSValue|
|Region|Europe|US/Canada|
|Region|Europe|EMEA|


@Second
Scenario Outline: Deletion of Source-to-QATS Value Mapping by Admin
When Admin clicks on Admin Utils and then Mapping QATS vs Source
Then Admin selects "<DomainName>" and clicks on Search
And After clicking the first record Admin clicks on delete the mapping of record  with "<sourcevalue>"and submit
Then Admin clicks on submit on QATS vs Source Mapping Page to save the changes

Examples:
|DomainName|sourcevalue|
|LOB|SFG|
|Sub LOB|Housing|
|Region|Delhi|



@Third
Scenario Outline: Addition of Source-to-QATS domain value mapping by Admin
When Admin clicks on Admin Utils and then Mapping QATS vs Source
Then Admin selects "<DomainName>" and clicks on Search
And Admin clicks on Add Item
Then Admin selects "<sourcevalue>" and "<qatsvalue>" for "<DomainName>" and click on submit
Then Admin clicks on submit on QATS vs Source Mapping Page to save the changes

Examples:
|DomainName|sourcevalue|qatsvalue|
|LOB|SFG|SFG|
|Sub LOB|Housing|Housing|
|Region|Delhi|APAC|


@Fourth
Scenario: Day 4 Review
When an Admin clicks Create QA Review
And Admin clicks on Create Manual Case with the Rating Release Date four days before from current date
Then Admin with Case Id searches the case available for Day4 Review 

@Fifth
Scenario: Day 4 Review
When an Admin clicks Create QA Review
And Admin clicks on Create Manual Case with the Rating Release Date four days before from current date
Then Admin Searches for the case created in Dashboard and assign it to QATS User 
Then QATS User login into the application and searches for the case in Day4 Review 
And after selecting the incomplete documents QATS User Sends Day4 Email 


@Sixth
Scenario Outline: Making QATS Value Active or Inactive by Admin in Maintain QATS Value for Region and Analyst Location
When Admin clicks on Admin Utils and then Maintain QATS Value
And Admin selects a "<DomainName>"
Then Admin change the status of "<QATSValue>" Active or Inactive

 Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value 1|
|Region|Sample QATS Value 1| 


@Sixth
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


  






 	
