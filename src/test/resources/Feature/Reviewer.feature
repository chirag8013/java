Feature: Reviewer functionalities


@First
Scenario: Login as Reviewer
When Log into QATS Application as a Reviewer
And access MeerQATS HomePage


@Second
Scenario Outline: A reviewer creates Manual Case
When Log into QATS Application as a Reviewer
When As a Reviewer I choose Create Manual Case option from menu
And enter required fields actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and ratingactiondate "<ratingactiondate>"
And save by clicking on Create Case
Then I should be able to find the newly created case on <My Work> and validate successful case creation with actionid "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|7766|US 749 Day 3 email check_1|Accurate|David Sweeney|1|



@ignore
Scenario: As a Reviewer I Should be able to Complete the Questionnaire and submit it for Review
When Log into QATS Application as a Reviewer
When As a Reviewer I choose <My Work> And chooseReview a case by clicking on to <Review Case> otopn
Then I complete the questionnaire by tabbing through nine sections
And completes the questionnaire by answering all the questions
And Submit it for Review by clicking on <Submit> button


@DAY4
Scenario Outline: As a QATS admin I should be able to assign Day 4 cases to QATS Users 
Given Log into QATS Application as an Admin
When I Create Manual Case with the Rating Release Date four days prior to current date with ActionID "<ActionID>" and analystlocation "<analystloc>"
Then I should be able to search for the case with ActionID "<ActionID>" and assign it to QATS User and confirms the same in Day four Review
And Reviewer confirms the case in Day four Review with ActionID "<ActionID>"

Examples:
|ActionID|analystloc|
|Case check 01|Buenos Aires - Ing. Butty 240|






@manual
Scenario Outline: As a Reviewer I will be able to see the the Manually created Cases Assigned to me by Manager in My Work
Given Log into QATS Application as a Manager
When a manager goes to Create QA Review
And Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and ratingactiondate "<ratingactiondate>"
Then I should be able to search for the case with ActionID "<actionid>" and assign it to QATS User 
And Reviewer confirms the case in My Work with ActionID "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|pjjo7|Sample Case|Pyramid|David Sweeney|1|


@Ingested
Scenario: As a Reviewer I will be able to see the the Ingested Cases Assigned to me by Manager in My Work
Given Log into QATS Application as a Manager
When a manager goes to Create QA Review
And selects Review Case
And Create Case
Then I should be able to search for the case with ActionID <actionid> and assign it to QATS User 
And Reviewer confirms the case in My Work with ActionID <actionid>







