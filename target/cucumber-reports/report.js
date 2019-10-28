$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("GoogleSearch.feature");
formatter.feature({
  "line": 1,
  "name": "Google Homepage Search",
  "description": "",
  "id": "google-homepage-search",
  "keyword": "Feature"
});
formatter.before({
  "duration": 3417269200,
  "status": "passed"
});
formatter.scenario({
  "line": 4,
  "name": "User can search with \u0027Google Search\u0027",
  "description": "",
  "id": "google-homepage-search;user-can-search-with-\u0027google-search\u0027",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 3,
      "name": "@GoogleSearch"
    }
  ]
});
formatter.step({
  "line": 5,
  "name": "I’m on the homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 6,
  "name": "I type \u0027The name of the wind\u0027 into the search field",
  "keyword": "When "
});
formatter.step({
  "line": 7,
  "name": "I click the Google Search button",
  "keyword": "And "
});
formatter.step({
  "line": 8,
  "name": "I go to the search results page",
  "keyword": "Then "
});
formatter.step({
  "line": 9,
  "name": "the first result is \u0027The Name of the Wind - Patrick Rothfuss\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 10,
  "name": "I click on the first result link",
  "keyword": "When "
});
formatter.step({
  "line": 11,
  "name": "I go to the \u0027Patrick Rothfuss - The Books\u0027 page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.ImOnTheHomepage()"
});
formatter.result({
  "duration": 10170448500,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iTypeTheNameOfTheWindIntoTheSearchField()"
});
formatter.result({
  "duration": 1211993600,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iClickTheGoogleSearchButton()"
});
formatter.result({
  "duration": 1202513000,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iGoToTheSearchResultsPage()"
});
formatter.result({
  "duration": 1082482800,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.theFirstResultIsTheNameOfTheWindPatrickRothfuss()"
});
formatter.result({
  "duration": 45265100,
  "error_message": "org.junit.ComparisonFailure: the result was \u0027The Name of the Wind - Wikipedia\u0027 but the expected is \u0027The Name of the Wind - Patrick Rothfuss\u0027. expected:\u003c... Name of the Wind - [Wikipedia]\u003e but was:\u003c... Name of the Wind - [Patrick Rothfuss]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat com.google.searchTest.businessController.BusinessController.checkFirstSearchResult(BusinessController.java:103)\r\n\tat com.google.searchTest.steps.StepDefinition.theFirstResultIsTheNameOfTheWindPatrickRothfuss(StepDefinition.java:76)\r\n\tat ✽.And the first result is \u0027The Name of the Wind - Patrick Rothfuss\u0027(GoogleSearch.feature:9)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDefinition.iClickOnTheFirstResultLink()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.iGoToThePatrickRothfussTheBooksPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4685280200,
  "status": "passed"
});
formatter.before({
  "duration": 21709400,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "User can search by using the suggestions",
  "description": "",
  "id": "google-homepage-search;user-can-search-by-using-the-suggestions",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 13,
      "name": "@GoogleSearch"
    }
  ]
});
formatter.step({
  "line": 16,
  "name": "I’m on the homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 17,
  "name": "I type \u0027The name of the w\u0027 into the search field",
  "keyword": "When "
});
formatter.step({
  "line": 18,
  "name": "the suggestions list is displayed",
  "keyword": "And "
});
formatter.step({
  "line": 19,
  "name": "I click on the first suggestion in the list",
  "keyword": "And "
});
formatter.step({
  "line": 20,
  "name": "I go to the search results page",
  "keyword": "Then "
});
formatter.step({
  "line": 21,
  "name": "the first result is \u0027The Name of the Wind - Patrick Rothfuss\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 22,
  "name": "I click on the first result link",
  "keyword": "When "
});
formatter.step({
  "line": 23,
  "name": "I go to the \u0027Patrick Rothfuss - The Books\u0027 page",
  "keyword": "Then "
});
formatter.match({
  "location": "StepDefinition.ImOnTheHomepage()"
});
formatter.result({
  "duration": 7148280400,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iTypeTheNameOfTheWIntoTheSearchField()"
});
formatter.result({
  "duration": 190627900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.theSuggestionsListIsDisplayed()"
});
formatter.result({
  "duration": 961881900,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iClickOnTheFirstSuggestionInTheList()"
});
formatter.result({
  "duration": 1601946100,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.iGoToTheSearchResultsPage()"
});
formatter.result({
  "duration": 665617200,
  "status": "passed"
});
formatter.match({
  "location": "StepDefinition.theFirstResultIsTheNameOfTheWindPatrickRothfuss()"
});
formatter.result({
  "duration": 41278400,
  "error_message": "org.junit.ComparisonFailure: the result was \u0027The Name of the Wind - Wikipedia\u0027 but the expected is \u0027The Name of the Wind - Patrick Rothfuss\u0027. expected:\u003c... Name of the Wind - [Wikipedia]\u003e but was:\u003c... Name of the Wind - [Patrick Rothfuss]\u003e\r\n\tat org.junit.Assert.assertEquals(Assert.java:115)\r\n\tat com.google.searchTest.businessController.BusinessController.checkFirstSearchResult(BusinessController.java:103)\r\n\tat com.google.searchTest.steps.StepDefinition.theFirstResultIsTheNameOfTheWindPatrickRothfuss(StepDefinition.java:76)\r\n\tat ✽.And the first result is \u0027The Name of the Wind - Patrick Rothfuss\u0027(GoogleSearch.feature:21)\r\n",
  "status": "failed"
});
formatter.match({
  "location": "StepDefinition.iClickOnTheFirstResultLink()"
});
formatter.result({
  "status": "skipped"
});
formatter.match({
  "location": "StepDefinition.iGoToThePatrickRothfussTheBooksPage()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "duration": 4795032400,
  "status": "passed"
});
});