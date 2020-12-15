Feature: Admin functionalities

Background: Validate Admin Utils
When Log into QATS Application as an Admin


@First
Scenario Outline: As An Admin I need an utility to change key data elements for consistency like LOB, SUB-LOB or Region
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And change mapping of SourceValue "<SourceValue>" with QATSValue "<QATSValue>" and save changes
Then I Should be able to start using the newly mapped QATSValue "<QATSValue>" on new case creation


Examples:
|DomainName|SourceValue|QATSValue|
|Region|Europe|US/Canada|
|Region|Europe|EMEA|


@Second
Scenario Outline: As An Admin I need an utility to add key data elements like LOB, SUB-LOB or Region and start using them on new cases
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And add a new source to qats mapping value by clicking on Add Item and selecting sourcevalue "<sourcevalue>" and qatsvalue "<qatsvalue>" for DomainName "<DomainName>" from dropdown values  
And save the changes
Then I should be able to start using the newly created <QATSValue> on new cases

Examples:
|DomainName|sourcevalue|qatsvalue|
|LOB|SFG|SFG|
|Sub LOB|Housing|Housing|
|Region|APAC|APAC|


@Third
Scenario Outline: As An Admin I need an utility to Delete Source-to-QATS Value Mapping 
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And delete the first record with sourcevalue "<sourcevalue>"
And save the changes
Then I should not be able to view QATSValue on new cases


Examples:
|DomainName|sourcevalue|
|LOB|SFG|
|Sub LOB|Housing|
|Region|APAC|



@Fourth
Scenario Outline:As An Admin I need an utility to add new Regions and Analyst Locations
When I choose menu option Maintain QATS Value from Admin Utilities
And Add DomainName "<DomainName>" Click on Add Button
Then new QATSValue "<QATSValue>" is created

Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value|
|Region|Sample Region|

@Fifth
Scenario Outline: Making QATS Value Active or Inactive by Admin in Maintain QATS Value for Region and Analyst Location
When Admin clicks on Admin Utils and then Maintain QATS Value
And Admin selects a DomainName "<DomainName>"
Then Admin change the status of QATSValue "<QATSValue>" Active or Inactive

Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value 1|
|Region|Sample QATS Value 1| 


@ignore
Scenario Outline: As an Admin I should be able to adjust or change review Date for an Analyst Location
Given I am able to access the Edit Review Date button from Admin Utils Page
And Provide the AnalystLocation "<AnalystLocation>" and RatingDate "<RatingDate>" and NewReviewDate "<NewReviewDate>" and save changes
Then Review Date is updated to "<NewReviewDate>" for all the sorted cases

Examples:
|AnalystLocation|RatingDate|NewReviewDate|
|New York - 7 World Trade Center|3/18/2020|6/27/2020|
|New York - 7 World Trade Center|4/23/2020|2/12/2020|
|Remote WorkerB-USA40|3/11/2020|6/14/2020|
|Remote WorkerB-USA40|4/22/2020|2/12/2020|




