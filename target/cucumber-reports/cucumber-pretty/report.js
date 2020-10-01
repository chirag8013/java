$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/main/java/Feature/ACCURATE_NEW.feature");
formatter.feature({
  "line": 1,
  "name": "Get Rating Actions For Accurate",
  "description": "",
  "id": "get-rating-actions-for-accurate",
  "keyword": "Feature"
});
formatter.scenario({
  "line": 2,
  "name": "User calls web service to get rating actions for Accurate",
  "description": "",
  "id": "get-rating-actions-for-accurate;user-calls-web-service-to-get-rating-actions-for-accurate",
  "type": "scenario",
  "keyword": "Scenario"
});
formatter.step({
  "line": 3,
  "name": "web service returns rating actions for RatingRelInfoAccurate between dates 20200923 and 20200925",
  "keyword": "Given "
});
formatter.step({
  "line": 4,
  "name": "a user requests for rating release data for Accurate by Dates",
  "keyword": "When "
});
formatter.step({
  "line": 5,
  "name": "the status code is 200",
  "keyword": "Then "
});
formatter.step({
  "line": 6,
  "name": "response includes the following",
  "rows": [
    {
      "cells": [
        "ratingActionID",
        "3371271"
      ],
      "line": 7
    },
    {
      "cells": [
        "analystLocation",
        "New York - 7 World Trade Center"
      ],
      "line": 8
    }
  ],
  "keyword": "And "
});
formatter.step({
  "line": 9,
  "name": "response includes the following in any order",
  "rows": [
    {
      "cells": [
        "ratingActionName",
        "Caja Rural de Navarra - Mortgage Covered Bonds"
      ],
      "line": 10
    },
    {
      "cells": [
        "officeName",
        "Moody\u0027s Deutschland GmbH"
      ],
      "line": 11
    }
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "20200923",
      "offset": 75
    },
    {
      "val": "20200925",
      "offset": 88
    }
  ],
  "location": "ACCURATE_NEW.web_service_returns_rating_actions_for_RatingRelInfoAccurate_between_dates_and(int,int)"
});
formatter.result({
  "duration": 660777120100,
  "status": "passed"
});
formatter.match({
  "location": "ACCURATE_NEW.a_user_requests_for_rating_release_data_for_Accurate_by_Dates()"
});
formatter.result({
  "duration": 880883000,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "200",
      "offset": 19
    }
  ],
  "location": "ACCURATE_NEW.the_status_code_is(int)"
});
formatter.result({
  "duration": 49512700,
  "status": "passed"
});
formatter.match({
  "location": "ACCURATE_NEW.response_includes_the_following(String,String\u003e)"
});
formatter.result({
  "duration": 1548306400,
  "status": "passed"
});
formatter.match({
  "location": "ACCURATE_NEW.response_includes_the_following_in_any_order(String,String\u003e)"
});
formatter.result({
  "duration": 288691100,
  "status": "passed"
});
});