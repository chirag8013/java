$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ACCURATE.feature");
formatter.feature({
  "line": 1,
  "name": "Test ACCURATE Rest APIs",
  "description": "",
  "id": "test-accurate-rest-apis",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get Rating Release Info Accurate",
  "description": "",
  "id": "test-accurate-rest-apis;get-rating-release-info-accurate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Restcall is made for RatingRelInfoAccurate",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Validate StatusLine and StatusCode Accurate",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Validate Body Accurate",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Restcall_is_made_for_RatingRelInfoAccurate()"
});
formatter.result({
  "duration": 250260305000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_Accurate()"
});
formatter.result({
  "duration": 781000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_Accurate()"
});
formatter.result({
  "duration": 1106660700,
  "status": "passed"
});
formatter.uri("PYRAMID.feature");
formatter.feature({
  "line": 1,
  "name": "Test PYRAMID Rest APIs",
  "description": "",
  "id": "test-pyramid-rest-apis",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 3,
  "name": "Get Rating Release Info Pyramid",
  "description": "",
  "id": "test-pyramid-rest-apis;get-rating-release-info-pyramid",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 4,
  "name": "Restcall is made for RatingRelInfoPyrmaid",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "Validate StatusLine and StatusCode Pyramid",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "Validate Body Pyramid",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Restcall_is_made_for_RatingRelInfoPyrmaid()"
});
formatter.result({
  "duration": 55943172700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_Pyramid()"
});
formatter.result({
  "duration": 267000,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_Pyramid()"
});
formatter.result({
  "duration": 307833700,
  "status": "passed"
});
});