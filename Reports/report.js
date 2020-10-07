$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/Feature/Manager.feature");
formatter.feature({
  "name": "Manager functionalities",
  "description": "",
  "keyword": "Feature"
});
formatter.background({
  "name": "Launch the browser",
  "description": "",
  "keyword": "Background"
});
formatter.step({
  "name": "User Launch Chrome Browser",
  "keyword": "Given "
});
formatter.match({
  "location": "com.moodys.qats.stepdefinitions.Step.User_Launch_Chrome_Browser()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "User enter the the MeerQATS login page",
  "keyword": "When "
});
formatter.match({
  "location": "com.moodys.qats.stepdefinitions.Step.User_enter_the_the_MeerQATS_login_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "After Verifying login page title",
  "keyword": "And "
});
formatter.match({
  "location": "com.moodys.qats.stepdefinitions.Step.After_Verifying_login_page_title()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "Manager enters Username and Password and click login",
  "keyword": "And "
});
formatter.match({
  "location": "com.moodys.qats.stepdefinitions.Step.Manager_enters_Username_and_Password_and_click_login()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "Login as Manager",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@First"
    }
  ]
});
formatter.step({
  "name": "Manager enter MeerQATS HomePage",
  "keyword": "Then "
});
formatter.match({
  "location": "com.moodys.qats.stepdefinitions.Step.Manager_enter_MeerQATS_HomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.after({
  "status": "passed"
});
});