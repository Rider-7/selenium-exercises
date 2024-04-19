package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FramesPage extends BasePageObject {

    private By iFrameLinkLocator = By.linkText("iFrame");

    public FramesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public IFramePage clickOnIFrameLink() {
        log.info("Clicking 'iFrame' link on Frames Page");
        click(iFrameLinkLocator);
        return new IFramePage(driver, log);
    }
}
