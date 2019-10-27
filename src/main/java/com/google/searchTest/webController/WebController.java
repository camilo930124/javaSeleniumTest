package com.google.searchTest.webController;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebController {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
    
    public void launchWebApp(String browser, String url)
    {
        switch (browser)
        {
            case "Firefox":
                driver=new FirefoxDriver();
                break;
            case "Chrome":
                driver=new ChromeDriver();
                break;
            default:
                driver=new ChromeDriver();
                break;
        }

        //driver.Manage().Timeouts().ImplicitWait(30);
        driver.get(url);
    }

    public void closeWebApp()
    {
        driver.close();
        driver.quit();
    }

    public void clickElement(WebElement element, Boolean takeScreenshot){
        element.click();
    }

    public String getTextFromElement(WebElement element, Boolean takeScreenshot)
    {
        return element.getText();
    }

    public void sendTextToElement(WebElement element, String text, boolean takeScreenshot) {
        element.sendKeys(text);
    }

    public void waitVisible(WebElement element, int timeout, Boolean takeScreenshot) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public boolean isVisible(WebElement element, int timeout, Boolean takeScreenshot) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public String getTabURL(){
        return driver.getCurrentUrl();
    }
}
