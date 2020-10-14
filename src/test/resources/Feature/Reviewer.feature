Feature: Reviewer functionalities

Background: Launch the browser
Given User Launch Chrome Browser
When User enter the the MeerQATS login page
And After Verifying login page title
And Reviewer enters Username and Password and click login


@First
Scenario: Login as Reviewer
Then Reviewer enter MeerQATS HomePage

@Second
Scenario: A reviewer creates new Review Cases Manually entered data.
When a reviewer clicks Create Manual Case
And enters required fields
And clicks on Create Case
Then searches for Case Id in My Work to validate successful case creation

@ignore
Scenario: Complete Questionnaire and send for Review
When Reviewer Clicks on My Work
And on Selecting a Review Case
Then Reviewer completes the Questionnaire Click on Submit Review
