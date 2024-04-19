package com.herokuapp.theinternet.pages;

import org.openqa.selenium.WebDriver;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;

public class SecureAreaPage extends BasePageObject {

    private String pageUrl = "https://the-internet.herokuapp.com/secure";

    private By logOutButtonLocator = By.linkText("Logout");
    private By loginMessageLocator = By.id("flash-messages");

    public SecureAreaPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getPageUrl() {
        return pageUrl;
    }

    public boolean isLogOutButtonVisble() {
        return find(logOutButtonLocator).isDisplayed();
    }

    public String getSuccessMessageText() {
        return find(loginMessageLocator).getText();
    }
}
