package com.google.searchTest.webController;

import com.google.searchTest.logs.Log;
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
import java.nio.file.Paths;
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
        Log.initLogs(Paths.get(path), "Logger");
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
        Log.LOGGER.info("Driver selected: '".concat(browser).concat("'. The browser opened the following url: '".concat(url).concat("'.")));
    }

    public void closeWebApp()
    {
        driver.close();
        driver.quit();
        Log.LOGGER.info("Driver closed");
    }

    public void clickElement(WebElement element, String elementNameOrDescription, Boolean takeScreenshot){
        element.click();
        if(takeScreenshot) takeScreenShot();
        Log.LOGGER.info("The element '".concat(elementNameOrDescription)
                .concat("' was clicked. Screenshot taken: ").concat(String.valueOf(takeScreenshot)));
    }

    public String getTextFromElement(WebElement element,String elementNameOrDescription ,Boolean takeScreenshot) {
        if(takeScreenshot) takeScreenShot();
        String text= element.getText();
        Log.LOGGER.info("The element '".concat(elementNameOrDescription)
                .concat("' had the text '").concat(text).concat("'. Screenshot taken: ").concat(String.valueOf(takeScreenshot)));
        return text;
    }

    public void sendTextToElement(WebElement element, String elementNameOrDescription, String text, boolean takeScreenshot) {
        element.sendKeys(text);
        if(takeScreenshot) takeScreenShot();
        Log.LOGGER.info("In the element '".concat(elementNameOrDescription)
                .concat("' was written the string '").concat(text).concat("'. Screenshot taken: ").concat(String.valueOf(takeScreenshot)));
    }

    public void waitVisible(WebElement element, String elementNameOrDescription, int timeout, Boolean takeScreenshot) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.visibilityOf(element));
        if(takeScreenshot) takeScreenShot();
        Log.LOGGER.info("The element '".concat(elementNameOrDescription)
                .concat("' was visible. Screenshot taken: ").concat(String.valueOf(takeScreenshot)));
    }

    public boolean isVisible(WebElement element,String elementNameOrDescription, int timeout, boolean takeScreenshot) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, timeout);
            wait.until(ExpectedConditions.visibilityOf(element));
            if(takeScreenshot) takeScreenShot();
            Log.LOGGER.info("The element '".concat(elementNameOrDescription)
                    .concat("' was visible. Screenshot taken: ").concat(String.valueOf(takeScreenshot)));
            return true;
        }catch (Exception e){
            Log.LOGGER.info("The element '".concat(elementNameOrDescription)
                    .concat("' wasn´t visible. Screenshot taken: ").concat(String.valueOf(takeScreenshot)));
            return false;
        }

    }

    public String getTabURL(){
        String url= driver.getCurrentUrl();
        Log.LOGGER.info("The browser url was '".concat(url)
                .concat("'"));
        return url;

    }

    public void takeScreenShot(){
        TakesScreenshot scrShot =((TakesScreenshot)driver);
        File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);
        File DestFile=new File(path.concat(feature).concat("-").concat(String.valueOf(screenShotCounter)).concat(".png"));
        try{FileUtils.copyFile(SrcFile, DestFile);}catch (Exception e){e.printStackTrace();}
        screenShotCounter++;
    }
}
