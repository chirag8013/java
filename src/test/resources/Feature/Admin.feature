Feature: Admin functionalities

Background: Validate Admin Utils
When Log into QATS Application as an Admin


@First
Scenario Outline: As An Admin I need an utility to add key data elements like LOB and start using them on new cases
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And add a new source to qats mapping value by clicking on Add Item and selecting sourcevalue "<sourcevalue>" and qatsvalue "<qatsvalue>" for DomainName "<DomainName>" from dropdown values  
And save the changes
Then I should be able to start using the newly created <QATSValue> on new cases

Examples:
|DomainName|sourcevalue|qatsvalue|
|LOB|SFG|SFG|



@Second
Scenario Outline: As An Admin I need an utility to add key data elements like SUB-LOB and start using them on new cases
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And add a new source to qats mapping value by clicking on Add Item and selecting sourcevalue "<sourcevalue>" and qatsvalue "<qatsvalue>" for DomainName "<DomainName>" from dropdown values  
And save the changes
Then I should be able to start using the newly created <QATSValue> on new cases

Examples:
|DomainName|sourcevalue|qatsvalue|
|Sub LOB|Housing|Housing|



@Third
Scenario Outline: As An Admin I need an utility to add key data elements like REGION and start using them on new cases
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And add a new source to qats mapping value by clicking on Add Item and selecting sourcevalue "<sourcevalue>" and qatsvalue "<qatsvalue>" for DomainName "<DomainName>" from dropdown values  
And save the changes
Then I should be able to start using the newly created <QATSValue> on new cases

Examples:
|DomainName|sourcevalue|qatsvalue|
|Region|APAC|APAC|


@Fourth
Scenario Outline: As An Admin I need an utility to Delete Source-to-QATS Value Mapping for Doamin LOB
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And delete the first record with sourcevalue "<sourcevalue>"
And save the changes
Then I should not be able to view QATSValue on new cases


Examples:
|DomainName|sourcevalue|
|LOB|SFG|


@Fifth
Scenario Outline: As An Admin I need an utility to Delete Source-to-QATS Value Mapping for Domain SUB-LOB
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And delete the first record with sourcevalue "<sourcevalue>"
And save the changes
Then I should not be able to view QATSValue on new cases


Examples:
|DomainName|sourcevalue|
|Sub LOB|Housing|


@Sixth
Scenario Outline: As An Admin I need an utility to Delete Source-to-QATS Value Mapping for Domain REGION
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And delete the first record with sourcevalue "<sourcevalue>"
And save the changes
Then I should not be able to view QATSValue on new cases


Examples:
|DomainName|sourcevalue|
|Region|APAC|



@Seventh
Scenario Outline:As An Admin I need an utility to add new Region
When I choose menu option Maintain QATS Value from Admin Utilities
And Add DomainName "<DomainName>" Click on Add Button
Then new QATSValue "<QATSValue>" is created

Examples:
|DomainName|QATSValue|
|Region|Sample Region|

@Eighth
Scenario Outline:As An Admin I need an utility to add new Analyst Location
When I choose menu option Maintain QATS Value from Admin Utilities
And Add DomainName "<DomainName>" Click on Add Button
Then new QATSValue "<QATSValue>" is created

Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value|


@Ninth
Scenario Outline: Making QATS Value Active or Inactive by Admin in Maintain QATS Value for Region 
When Admin clicks on Admin Utils and then Maintain QATS Value
And Admin selects a DomainName "<DomainName>"
Then Admin change the status of QATSValue "<QATSValue>" Active or Inactive

Examples:
|DomainName|QATSValue|
|Region|Sample QATS Value 1| 

@Tenth
Scenario Outline: Making QATS Value Active or Inactive by Admin in Maintain QATS Value for Analyst Location
When Admin clicks on Admin Utils and then Maintain QATS Value
And Admin selects a DomainName "<DomainName>"
Then Admin change the status of QATSValue "<QATSValue>" Active or Inactive

Examples:
|DomainName|QATSValue|
|Analyst Location|Sample QATS Value 1|

@Eleventh
Scenario Outline: As An Admin I need an utility to change key data elements for consistency like Region with Europe mapped as US/Canada in QATS
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And change mapping of SourceValue "<SourceValue>" with QATSValue "<QATSValue>" and save changes
Then I Should be able to start using the newly mapped QATSValue with SourceValue "<SourceValue>" on new case creation


Examples:
|DomainName|SourceValue|QATSValue|
|Region|Europe|US/Canada|


@Twelfth
Scenario Outline: As An Admin I need an utility to change key data elements for consistency like Region with Europe mapped as EMEA in QATS
When I choose the Mapping QATS to Source from Admin Utils Menu
And select DomainName "<DomainName>" and click on Search button
And change mapping of SourceValue "<SourceValue>" with QATSValue "<QATSValue>" and save changes
Then I Should be able to start using the newly mapped QATSValue with SourceValue "<SourceValue>" on new case creation


Examples:
|DomainName|SourceValue|QATSValue|
|Region|Europe|EMEA|




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




