$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Feature/PYRAMID.feature");
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
        "20200511",
        "20200512"
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
  "duration": 113430500,
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
  "duration": 56890741700,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_for_Pyramid()"
});
formatter.resultformatter.result({
  "duration": 343266971200,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_StatusLine_and_StatusCode_for_Accurate()"
});
formatter.result({
  "duration": 1603900,
  "status": "passed"
});
formatter.match({
  "location": "Steps.Validate_Body_for_Accurate()"
});
formatter.result({
  "duration": 1264776100,
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
  "duration": 503600,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "Get Rating Release Info for Accurate",
  "description": "",
  "id": "test-accurate-rest-apis;get-rating-release-info-for-accurate;;3",
  "type": "scenario",
  "keyword": "Scenario Outline"
});
formatter.step({
  "line": 7,
  "name": "Restcall is made for RatingRelInfoAccurate from \"20200511\" to \"20200512\"",
  "matchedColumns": [
    0,
    1
  ],
  "keyword": "When "
});
formatter.step({
  "line": 8,
  "name": "Validate StatusLine and StatusCode for Accurate",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "Validate Body for Accurate",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20200511",
      "offset": 49
    },
    {
      "val": "20200512",
      "offset": 63
    }
  ],
  "location": "Steps.restcall_is_made_for_RatingRelInfoAccurate_from_to(String,String)"
});
 "status": "passed"
});
});