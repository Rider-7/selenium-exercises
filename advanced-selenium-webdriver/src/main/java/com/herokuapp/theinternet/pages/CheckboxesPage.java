package com.herokuapp.theinternet.pages;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckboxesPage extends BasePageObject {

    private By checkboxListLocator = By.xpath("//input[@type='checkbox']");

    public CheckboxesPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectAllCheckboxes() {
        log.info("Checking all checkboxes");
        List<WebElement> checkboxList = findAll(checkboxListLocator);
        for (WebElement checkbox : checkboxList) {
            if (!checkbox.isSelected()) checkbox.click();
        }
    }

    public boolean areAllCheckboxesSelected() {
        log.info("Confirming that all checkboxes are selected");
        List<WebElement> checkboxList = findAll(checkboxListLocator);
        for (WebElement checkbox : checkboxList) {
            if (!checkbox.isSelected()) return false;
        }
        return true;
    }

}
