$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("ACCURATE.feature");
formatter.feature({
  "line": 1,
  "name": "Test ACCURATE Rest APIs",
  "description": "",
  "id": "test-accurate-rest-apis",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 19,
  "name": "Get Rating Release Info for Accurate",
  "description": "",
  "id": "test-accurate-rest-apis;get-rating-release-info-for-accurate",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@accurate1"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Restcall is made for RatingRelInfoAccurate from \"\u003cstartdate\u003e\" to \"\u003cenddate\u003e\"",
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Validate StatusLine and StatusCode for Accurate",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "Validate Response Body from Accurate and fetch record with ratingactionid \"\u003cratingactionid\u003e\"",
  "keyword": "And "
});
formatter.examples({
  "line": 24,
  "name": "",
  "description": "",
  "id": "test-accurate-rest-apis;get-rating-release-info-for-accurate;",
  "rows": [
    {
      "cells": [
        "startdate",
        "enddate",
        "ratingactionid"
      ],
      "line": 25,
      "id": "test-accurate-rest-apis;get-rating-release-info-for-accurate;;1"
    },
    {
      "cells": [
        "20200920",
        "20200921",
        "3435686"
      ],
      "line": 26,
      "id": "test-accurate-rest-apis;get-rating-release-info-for-accurate;;2"
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
  "duration": 121503000,
  "status": "passed"
});
formatter.scenario({
  "line": 26,
  "name": "Get Rating Release Info for Accurate",
  "description": "",
  "id": "test-accurate-rest-apis;get-rating-release-info-for-accurate;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 18,
      "name": "@accurate1"
    }
  ]
});
formatter.step({
  "line": 20,
  "name": "Restcall is made for RatingRelInfoAccurate from \"20200920\" to \"20200921\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 21,
  "name": "Validate StatusLine and StatusCode for Accurate",
  "keyword": "Then "
});
formatter.step({
  "line": 22,
  "name": "Validate Response Body from Accurate and fetch record with ratingactionid \"3435686\"",
  "matchedColumns": [
    2
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20200920",
      "offset": 49
    },
    {
      "val": "20200921",
      "offset": 63
    }
  ],
  "location": "Steps.restcall_is_made_for_RatingRelInfoAccurate_from_to(String,String)"
});
formatter.result({
  "duration": 159862760800,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_for_Accurate()"
});
formatter.result({
  "duration": 2726500,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "3435686",
      "offset": 75
    }
  ],
  "location": "Steps.validate_Response_Body_from_Accurate_and_fetch_record_with_ratingactionid(String)"
});
formatter.result({
  "duration": 7019591400,
  "status": "passed"
});
});