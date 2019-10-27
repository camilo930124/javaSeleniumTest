package com.google.searchTest.businessController;

import com.google.searchTest.pages.google.GoogleHome;
import com.google.searchTest.pages.google.GoogleResults;
import com.google.searchTest.webController.WebController;
import org.openqa.selenium.support.PageFactory;

public class BusinessController {
    public static WebController webActions;
    private GoogleHome googleHome;
    private GoogleResults googleResults;

    public BusinessController() {
        webActions = new WebController();
    }

    public static void main(String[] args) {
        webActions.launchWebApp("Chrome", "http://www.google.com");
        System.out.println("ok");
    }


    public void goToGoogleHome(){
        try {
            webActions.launchWebApp("Chrome", "http://www.google.com");
            googleHome = PageFactory.initElements(webActions.getDriver(),GoogleHome.class);
            googleHome.checkPage();
        }catch (Exception e){
        e.printStackTrace();
        }
    }

    public void typeInGoogleSearchField(String searchString) {
        try {
            googleHome.typeSearch(searchString);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnGoogleSearchButton() {
        try {
            googleHome.pressSearchButton();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkGoogleResultsPage() {
        try {
            googleResults = PageFactory.initElements(webActions.getDriver(),GoogleResults.class);
            googleResults.checkPage();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void checkFirstSearchResult(String expectedTitle) {
        try {
            String obtainedTitle=googleResults.getFirstResult();
            System.out.println(obtainedTitle.equalsIgnoreCase(expectedTitle));
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnFirstSearchResult() {
        try {
            googleResults.clickFirstResult();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void compareTabURL(String expectedURL) {
        try {
            String obtainedURL=webActions.getTabURL();
            System.out.println(obtainedURL);
            System.out.println(obtainedURL.equalsIgnoreCase(expectedURL));
        }catch (Exception e){
            e.printStackTrace();
        }
    }


}
