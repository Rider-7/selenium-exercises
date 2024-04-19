package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class WelcomePage extends BasePageObject {
    
    private String pageUrl = "https://the-internet.herokuapp.com/";

    private By formAuthenticationLinkLocator = By.linkText("Form Authentication");
    private By checkboxesLinkLocator = By.linkText("Checkboxes");
    private By dropdownLinkLocator = By.linkText("Dropdown");
    private By jsAlertsLinkLocator = By.linkText("JavaScript Alerts");
    private By multipleWindowsLinkLocator = By.linkText("Multiple Windows");
    private By framesLinkLocator = By.linkText("Frames");
    private By keyPressesLinkLocator = By.linkText("Key Presses");
    private By DragAndDropLinkLocator = By.linkText("Drag and Drop");
    private By hoversLinkLocator = By.linkText("Hovers");

    public WelcomePage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void openPage() {
        log.info("Opening page: " + pageUrl);
        openUrl(pageUrl);
        log.info("Welcome Page opened!");
    }

    public LoginPage clickFormAuthenticationLink() {
        log.info("Clicking 'Form Authentication' link on Welcome Page");
        click(formAuthenticationLinkLocator);
        return new LoginPage(driver, log);
    }

    public CheckboxesPage clickCheckboxesLink() {
        log.info("Clicking 'Checkboxes' link on Welcome Page");
        click(checkboxesLinkLocator);
        return new CheckboxesPage(driver, log);
    }

    public DropdownPage clickDropdownLink() {
        log.info("Clicking 'Dropdown' link on Welcome Page");
        click(dropdownLinkLocator);
        return new DropdownPage(driver, log);
    }

    public JSAlertsPage clickJSAlertLink() {
        log.info("Clicking 'Javascript Alerts' link on Welcome Page");
        click(jsAlertsLinkLocator);
        return new JSAlertsPage(driver, log);
    }

    public MultipleWindowsPage clickMultipleWindowsLink() {
        log.info("Clicking 'Multiple Windows' link on Welcome Page");
        click(multipleWindowsLinkLocator);
        return new MultipleWindowsPage(driver, log);

    }

    public FramesPage clickFramesLink() {
        log.info("Clicking 'Frames' link on Welcome Page");
        click(framesLinkLocator);
        return new FramesPage(driver, log);
    } 

    public KeyPressesPage clickKeyPressesLink() {
        log.info("Clicking 'Key Presses' link on Welcome Page");
        click(keyPressesLinkLocator);
        return new KeyPressesPage(driver, log);
    }

    public DragAndDropPage clickDragAndDropLink() {
        log.info("Clicking 'Drag and Drop' link on Welcome Page");
        click(DragAndDropLinkLocator);
        return new DragAndDropPage(driver, log);
    }

    public HoversPage clickHoversLink() {
        log.info("Clicking 'Hovers' link on Welcome Page");
        click(hoversLinkLocator);
        return new HoversPage(driver, log);
    } 
}
