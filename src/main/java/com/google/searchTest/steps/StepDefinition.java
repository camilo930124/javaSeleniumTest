package com.google.searchTest.steps;

import com.google.searchTest.businessController.BusinessController;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.FileInputStream;
import java.util.Properties;


public class StepDefinition {

    BusinessController businessController;
    Properties prop = new Properties();

    @Before
    public void setUp(Scenario scenario){
        try{prop.load(new FileInputStream("src/main/resources/properties/config.properties"));}catch (Exception e){e.printStackTrace();}
        String path=prop.getProperty("evidencePath");

        String rawFeatureName = scenario.getId().split(";")[0].replace("-"," ");
        String scenarioName=scenario.getName();
        String featureName = rawFeatureName.substring(0, 1).toUpperCase() + rawFeatureName.substring(1);
        businessController= new BusinessController(path,featureName,scenarioName);
    }

    @After
    public void tearDown() {
        businessController.closeBrowser();
    }

    @Given("I’m on the homepage$")
    public void ImOnTheHomepage(){
        businessController.goToGoogleHome();
    }

    @When("^I type 'The name of the wind' into the search field$")
    public void iTypeTheNameOfTheWindIntoTheSearchField() {
        businessController.typeInGoogleSearchField("The name of the wind");
    }

    @And("^I click the Google Search button$")
    public void iClickTheGoogleSearchButton() {
        businessController.clickOnGoogleSearchButton();
    }

    @Then("^I go to the search results page$")
    public void iGoToTheSearchResultsPage() {
        businessController.checkGoogleResultsPage();
    }

    @And("^the first result is 'The Name of the Wind - Patrick Rothfuss'$")
    public void theFirstResultIsTheNameOfTheWindPatrickRothfuss() {
        businessController.checkFirstSearchResult("The Name of the Wind - Patrick Rothfuss");
    }

    @When("^I click on the first result link$")
    public void iClickOnTheFirstResultLink() {
        businessController.clickOnFirstSearchResult();
    }

    @Then("^I go to the 'Patrick Rothfuss - The Books' page$")
    public void iGoToThePatrickRothfussTheBooksPage() {
        businessController.compareTabURL("https://www.patrickrothfuss.com/content/books.asp");
    }
}
