package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class JSAlertsPage extends BasePageObject {

    private By jsAlertButtonlocator = By.cssSelector("button[onclick='jsAlert()']");
    private By jsConfirmButtonlocator = By.cssSelector("button[onclick='jsConfirm()']");
    private By jsPromptButtonlocator = By.cssSelector("button[onclick='jsPrompt()']");
    private By resultTextLocator = By.id("result");

    public JSAlertsPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openJSAlert() {
        log.info("Clicking on 'Click for JS Alert' button");
        find(jsAlertButtonlocator).click();
    }

    public void openJSConfirm() {
        log.info("Clicking on 'Click for JS Confirm' button");
        find(jsConfirmButtonlocator).click();
    }

    public void openJSPrompt() {
        log.info("Clicking on 'Click for JS Prompt' button");
        find(jsPromptButtonlocator).click();
    }

    
    public String getAlertText() {
        log.info("Switching to alert");
        Alert alert = switchToAlert();
        String alertText = alert.getText();
        log.info("Alert says: " + alertText);
        return alertText;
    }

    public void acceptAlert() {
        log.info("Switching to alert");
        Alert alert = switchToAlert();
        log.info("Accepting alert");
        alert.accept();
    }

    public void dismissAlert() {
        log.info("Switching to alert");
        Alert alert = switchToAlert();
        log.info("Dismissing alert");
        alert.dismiss();
    }

    public void typeTextIntoAlert(String text) {
        log.info("Switching to alert");
        Alert alert = switchToAlert();
        log.info("Typing text to alert");
        alert.sendKeys(text);
    }

    public String getResultText() {
        log.info("Getting result text");
        String resultText = find(resultTextLocator).getText();
        log.info("Result Text: " + resultText);
        return resultText;
    }
}
