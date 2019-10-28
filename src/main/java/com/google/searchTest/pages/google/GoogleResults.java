package com.google.searchTest.pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.google.searchTest.businessController.BusinessController.webActions;


public class GoogleResults {
    @FindBy(how = How.XPATH, using = "//div[@id='search']//h3")
    private List<WebElement> lnkResults;

    @FindBy(how = How.XPATH, using = "//div[@id='hdtb-msb-vis']/div[@aria-selected='true']")
    private WebElement opcAllResults;

    public boolean checkPage() throws Exception{
        return webActions.isVisible(opcAllResults,"all results option",30,true);
    }

    public String getFirstResult() {
        return webActions.getTextFromElement(lnkResults.get(0),"first search result",false);
    }

    public void clickFirstResult() {
        webActions.clickElement(lnkResults.get(0),"first search result",false);
    }
}
