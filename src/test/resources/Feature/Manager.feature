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
Scenario: Create injested review cases and validate in dashboard
When User Clicks Create QA Review
And After selecting review case and click on Create Case
Then Manager clicks on Dashboard
And Validate the created case in Dashboard

@Third
Scenario: Create Manual Cases and validate in Dashboard
When User Clicks Create QA Review
And After clicking on Create Manual Case
And After entering Manual Case fields user clicks on create case

@ignore
Scenario: Complete Questionnaire and send for Review
When User Clicks on My Work
And on Selecting a Review Case
Then After Completing the Questionnaire Click on Submit Review


@ignore
Scenario: Verify Workbaskets and case status
When Manager Goes to Dashboard
Then Manager click on Quality Review Work Queue and validate case status for any case



 

