Feature: Day 4 Review functionalities

Background: Validate Day 4
When User enter the valid credentials that maps to Admin role in QATS
And is able to view the Admin Landing page
And I am able to login to QATS as an Admin

@First
Scenario Outline: Create a case for Day 4 Review and validate it's presence under Day 4 Review Column
When an Admin clicks Create QA Review
And Admin clicks on Create Manual Case with the Rating Release Date four days before from current date with ActionID "<ActionID>"
Then Admin with ActionID "<ActionID>" searches the case available for Day4 Review 

Examples:
|ActionID|
|6868686|

@Second
Scenario Outline: Create a case for Day 4 Review and assign it to QATS User
When an Admin clicks Create QA Review
And Admin clicks on Create Manual Case with the Rating Release Date four days before from current date with ActionID "<ActionID>"
Then Admin Searches for the case with ActionID "<ActionID>" created in Dashboard and assign it to QATS User 

Examples:
|ActionID|
|868877|


