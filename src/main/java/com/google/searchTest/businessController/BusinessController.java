package com.google.searchTest.businessController;

import com.google.searchTest.logs.Log;
import com.google.searchTest.pages.google.GoogleHome;
import com.google.searchTest.pages.google.GoogleResults;
import com.google.searchTest.webController.WebController;
import org.junit.Assert;
import org.openqa.selenium.support.PageFactory;

public class BusinessController {
    public static WebController webActions;
    private GoogleHome googleHome;
    private GoogleResults googleResults;

    public BusinessController(String path, String feature,String scenario) {
        webActions = new WebController(path,feature,scenario);
    }

    public void goToGoogleHome(){
        String operation="Go to google home page";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));
            webActions.launchWebApp("Chrome", "http://www.google.com");
            googleHome = PageFactory.initElements(webActions.getDriver(),GoogleHome.class);
            googleHome.checkPage();
            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void closeBrowser(){
        try{
            webActions.closeWebApp();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void typeInGoogleSearchField(String searchString) {
        String operation="Type in the google search field";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            googleHome.typeSearch(searchString);

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void clickOnGoogleSearchButton() {
        String operation="Click on the google search button";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            googleHome.pressSearchButton();

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void checkGoogleResultsPage() {
        String operation="Check the google results page";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            googleResults = PageFactory.initElements(webActions.getDriver(),GoogleResults.class);
            googleResults.checkPage();

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void checkFirstSearchResult(String resultExpected) {
        String operation="Check the first google result";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            String resultObtained=googleResults.getFirstResult();
            Assert.assertEquals("the result was '".concat(resultObtained).concat("' but the expected is '")
                    .concat(resultExpected).concat("'."),resultObtained,resultExpected);

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void clickOnFirstSearchResult() {
        String operation="Click on the first search result";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            googleResults.clickFirstResult();

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }

    public void compareTabURL(String urlExpected) {
        String operation="Compare current url with the expected";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            webActions.takeScreenShot();
            String obtainedURL=webActions.getTabURL();
            Assert.assertEquals("the URL obtained was '".concat(obtainedURL).concat("' but the expected is '")
                    .concat(urlExpected).concat("'."),obtainedURL,urlExpected);

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }


}
