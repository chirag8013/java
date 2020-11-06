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
Scenario Outline: A manager creates new Review Cases from manually entered data.
When a manager clicks Create QA Review
And clicks on Create Manual Case with "<actionid>" and "<CaseDesc>" and "<sourcename>" and "<leadanalyst>" and "<ratingactiondate>"
Then Search for Case Id in Dashboard to validate successful case creation with "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|57575|Sample Case|Pyramid|David Sweeney|1|


@Fourth
Scenario: Verify Workbaskets and case status
When Manager Goes to Dashboard
Then Manager click on Quality Review Work Queue and validate case status for any case


@Fifth
Scenario: Day 4 Review
When a manager clicks Create QA Review
And manager clicks on Create Manual Case with the Rating Release Date four days before from current date
Then manager with Case Id searches the case available for Day4 Review 

@ignore
Scenario: Complete Questionnaire and send for Review
When Manager goes to MyWork and Search for Upload Vital Record Case
And on Selecting a Review Case
Then Manager completes the questionnaire under QRS and submit


