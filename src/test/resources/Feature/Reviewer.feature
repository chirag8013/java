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
Scenario Outline: A reviewer creates new Review Cases Manually entered data.
When a reviewer clicks Create Manual Case
And enters required fields "<actionid>" and "<CaseDesc>" and "<sourcename>" and "<leadanalyst>" and "<ratingactiondate>"
And clicks on Create Case
Then searches for Case Id in My Work to validate successful case creation with "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|54356234|US 749 Day 3 email check_1|Accurate|David Sweeney|1|

@Third
Scenario Outline: Day 4 Review
When a reviewer clicks Create Manual Case
And enters required fields with the Rating Release Date four days before from current date
And clicks on Create Case
Then Reviewer with Case Id searches the case available for Day4 Review 


@ignore
Scenario: Complete Questionnaire and send for Review
When Reviewer Clicks on My Work
And on Selecting a Review Case
Then Reviewer completes the Questionnaire Click on Submit Review


