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
|Holiday001|Holiday user story verification 1|Accurate|David Sweeney|01/1/2021|Buenos Aires - Ing. Butty 240|
|Holiday002|Holiday user story verification 2|Accurate|David Sweeney|01/8/2021|Buenos Aires - Ing. Butty 240|
|Holiday003|Holiday user story verification 3|Accurate|David Sweeney|01/11/2021|San Francisco - One Front Street|
|Holiday004|Holiday user story verification 4|Accurate|David Sweeney|01/22/2021|London - One Canada Square|
|Holiday005|Holiday user story verification 5|Accurate|David Sweeney|01/22/2021|London - One Canada Square|
|Holiday006|Holiday user story verification 6|Accurate|David Sweeney|01/9/2021|Frankfurt - An der Welle 5|
|Holiday007|Holiday user story verification 7|Accurate|David Sweeney|01/10/2021|Frankfurt - An der Welle 5|
|Holiday008|Holiday user story verification 8|Accurate|David Sweeney|01/1/2021|Milan - Corso di Porta Romana 68|
|Holiday009|Holiday user story verification 9|Accurate|David Sweeney|01/24/2021|Milan - Corso di Porta Romana 68|
|Holiday010|Holiday user story verification 10|Accurate|David Sweeney|01/7/2021|Milan - Corso di Porta Romana 68|
|Holiday011|Holiday user story verification 11|Accurate|David Sweeney|01/16/2021|Boston - One International Place|
|Holiday012|Holiday user story verification 12|Accurate|David Sweeney|01/17/2021|Boston - One International Place|
|Holiday013|Holiday user story verification 13|Accurate|David Sweeney|01/24/2021|Boston - One International Place|
|Holiday014|Holiday user story verification 14|Accurate|David Sweeney|01/10/2021|Madrid - Calle Principe de Vergara, 131|
|Holiday015|Holiday user story verification 15|Accurate|David Sweeney|01/24/2021|Madrid - Calle Principe de Vergara, 131|
|Holiday016|Holiday user story verification 16|Accurate|David Sweeney|01/2/2021|Madrid - Calle Principe de Vergara, 131|
|Holiday017|Holiday user story verification 17|Accurate|David Sweeney|01/13/2021|Moscow - Four Winds Plaza|
|Holiday018|Holiday user story verification 18|Accurate|David Sweeney|01/16/2021|Moscow - Four Winds Plaza|
|Holiday019|Holiday user story verification 19|Accurate|David Sweeney|01/9/2021|Moscow - Four Winds Plaza|
|Holiday020|Holiday user story verification 20|Accurate|David Sweeney|01/8/2021|Sydney - 1 O'Connell Street|
|Holiday021|Holiday user story verification 21|Accurate|David Sweeney|01/2/2021|Sydney - 1 O'Connell Street|
|Holiday022|Holiday user story verification 22|Accurate|David Sweeney|01/24/2021|Sydney - 1 O'Connell Street|
|Holiday023|Holiday user story verification 23|Accurate|David Sweeney|01/24/2021|Sydney - 1 O'Connell Street|
|Holiday024|Holiday user story verification 24|Accurate|David Sweeney|01/1/2021|New York - 7 World Trade Center|
|Holiday025|Holiday user story verification 25|Accurate|David Sweeney|01/4/2021|New York - 7 World Trade Center|
|Holiday026|Holiday user story verification 26|Accurate|David Sweeney|01/8/2021|New York - 7 World Trade Center|
|Holiday027|Holiday user story verification 27|Accurate|David Sweeney|01/4/2021|Toronto - 70 York Street|
|Holiday028|Holiday user story verification 28|Accurate|David Sweeney|01/30/2021|Toronto - 70 York Street|
|Holiday029|Holiday user story verification 29|Accurate|David Sweeney|01/4/2021|Toronto - 70 York Street|
|Holiday030|Holiday user story verification 30|Accurate|David Sweeney|01/21/2021|Sao Paulo - Avenida das Nacoes Unidas|
|Holiday031|Holiday user story verification 31|Accurate|David Sweeney|01/7/2021|Sao Paulo - Avenida das Nacoes Unidas|

@Sixth
Scenario Outline: A manager creates new Review Cases from manually entered data and validates the review date of created case
When a manager goes to Create QA Review
And Create Manual Case with actionid "<actionid>" and CaseDesc "<CaseDesc>" and sourcename "<sourcename>" and leadanalyst "<leadanalyst>" and completeratingactiondate "<ratingactiondate>" and analystlocation "<analystloc>"
Then Search for Case Id in Dashboard to validate successful case creation with actionid "<actionid>" and confirms the correct review due date for ratingactiondate "<ratingactiondate>" and analystlocation "<analystloc>"

Examples:
|actionid|CaseDesc|sourcename|leadanalyst|ratingactiondate|analystloc|
|Holiday0001|Holiday user story verification 1|Accurate|David Sweeney|06/12/2019|Buenos Aires - Ing. Butty 240|
|Holiday0002|Holiday user story verification 2|Accurate|David Sweeney|06/12/2019|Buenos Aires - Ing. Butty 240|
|Holiday0003|Holiday user story verification 3|Accurate|David Sweeney|09/4/2019|San Francisco - One Front Street|
|Holiday0004|Holiday user story verification 4|Accurate|David Sweeney|12/24/2019|London - One Canada Square|
|Holiday0005|Holiday user story verification 5|Accurate|David Sweeney|05/22/2019|London - One Canada Square|
|Holiday0006|Holiday user story verification 6|Accurate|David Sweeney|04/9/2019|Frankfurt - An der Welle 5|
|Holiday0007|Holiday user story verification 7|Accurate|David Sweeney|06/10/2019|Frankfurt - An der Welle 5|
|Holiday0008|Holiday user story verification 8|Accurate|David Sweeney|06/1/2019|Milan - Corso di Porta Romana 68|
|Holiday0009|Holiday user story verification 9|Accurate|David Sweeney|12/24/2019|Milan - Corso di Porta Romana 68|
|Holiday0010|Holiday user story verification 10|Accurate|David Sweeney|12/7/2019|Milan - Corso di Porta Romana 68|
|Holiday0011|Holiday user story verification 11|Accurate|David Sweeney|03/16/2019|Boston - One International Place|
|Holiday0012|Holiday user story verification 12|Accurate|David Sweeney|04/17/2019|Boston - One International Place|
|Holiday0013|Holiday user story verification 13|Accurate|David Sweeney|11/24/2019|Boston - One International Place|
|Holiday0014|Holiday user story verification 14|Accurate|David Sweeney|11/10/2019|Madrid - Calle Principe de Vergara, 131|
|Holiday0015|Holiday user story verification 15|Accurate|David Sweeney|11/24/2019|Madrid - Calle Principe de Vergara, 131|
|Holiday0016|Holiday user story verification 16|Accurate|David Sweeney|07/2/2019|Madrid - Calle Principe de Vergara, 131|
|Holiday0017|Holiday user story verification 17|Accurate|David Sweeney|02/13/2019|Moscow - Four Winds Plaza|
|Holiday0018|Holiday user story verification 18|Accurate|David Sweeney|01/16/2019|Moscow - Four Winds Plaza|
|Holiday0019|Holiday user story verification 19|Accurate|David Sweeney|11/9/2019|Moscow - Four Winds Plaza|
|Holiday0020|Holiday user story verification 20|Accurate|David Sweeney|04/8/2019|Sydney - 1 O'Connell Street|
|Holiday0021|Holiday user story verification 21|Accurate|David Sweeney|10/2/2019|Sydney - 1 O'Connell Street|
|Holiday0022|Holiday user story verification 22|Accurate|David Sweeney|12/24/2019|Sydney - 1 O'Connell Street|
|Holiday0023|Holiday user story verification 23|Accurate|David Sweeney|01/24/2019|Sydney - 1 O'Connell Street|
|Holiday0024|Holiday user story verification 24|Accurate|David Sweeney|11/1/2019|New York - 7 World Trade Center|
|Holiday0025|Holiday user story verification 25|Accurate|David Sweeney|09/4/2019|New York - 7 World Trade Center|
|Holiday0026|Holiday user story verification 26|Accurate|David Sweeney|10/8/2019|New York - 7 World Trade Center|
|Holiday0027|Holiday user story verification 27|Accurate|David Sweeney|04/4/2019|Toronto - 70 York Street|
|Holiday0028|Holiday user story verification 28|Accurate|David Sweeney|06/30/2019|Toronto - 70 York Street|
|Holiday0029|Holiday user story verification 29|Accurate|David Sweeney|09/4/2019|Toronto - 70 York Street|
|Holiday0030|Holiday user story verification 30|Accurate|David Sweeney|02/21/2019|Sao Paulo - Avenida das Nacoes Unidas|
|Holiday0031|Holiday user story verification 31|Accurate|David Sweeney|07/7/2019|Sao Paulo - Avenida das Nacoes Unidas|
|Holiday0032|Holiday user story verification 32|Accurate|David Sweeney|07/3/2019|Dallas - Plaza Of The Americas|
|Holiday0033|Holiday user story verification 33|Accurate|David Sweeney|04/20/2019|Dallas - Plaza Of The Americas|
|Holiday0034|Holiday user story verification 34|Accurate|David Sweeney|02/13/2019|Dallas - Plaza Of The Americas|
|Holiday0035|Holiday user story verification 35|Accurate|David Sweeney|03/20/2019|Tokyo - Atago Green Hills Mori Tower 20fl|
|Holiday0036|Holiday user story verification 36|Accurate|David Sweeney|01/10/2019|Tokyo - Atago Green Hills Mori Tower 20fl|
|Holiday0037|Holiday user story verification 37|Accurate|David Sweeney|02/20/2019|Tokyo - Atago Green Hills Mori Tower 20fl|
|Holiday0038|Holiday user story verification 38|Accurate|David Sweeney|04/8/2019|Stockholm- Norrlandsgatan 20|
|Holiday0039|Holiday user story verification 39|Accurate|David Sweeney|10/29/2019|Stockholm- Norrlandsgatan 20|
|Holiday0040|Holiday user story verification 40|Accurate|David Sweeney|04/4/2019|Stockholm- Norrlandsgatan 20|
|Holiday0041|Holiday user story verification 41|Accurate|David Sweeney|07/27/2019|Singapore - 50 Raffles Place #23-06|
|Holiday0042|Holiday user story verification 42|Accurate|David Sweeney|05/20/2019|Singapore - 50 Raffles Place #23-06|
|Holiday0043|Holiday user story verification 43|Accurate|David Sweeney|08/5/2019|Singapore - 50 Raffles Place #23-06|
|Holiday0044|Holiday user story verification 44|Accurate|David Sweeney|10/27/2019|Prague - Pernerova 691/42|
|Holiday0045|Holiday user story verification 45|Accurate|David Sweeney|07/2/2019|Prague - Pernerova 691/42|
|Holiday0046|Holiday user story verification 46|Accurate|David Sweeney|05/6/2019|Paris - 96, boulevard Haussmann|
|Holiday0047|Holiday user story verification 47|Accurate|David Sweeney|08/13/2019|Paris - 19 boulevard Malesherbes|
|Holiday0048|Holiday user story verification 48|Accurate|David Sweeney|07/13/2019|Paris - 19 boulevard Malesherbes|



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



