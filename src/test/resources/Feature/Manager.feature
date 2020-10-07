Feature: Manager functionalities

Background: Launch the browser
Given User Launch Chrome Browser
When User enter the the MeerQATS login page
And After Verifying login page title
And Manager enters Username and Password and click login


@First
Scenario: Login as Manager
Then Manager enter MeerQATS HomePage

@Second
Scenario: A manager creates ingested review cases and validate in dashboard.
When a manager clicks Create QA Review
And selects Review Case
And clicks on Create Case
Then Manager can search for Case Id in Dashboard to validate successful case creation

@Third
Scenario: A manager creates new Review Cases from manually entered data.
When a manager clicks Create QA Review
And clicks on Create Manual Case
Then Search for Case Id in Dashboard to validate successful case creation

@ignore
Scenario: Complete Questionnaire and send for Review
When User Clicks on My Work
And on Selecting a Review Case
Then After Completing the Questionnaire Click on Submit Review


@ignore
Scenario: Verify Workbaskets and case status
When Manager Goes to Dashboard
Then Manager click on Quality Review Work Queue and validate case status for any case



 

