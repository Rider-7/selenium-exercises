package com.herokuapp.theinternet.pages;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DragAndDropPage extends BasePageObject {

    private By divALocator = By.id("column-a");
    private By divBLocator = By.id("column-b");

    public DragAndDropPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void dragAToB() {
        log.info("Drag and drop box A onto box B");
        performDragAndDrop(find(divALocator), find(divBLocator));
    }

    public String getColumnAText() {
        return find(divALocator).getText();
    }

    public String getColumnBText() {
        return find(divBLocator).getText();
    }
}
