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
    private String evidencePath;

    public BusinessController(String path, String feature,String scenario) {
        webActions = new WebController(path,feature,scenario);
        evidencePath=webActions.getEvidencePath();
    }

    public String getEvidencePath() {
        return evidencePath;
    }

    public void goToGoogleHome(){
        String operation="Go to google home page";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));
            webActions.launchWebApp("Chrome", "http://www.google.com");
            googleHome = PageFactory.initElements(webActions.getDriver(),GoogleHome.class);
            boolean isGoogle=googleHome.checkPage();
            Assert.assertTrue("The loaded page isn't google",isGoogle);
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

    public void typeInGoogleSearchField(String searchString, boolean closeSearchList) {
        String operation="Type in the google search field";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            googleHome.typeSearch(searchString);
            if(closeSearchList) googleHome.closeSearchList();

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
            boolean isGoogleResultsPage=googleResults.checkPage();
            Assert.assertTrue("The loaded page isn't google results page",isGoogleResultsPage);

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

    public void checkSuggestionListIsDisplayed() {
        String operation="Check that the suggestion list is displayed";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            boolean isSuggestionListVisible=googleHome.isSuggestionListVisible();
            Assert.assertTrue("The suggestion list isn't displayed",isSuggestionListVisible);

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


    public void clickOnSpecificElementFromSuggestionList(int elementPosition) {
        String operation="Click on specific element of the suggestion list";
        try {
            Log.LOGGER.info("----------Operation: ".concat(operation).concat("----------"));

            int suggestedOptions=googleHome.getSuggestedOptionsQty();
            if (suggestedOptions<(elementPosition+1)) throw new Exception("The list only have".concat(String.valueOf(suggestedOptions)).concat("elements"));
            googleHome.clickOnElementFromSuggestionList(elementPosition);

            Log.LOGGER.info("----------Operation successfully completed----------\n");
        }catch (Exception e){
            Log.LOGGER.info("Operation failed: ".concat(e.getMessage()));
            e.printStackTrace();
            Assert.fail();
        }
    }
}
