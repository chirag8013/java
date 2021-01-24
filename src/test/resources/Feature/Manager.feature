Feature: Manager functionalities

Background: Launch the browser
When Log into QATS Application as a Manager


@First
Scenario: Login as Manager
Then Manager enter MeerQATS HomePage

@Second
Scenario: A manager creates ingested review cases and validate in dashboard.
When a manager goes to Create QA Review
And selects Review Case
And Create Case
Then Manager can search for Case Id in Dashboard to validate successful case creation

@Third
Scenario Outline: A manager creates new Review Cases from manually entered data.
When a manager goes to Create QA Review
And Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and ratingactiondate "<ratingactiondate>"
Then Search for Case Id in Dashboard to validate successful case creation with actionid "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|57575|Sample Case|Pyramid|David Sweeney|1|


@Fourth
Scenario: Verify Workbaskets and case status
When Manager Goes to Dashboard
Then Manager goes to Quality Review Work Queue and validate case status for any case

@Fifth
Scenario Outline: A manager creates new Review Cases from manually entered data and validates the review date of created case
When a manager goes to Create QA Review
And Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and completeratingactiondate "<ratingactiondate>" and analystlocation "<analystloc>"
Then Search for Case Id in Dashboard to validate successful case creation with actionid "<actionid>" and confirms the correct review due date for ratingactiondate "<ratingactiondate>" and analystlocation "<analystloc>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|analystloc|
|usgu7|Sample Case|Pyramid|David Sweeney|1/15/2021|Buenos Aires - Ing. Butty 240|


@ignore
Scenario Outline: Day 4 Review
When a manager goes to Create QA Review
And manager Create Manual Case with the Rating Release Date four days before from current date with case id "<CaseId>"
Then manager with CaseId "<CaseId>" searches the case available for Day4 Review 

Examples:
|CaseId|
|8877898|


@ignore
Scenario: Complete Questionnaire and send for Review
When Manager goes to MyWork and Search for Upload Vital Record Case
And on Selecting a Review Case
Then Manager completes the questionnaire under QRS and submit



