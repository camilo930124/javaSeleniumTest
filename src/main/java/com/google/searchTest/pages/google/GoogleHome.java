package com.google.searchTest.pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

import static com.google.searchTest.businessController.BusinessController.webActions;

public class GoogleHome {

    @FindBy(how = How.NAME, using = "q")
    private WebElement inputSearchField;

    @FindBy(how = How.XPATH, using = "//input[@name='q']//parent::div")
    private WebElement txtSearchField;

    @FindBy(how = How.XPATH, using = "//div[@class='FPdoLc VlcLAe']//input[@name='btnK']")
    private WebElement btnGoogleSearch;

    @FindBy(how = How.XPATH, using = "//div[@class='FPdoLc VlcLAe']//input[@name='btnI']")
    private WebElement btnImFeelingLucky;

    @FindBy(how = How.XPATH, using = "//img[@alt='Google']")
    private WebElement imgGoogle;

    @FindBy(how = How.XPATH, using = "//ul[@role='listbox']")
    private WebElement ulSuggestionList;

    @FindBy(how = How.XPATH, using = "//ul[@role='listbox']/li")
    private List<WebElement> ulSearchSuggestionElements;

    public GoogleHome() {
    }

    public void typeSearch(String textToSearch) throws Exception{
        webActions.sendTextToElement(inputSearchField,"google search field",textToSearch,false);
    }

    public void closeSearchList() throws Exception{
        webActions.waitVisible(ulSuggestionList,"suggestion list",30,true);
        webActions.clickElement(imgGoogle,"google logo",false);
    }

    public boolean isSuggestionListVisible() throws Exception{
        return webActions.isVisible(ulSuggestionList,"suggestion list",30,true);
    }

    public void pressSearchButton() throws Exception {
        webActions.clickElement(btnGoogleSearch,"google search button",false);
    }

    public boolean checkPage() throws Exception{
        return webActions.isVisible(btnGoogleSearch,"google search button",30,true);
    }

    public int getSuggestedOptionsQty() throws Exception{
        return ulSearchSuggestionElements.size();
    }

    public void clickOnElementFromSuggestionList(int elementPosition)  throws Exception{
        webActions.clickElement(ulSearchSuggestionElements.get(elementPosition),"element '".concat(String.valueOf(elementPosition+1)).concat("' from suggestion list"),false);
    }
}
