package com.google.searchTest.webController;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class WebController {
    private WebDriver driver;
    private String path;
    private String feature;
    private int screenShotCounter;

    public WebController(String path, String feature,String scenario) {
        this.path = path;
        addDateToEvidencePath(scenario);
        this.feature = feature;
        screenShotCounter=0;
    }

    private void addDateToEvidencePath(String scenario){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("_yyyy-MM-dd_HH-mm/");
        LocalDateTime now = LocalDateTime.now();
        path=path.concat(scenario).concat(dtf.format(now));
        new File(path).mkdir();
    }

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
        if(takeScreenshot) takeScreenShot();
    }

    public String getTextFromElement(WebElement element, Boolean takeScreenshot)
    {
        if(takeScreenshot) takeScreenShot();
        return element.getText();
    }

    public void sendTextToElement(WebElement element, String text, boolean takeScreenshot) {
        element.sendKeys(text);
        if(takeScreenshot) takeScreenShot();
    }

    public void waitVisible(WebElement element, int timeout, Boolean takeScreenshot) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(takeScreenshot) takeScreenShot();
    }

    public boolean isVisible(WebElement element, int timeout, Boolean takeScreenshot) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            if(takeScreenshot) takeScreenShot();
            return true;
        }catch (Exception e){
            return false;
        }

    }

    public String getTabURL(){
        return driver.getCurrentUrl();
    }

    public void takeScreenShot(){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(path.concat(feature).concat("-").concat(String.valueOf(screenShotCounter)).concat(".png"));
        try{FileUtils.copyFile(SrcFile, DestFile);}catch (Exception e){e.printStackTrace();}
        screenShotCounter++;
    }
}
