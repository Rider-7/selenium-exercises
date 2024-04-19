package com.herokuapp.theinternet.pages;

import java.time.Duration;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class IFramePage extends BasePageObject {

    private By iFrameBodyLocator = By.id("tinymce");
    private String iFrameId = "mce_0_ifr";

    public IFramePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public String getIFrameText() {
        log.info("Getting text in iframe");
        switchToIFrame(iFrameId);
        waitForVisibilityOfWebElement(iFrameBodyLocator, Duration.ofSeconds(5));
        return find(iFrameBodyLocator).getText();
    }
}
