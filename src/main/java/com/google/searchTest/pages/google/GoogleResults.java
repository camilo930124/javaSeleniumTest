package com.google.searchTest.pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.google.searchTest.businessController.BusinessController.webActions;


public class GoogleResults {
    @FindBy(how = How.XPATH, using = "//div[@id='search']//h3")
    List<WebElement> lnkResults;

    @FindBy(how = How.XPATH, using = "//div[@id='hdtb-msb-vis']/div[@aria-selected='true']")
    WebElement opcAllResults;

    public void checkPage() throws Exception{
        webActions.isVisible(opcAllResults,30,true);
    }

    public String getFirstResult() {
        return webActions.getTextFromElement(lnkResults.get(0),true);
    }

    public void clickFirstResult() {
        webActions.clickElement(lnkResults.get(0),false);
    }
}
