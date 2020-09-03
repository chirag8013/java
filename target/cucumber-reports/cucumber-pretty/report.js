$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Feature/RatingReleaseDetails.feature");
formatter.feature({
  "line": 1,
  "name": "Get Rating Release Details",
  "description": "",
  "id": "get-rating-release-details",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get Rating release details from 20200505 to 20200506",
  "description": "",
  "id": "get-rating-release-details;get-rating-release-details-from-20200505-to-20200506",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Rest Get Call is made for the mentioned date",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Validate Status Line and Status Code for rating release",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Validate Body for rating release details",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Rest_Get_Call_is_made_for_the_mentioned_date()"
});
formatter.result({
  "duration": 73645670900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Status_Line_and_Status_Code_for_rating_release()"
});
formatter.result({
  "duration": 813700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_for_rating_release_details()"
});
formatter.result({
  "duration": 413590900,
  "status": "passed"
});
});