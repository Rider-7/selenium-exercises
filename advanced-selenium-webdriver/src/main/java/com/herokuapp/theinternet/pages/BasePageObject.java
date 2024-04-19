package com.herokuapp.theinternet.pages;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;

public class BasePageObject {

    protected WebDriver driver;
    protected Logger log;

    public BasePageObject(WebDriver driver, Logger log) {
        this.driver = driver;
        this.log = log;
    }

    //** Open page with given URL */
    protected void openUrl(String url) {
        driver.get(url);
    }

    //* Return current page URL */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    //* Return current page Title */
    public String getCurrentPageTitle() {
        return driver.getTitle();
    }

    public String getCurrentPageSource() {
        return driver.getPageSource();
    }

    /** Find element with given locator */
    protected WebElement find(By locator) {
        return driver.findElement(locator);
    }

    /** Find all elments with given locator */
    protected List<WebElement> findAll(By locator) {
        return driver.findElements(locator);
    }

    /** Click on element with given locator only if element is visible */
    protected void click(By locator) {
        waitForVisibilityOfWebElement(locator, Duration.ofSeconds(5));
        find(locator).click();
    }

    /** Type given text into element with given locator only if element is visible */
    protected void type(String text, By locator) {
        waitForVisibilityOfWebElement(locator, Duration.ofSeconds(5));
        find(locator).sendKeys(text);
    }

    /** Wait for specific ExpectedCondition<WebElement> for the given number of seconds */
    private boolean waitForWebElement(ExpectedCondition<WebElement> condition, Duration timeout) {
        timeout = timeout != null ? timeout : Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        if (wait.until(condition) != null) return true;
        return false;
    }

    /** Wait for specific ExpectedCondition<Alert> for the given number of seconds */
    private boolean waitForAlert(ExpectedCondition<Alert> condition, Duration timeout) {
        timeout = timeout != null ? timeout : Duration.ofSeconds(10);
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        if (wait.until(condition) != null) return true;
        return false;
    }

    /** Wait for given number of seconds for element with given locator to be visible on page */
    protected void waitForVisibilityOfWebElement(By locator, Duration... timeout) {
        int attempts = 0;
        boolean isVisible = false;
        while (attempts < 2) {
            try {
                isVisible = waitForWebElement(ExpectedConditions.visibilityOfElementLocated(locator),
                    (timeout.length > 0 ? timeout[0] : null));
            } catch (StaleElementReferenceException e) {}
            if (isVisible) break;
            attempts++;
        }
    }

    /** Wait for JS alert to be present and then switch to it */
    protected Alert switchToAlert() {
        waitForAlert(ExpectedConditions.alertIsPresent(), Duration.ofSeconds(5));
        return driver.switchTo().alert();
    } 

    /** Switch from the current window to the window with the given title */
    protected void switchToWindowWithTitle(String expectedTitle) {
        String firstWindow = driver.getWindowHandle();
        
        Set<String> allWindows = driver.getWindowHandles();
        Iterator<String> windowsIterator = allWindows.iterator();

        while (windowsIterator.hasNext()) {
            String windowHandle = windowsIterator.next().toString();
            if (!windowHandle.equals(firstWindow)) {
                driver.switchTo().window(windowHandle);
                if (getCurrentPageTitle().equals(expectedTitle)) break;
            }
        }
    }

    /** Switch to the given iframe within the current window */
    protected void switchToIFrame(String id) {
        driver.switchTo().frame(id);
    }

    /** Press key using Actions class */
    public void pressKeyWithActions(Keys key) {
        Actions action = new Actions(driver);
        action.sendKeys(key).build().perform();
    }

    /** Hover over the given element */
    protected void hoverOverElement(WebElement element) {
        Actions action = new Actions(driver);
        action.moveToElement(element).build().perform();
    }

    /** Scroll to bottom of page */
    protected void scrollToBottom() {
        log.info("Scrolling to bottom of page");
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }

    protected void performDragAndDrop(WebElement source, WebElement target) {

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("function createEvent(typeOfEvent) {\n" + "var event =document.createEvent(\"CustomEvent\");\n"
                            + "event.initCustomEvent(typeOfEvent,true, true, null);\n" + "event.dataTransfer = {\n" + "data: {},\n"
                            + "setData: function (key, value) {\n" + "this.data[key] = value;\n" + "},\n"
                            + "getData: function (key) {\n" + "return this.data[key];\n" + "}\n" + "};\n" + "return event;\n"
                            + "}\n" + "\n" + "function dispatchEvent(element, event,transferData) {\n"
                            + "if (transferData !== undefined) {\n" + "event.dataTransfer = transferData;\n" + "}\n"
                            + "if (element.dispatchEvent) {\n" + "element.dispatchEvent(event);\n"
                            + "} else if (element.fireEvent) {\n" + "element.fireEvent(\"on\" + event.type, event);\n" + "}\n"
                            + "}\n" + "\n" + "function simulateHTML5DragAndDrop(element, destination) {\n"
                            + "var dragStartEvent =createEvent('dragstart');\n" + "dispatchEvent(element, dragStartEvent);\n"
                            + "var dropEvent = createEvent('drop');\n"
                            + "dispatchEvent(destination, dropEvent,dragStartEvent.dataTransfer);\n"
                            + "var dragEndEvent = createEvent('dragend');\n"
                            + "dispatchEvent(element, dragEndEvent,dropEvent.dataTransfer);\n" + "}\n" + "\n"
                            + "var source = arguments[0];\n" + "var destination = arguments[1];\n"
                            + "simulateHTML5DragAndDrop(source,destination);", source, target);
    }
}
