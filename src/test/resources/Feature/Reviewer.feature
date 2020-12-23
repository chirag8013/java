Feature: Reviewer functionalities

Background: Validate Admin Utils
When Log into QATS Application as a Reviewer


@First
Scenario: Login as Reviewer
And access MeerQATS HomePage


@Second
Scenario Outline: A reviewer creates Manual Case
When As a Reviewer I choose Create Manual Case option from menu
And enter required fields actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and ratingactiondate "<ratingactiondate>"
And save by clicking on Create Case
Then I should be able to find the newly created case on <My Work> and validate successful case creation with actionid "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|54356234|US 749 Day 3 email check_1|Accurate|David Sweeney|1|



@ignore
Scenario: As a Reviewer I Should be able to Complete the Questionnaire and submit it for Review
When As a Reviewer I choose <My Work> And chooseReview a case by clicking on to <Review Case> otopn
Then I complete the questionnaire by tabbing through nine sections
And completes the questionnaire by answering all the questions
And Submit it for Review by clicking on <Submit> button

Scenario: As a Reviewer I will be able to see the the Ingested Cases Assigned to me by Manager in My Work
When Log off as Reviewer 
And Log into QATS Application as a Manager
When a manager clicks Create QA Review
And selects Review Case
And clicks on Create Case
Then Manager can search for Case Id in Dashboard to validate successful case creation
Then Manager assigns the case created to Reviewer
And Reviewer confirms the case in My Work

Scenario Outline: As a Reviewer I will be able to see the the Manually created Cases Assigned to me by Manager in My Work
When Log off as Reviewer 
And Log into QATS Application as a Manager
When a manager clicks Create QA Review
And clicks on Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and ratingactiondate "<ratingactiondate>"
Then Search for Case Id in Dashboard to validate successful case creation with actionid "<actionid>"
Then Manager assigns the case created to Reviewer
And Reviewer confirms the case in My Work

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|57575|Sample Case|Pyramid|David Sweeney|1|


Scenario Outline: As a QATS admin I should be able to assign Day 4 cases to QATS Users 
When Log off as Reviewer 
And Log into QATS Application as an Admin
When I Create Manual Case with the Rating Release Date four days prior to current date with ActionID "<ActionID>"
Then I should be able to search for the case with ActionID "<ActionID>" and assign it to QATS User 
Then Admin assigns the case created to Reviewer
And Reviewer confirms the case in My Work

Examples:
|ActionID|
|868877|





