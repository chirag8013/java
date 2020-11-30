Feature: Question, Observation  & Remediation Maintenance

Background: Validate Admin Utils
When User enter the valid credentials that maps to Admin role in QATS
And is able to view the Admin Landing page
And I am able to login to QATS as an Admin

@FIRST
Scenario: Questions Maintainance
Given As QATS Admin I will be needing to perform Periodic Questionnaire Maintainance
Then I Need to be able to add or remove questions 
And or change the Observations
And or change the wording of the questions

@SECOND
Scenario: Remediation Maintainance
Given As part of the Remediation Maintainance
Then I need to be able to add or remove Remediations
And change the wording of the Remediations 




