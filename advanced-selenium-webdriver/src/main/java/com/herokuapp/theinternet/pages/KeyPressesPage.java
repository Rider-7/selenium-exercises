package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class KeyPressesPage extends BasePageObject {
    
    private By keyedResultLocator = By.id("result");

    public KeyPressesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getKeyedResult() {
        log.info("Getting key press result");
        return find(keyedResultLocator).getText();
    }
}
