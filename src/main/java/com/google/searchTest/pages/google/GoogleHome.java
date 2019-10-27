package com.google.searchTest.pages.google;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

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
    private WebElement ulResults;

    public void typeSearch(String textToSearch) throws Exception{
        webActions.sendTextToElement(inputSearchField,"google search field",textToSearch,false);
        webActions.waitVisible(ulResults,"google search field result list",30,true);
        webActions.clickElement(imgGoogle,"google logo",false);
    }
    
    public void pressSearchButton() throws Exception {
        webActions.clickElement(btnGoogleSearch,"google search button",false);
    }

    public void checkPage() throws Exception{
        webActions.isVisible(btnGoogleSearch,"google search button",30,true);
    }

}
