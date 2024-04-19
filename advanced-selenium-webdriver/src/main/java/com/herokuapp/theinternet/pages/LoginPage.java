package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePageObject {

    private By usernameLocator = By.id("username");
    private By passwordLocator = By.id("password");
    private By logInButtonLocator = By.tagName("button");
    private By errorMessageLocator = By.cssSelector(".flash.error");

    public LoginPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public SecureAreaPage logIn(String username, String password) {
        log.info("Executing login with username [" + username + "] and password [" + password + "]");
        type(username, usernameLocator);
        type(password, passwordLocator);
        click(logInButtonLocator);
        return new SecureAreaPage(driver, log); 
    }

    public void waitForErrorMessage() {
        waitForVisibilityOfWebElement(errorMessageLocator, Duration.ofSeconds(5));
    }

    public String getErrorMessageText() {
        return find(errorMessageLocator).getText();
    }
}
