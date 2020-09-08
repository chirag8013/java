$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ACCURATE.feature");
formatter.feature({
  "line": 1,
  "name": "Test ACCURATE Rest APIs",
  "description": "",
  "id": "test-accurate-rest-apis",
  "keyword": "Feature"
});
formatter.uri("PYRAMID.feature");
formatter.feature({
  "line": 1,
  "name": "Test PYRAMID Rest APIs",
  "description": "",
  "id": "test-pyramid-rest-apis",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 6,
  "name": "Get Rating Release Info for Pyramid",
  "description": "",
  "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid",
  "type": "scenario_outline",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Restcall is made for RatingRelInfoPyrmaid from \"\u003cstartdate\u003e\" to \"\u003cenddate\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validate StatusLine and StatusCode for Pyramid",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate Body for Pyramid",
  "keyword": "And "
});
formatter.examples({
  "line": 11,
  "name": "",
  "description": "",
  "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid;",
  "rows": [
    {
      "cells": [
        "startdate",
        "enddate"
      ],
      "line": 12,
      "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid;;1"
    },
    {
      "cells": [
        "20200514",
        "20200515"
      ],
      "line": 13,
      "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid;;2"
    },
    {
      "cells": [
        "20200626",
        "20200627"
      ],
      "line": 14,
      "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid;;3"
    }
  ],
  "keyword": "Examples"
});
formatter.background({
  "line": 3,
  "name": "General Setup",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Basic Setup",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.Basic_Setup()"
});
formatter.result({
  "duration": 114929000,
  "status": "passed"
});
formatter.scenario({
  "line": 13,
  "name": "Get Rating Release Info for Pyramid",
  "description": "",
  "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid;;2",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Restcall is made for RatingRelInfoPyrmaid from \"20200514\" to \"20200515\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validate StatusLine and StatusCode for Pyramid",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate Body for Pyramid",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Restcall_is_made_for_RatingRelInfoPyrmaid()"
});
formatter.result({
  "duration": 56859737300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_for_Pyramid()"
});
formatter.result({
  "duration": 1046800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_for_Pyramid()"
});
formatter.result({
  "duration": 762069400,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "General Setup",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Basic Setup",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.Basic_Setup()"
});
formatter.result({
  "duration": 407300,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Get Rating Release Info for Pyramid",
  "description": "",
  "id": "test-pyramid-rest-apis;get-rating-release-info-for-pyramid;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Restcall is made for RatingRelInfoPyrmaid from \"20200626\" to \"20200627\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validate StatusLine and StatusCode for Pyramid",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate Body for Pyramid",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Restcall_is_made_for_RatingRelInfoPyrmaid()"
});
formatter.result({
  "duration": 54362729500,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_for_Pyramid()"
});
formatter.result({
  "duration": 248300,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_for_Pyramid()"
});
formatter.result({
  "duration": 131508300,
  "status": "passed"
});
formatter.uri("RatingReleaseDetails.feature");
formatter.feature({
  "line": 1,
  "name": "Get Rating Release Details",
  "description": "",
  "id": "get-rating-release-details",
  "keyword": "Feature"
});
formatter.background({
  "line": 3,
  "name": "General Setup",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "Basic Setup",
  "keyword": "Given "
});
formatter.match({
  "location": "Steps.Basic_Setup()"
});
formatter.result({
  "duration": 520100,
  "status": "passed"
});
formatter.scenario({
  "line": 6,
  "name": "Get Rating release details from 20200505 to 20200506",
  "description": "",
  "id": "get-rating-release-details;get-rating-release-details-from-20200505-to-20200506",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 7,
  "name": "Rest Get Call is made for the mentioned date",
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validate Status Line and Status Code for rating release",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate Body for rating release details",
  "keyword": "And "
});
formatter.match({
  "location": "Steps.Rest_Get_Call_is_made_for_the_mentioned_date()"
});
formatter.result({
  "duration": 52631910800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Status_Line_and_Status_Code_for_rating_release()"
});
formatter.result({
  "duration": 204200,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_for_rating_release_details()"
});
formatter.result({
  "duration": 26225200,
  "status": "passed"
});
});