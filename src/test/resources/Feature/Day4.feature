Feature: Test Day 4 capabilities

Background: Validate Admin Utils
When Log into QATS Application as an Admin


@First 
Scenario Outline: As a QATS admin I should be able to create a case for Day 4 Review 
When I Create Manual Case with the Rating Release Date four days prior to current date with ActionID "<ActionID>" and analystlocation "<analystloc>"
Then I should be able to search for the case with ActionID "<ActionID>" on Day4 Review screen

Examples:
|ActionID|analystloc|
|687t8778|Boston - One International Place|


@Second
Scenario Outline: As a QATS admin I should be able to assign Day 4 cases to QATS Users 
When I Create Manual Case with the Rating Release Date four days prior to current date with ActionID "<ActionID>" and analystlocation "<analystloc>"
Then I should be able to search for the case with ActionID "<ActionID>" and assign it to QATS User and confirms the same in Day four Review

Examples:
|ActionID|analystloc|
#|nkdwi7|Boston - One International Place|
|gjgu|Sydney - 1 O'Connell Street|

