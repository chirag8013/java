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
|MH story 03|Holiday Calendar verification 03|Accurate|David Sweeney|12/28/2020|Dubai - DIFC Precinct Bldg 3|
|MH story 04|Holiday Calendar verification 04|Accurate|David Sweeney|02/1/2021|Dubai - DIFC Precinct Bldg 3|
|MH story 05|Holiday Calendar verification 05|Accurate|David Sweeney|02/10/2021|Buenos Aires - Ing. Butty 240|
|MH story 14|Holiday Calendar verification 14|Pyramid|David Sweeney|12/28/2020|Sydney - 1 O'Connell Street|
|MH story 15|Holiday Calendar verification 15|Pyramid|David Sweeney|12/31/2020|Sydney - 1 O'Connell Street|
|MH story 16|Holiday Calendar verification 16|Pyramid|David Sweeney|12/28/2020|Sydney - 1 O'Connell Street|
|MH story 17|Holiday Calendar verification 17|Pyramid|David Sweeney|01/22/2021|Sydney - 1 O'Connell Street|
|MH story 18|Holiday Calendar verification 18|Pyramid|David Sweeney|01/25/2021|Sydney - 1 O'Connell Street|
|MH story 19|Holiday Calendar verification 19|Pyramid|David Sweeney|01/27/2021|Sydney - 1 O'Connell Street|
|MH story 20|Holiday Calendar verification 20|Pyramid|David Sweeney|01/22/2021|Sydney - 1 O'Connell Street|
|MH story 21|Holiday Calendar verification 21|Pyramid|David Sweeney|01/20/2021|Sydney - 1 O'Connell Street|
|MH story 22|Holiday Calendar verification 22|Pyramid|David Sweeney|02/15/2021|Sydney - 1 O'Connell Street|
|MH story 23|Holiday Calendar verification 23|Pyramid|David Sweeney|01/19/2021|Sydney - 1 O'Connell Street|
|MH story 24|Holiday Calendar verification 24|Pyramid|David Sweeney|01/22/2021|Sydney - 1 O'Connell Street|
|MH story 25|Holiday Calendar verification 25|ORP|David Sweeney|12/30/2020|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 26|Holiday Calendar verification 26|ORP|David Sweeney|12/31/2020|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 27|Holiday Calendar verification 27|ORP|David Sweeney|12/28/2020|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 28|Holiday Calendar verification 28|ORP|David Sweeney|01/22/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 29|Holiday Calendar verification 29|ORP|David Sweeney|01/20/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 30|Holiday Calendar verification 30|ORP|David Sweeney|02/15/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 31|Holiday Calendar verification 31|ORP|David Sweeney|01/19/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 32|Holiday Calendar verification 32|ORP|David Sweeney|01/22/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 33|Holiday Calendar verification 33|ORP|David Sweeney|02/11/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 34|Holiday Calendar verification 34|ORP|David Sweeney|02/12/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 35|Holiday Calendar verification 35|ORP|David Sweeney|02/10/2021|Sao Paulo - Avenida das Nacoes Unidas|
|MH story 36|Holiday Calendar verification 36|Accurate|David Sweeney|02/15/2021|San Francisco - One Front Street|
|MH story 37|Holiday Calendar verification 37|Accurate|David Sweeney|02/12/2021|San Francisco - One Front Street|
|MH story 38|Holiday Calendar verification 38|Accurate|David Sweeney|02/10/2021|San Francisco - One Front Street|
|MH story 39|Holiday Calendar verification 39|Accurate|David Sweeney|12/30/2020|San Francisco - One Front Street|
|MH story 40|Holiday Calendar verification 40|Accurate|David Sweeney|12/31/2020|San Francisco - One Front Street|
|MH story 41|Holiday Calendar verification 41|Accurate|David Sweeney|12/28/2020|San Francisco - One Front Street|
|MH story 42|Holiday Calendar verification 42|Accurate|David Sweeney|01/4/2021|San Francisco - One Front Street|
|MH story 43|Holiday Calendar verification 43|Accurate|David Sweeney|01/5/2021|San Francisco - One Front Street|
|MH story 44|Holiday Calendar verification 44|Accurate|David Sweeney|02/10/2021|San Francisco - One Front Street|
|MH story 45|Holiday Calendar verification 45|Accurate|David Sweeney|02/9/2021|San Francisco - One Front Street|
|MH story 46|Holiday Calendar verification 46|Accurate|David Sweeney|02/15/2021|Toronto - 70 York Street|
|MH story 47|Holiday Calendar verification 47|Accurate|David Sweeney|02/12/2021|Toronto - 70 York Street|
|MH story 48|Holiday Calendar verification 48|Accurate|David Sweeney|02/10/2021|Toronto - 70 York Street|
|MH story 49|Holiday Calendar verification 49|Pyramid|David Sweeney|12/30/2020|Toronto - 70 York Street|
|MH story 50|Holiday Calendar verification 50|Pyramid|David Sweeney|12/31/2020|Toronto - 70 York Street|
|MH story 51|Holiday Calendar verification 51|Pyramid|David Sweeney|12/28/2020|Toronto - 70 York Street|
|MH story 52|Holiday Calendar verification 52|Pyramid|David Sweeney|01/1/2021|Toronto - 70 York Street|
|MH story 53|Holiday Calendar verification 53|Pyramid|David Sweeney|01/4/2021|Toronto - 70 York Street|
|MH story 54|Holiday Calendar verification 54|Pyramid|David Sweeney|02/10/2021|Toronto - 70 York Street|
|MH story 55|Holiday Calendar verification 55|Pyramid|David Sweeney|02/9/2021|Toronto - 70 York Street|
|MH story 56|Holiday Calendar verification 56|Pyramid|David Sweeney|12/30/2020|Prague - Pernerova 691/42|
|MH story 57|Holiday Calendar verification 57|Pyramid|David Sweeney|12/31/2020|Prague - Pernerova 691/43|
|MH story 58|Holiday Calendar verification 58|Pyramid|David Sweeney|12/28/2020|Prague - Pernerova 691/44|
|MH story 59|Holiday Calendar verification 59|Pyramid|David Sweeney|12/25/2021|Prague - Pernerova 691/45|
|MH story 60|Holiday Calendar verification 60|Pyramid|David Sweeney|12/24/2021|Prague - Pernerova 691/46|



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



