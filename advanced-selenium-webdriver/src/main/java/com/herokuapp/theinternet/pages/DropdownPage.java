package com.herokuapp.theinternet.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.apache.logging.log4j.Logger;

public class DropdownPage extends BasePageObject {

    private By dropdownLocator = By.id("dropdown");

    public DropdownPage(WebDriver driver, Logger log) {
        super(driver, log);
    }

    public void selectOption(String value) {
        log.info("Selecting Option " + value);
        WebElement selectEl = find(dropdownLocator);
        Select select = new Select(selectEl);

        select.selectByValue(value);
    }

    public boolean isOptionSelected(String value) {
        WebElement selectEl = find(dropdownLocator);
        Select select = new Select(selectEl);

        WebElement selectedOption = select.getFirstSelectedOption();
        if (selectedOption.getAttribute("value").equals(value)) return true;
        return false;
    }

    public String getSelectedOption() {
        WebElement selectEl = find(dropdownLocator);
        Select select = new Select(selectEl);

        WebElement selectedOption = select.getFirstSelectedOption();
        if (selectedOption != null) return selectedOption.getAttribute("value");
        return "No option selected";
    }
}
