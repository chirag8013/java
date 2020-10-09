Feature: Admin functionalities

Background: Launch the browser
Given User Launch Chrome Browser
When User enter the the MeerQATS login page
And After Verifying login page title
And Admin enters Username and Password and click login


@Second
Scenario Outline: Updation of Source Value and QATS Value Mapping by Admin 
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


@Third
Scenario Outline: Deletion of Source Value and QATS Value Mapping by Admin 
When Admin clicks on Admin Utils and then Mapping QATS vs Source
Then Admin selects "<DomainName>" and clicks on Search
And After clicking the first record Admin clicks on delete the mapping of record  with "<sourcevalue>"and submit
Then Admin clicks on submit on QATS vs Source Mapping Page to save the changes

Examples:
|DomainName|sourcevalue|
|LOB|SFG|
|Sub LOB|Housing|
|Region|Delhi|



@Fourth
Scenario Outline: Addition of Source Value and QATS Value Mapping by Admin 
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




  






 	