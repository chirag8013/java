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

