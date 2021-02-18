Feature: Manager functionalities

Background: Launch the browser
When Log into QATS Application as a Manager


@First@Manager
Scenario: Login as Manager
Then Manager enter MeerQATS HomePage

@Second@Manager
Scenario: A manager creates ingested review cases and validate in dashboard.
When a manager goes to Create QA Review
And selects Review Case
And Create Case
Then Manager can search for Case Id in Dashboard to validate successful case creation

@Third@Manager
Scenario Outline: A manager creates new Review Cases from manually entered data.
When a manager goes to Create QA Review
And Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and ratingactiondate "<ratingactiondate>"
Then Search for Case Id in Dashboard to validate successful case creation with actionid "<actionid>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|
|57575|Sample Case|Pyramid|David Sweeney|1|


@Fourth@Manager
Scenario: Verify Workbaskets and case status
When Manager Goes to Dashboard
Then Manager goes to Quality Review Work Queue and validate case status for any case


@Fifth@Manager
Scenario Outline: A manager creates new Review Cases from manually entered data and validates the review date of created case
When a manager goes to Create QA Review
And Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and completeratingactiondate "<ratingactiondate>" and analystlocation "<analystloc>"
Then Search for Case Id in Dashboard to validate successful case creation with actionid "<actionid>" and confirms the correct review due date for ratingactiondate "<ratingactiondate>" and analystlocation "<analystloc>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|analystloc|
|Moodys Holiday 01|Moodys Holiday user story verification 01|Accurate|David Sweeney|02/12/2021|Buenos Aires - Ing. Butty 240|
|Moodys Holiday 02|Moodys Holiday user story verification 02|Accurate|David Sweeney|02/14/2021|Buenos Aires - Ing. Butty 240|
|Moodys Holiday 03|Moodys Holiday user story verification 03|Accurate|David Sweeney|02/12/2021|San Francisco - One Front Street|
|Moodys Holiday 04|Moodys Holiday user story verification 04|Pyramid|David Sweeney|02/10/2021|Tokyo - Atago Green Hills Mori Tower 20fl|
|Moodys Holiday 05|Moodys Holiday user story verification 05|Pyramid|David Sweeney|01/01/2021|Tokyo - Atago Green Hills Mori Tower 20fl|
|Moodys Holiday 06|Moodys Holiday user story verification 06|Pyramid|David Sweeney|12/30/2020|Tokyo - Atago Green Hills Mori Tower 20fl|
|Moodys Holiday 07|Moodys Holiday user story verification 07|Pyramid|David Sweeney|02/22/2021|Tokyo - Atago Green Hills Mori Tower 20fl|
|Moodys Holiday 08|Moodys Holiday user story verification 08|Pyramid|David Sweeney|01/09/2021|Tokyo - Atago Green Hills Mori Tower 20fl|
|Moodys Holiday 09|Moodys Holiday user story verification 09|Pyramid|David Sweeney|01/05/2021|Stockholm- Norrlandsgatan 20|
|Moodys Holiday 10|Moodys Holiday user story verification 10|ORP|David Sweeney|12/30/2020|Stockholm- Norrlandsgatan 20|











@ignore@Manager
Scenario Outline: Day 4 Review
When a manager goes to Create QA Review
And manager Create Manual Case with the Rating Release Date four days before from current date with case id "<CaseId>"
Then manager with CaseId "<CaseId>" searches the case available for Day4 Review 

Examples:
|CaseId|
|8877898|


@ignore@Manager
Scenario: Complete Questionnaire and send for Review
When Manager goes to MyWork and Search for Upload Vital Record Case
And on Selecting a Review Case
Then Manager completes the questionnaire under QRS and submit



