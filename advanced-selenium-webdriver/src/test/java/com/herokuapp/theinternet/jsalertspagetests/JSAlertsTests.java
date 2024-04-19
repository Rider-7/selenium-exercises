package com.herokuapp.theinternet.jsalertspagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.JSAlertsPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class JSAlertsTests extends TestUtilities {
    
    // Helper
    private JSAlertsPage navigateToJSAlertsPage() {

        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        return welcomePage.clickJSAlertLink();
    }

    // Verification Methods
    private void verifyAlertText(String actualAlertText, String expectedAlertText) {

        String errMsg = "Incorrect alert message displayed:";
        Assert.assertEquals(actualAlertText, expectedAlertText, errMsg);
    }

    private void verifyResultText(String actualResultText, String expectedResultText) {

        String errMsg = "Incorrect result message displayed:";
        Assert.assertEquals(actualResultText, expectedResultText, errMsg);
    }

    // Tests
    @Test
    public void AlertTest() {

        // 1. Navigate to alerts page
        JSAlertsPage jsAlertsPage = navigateToJSAlertsPage();

        // 2. Click on alert button
        jsAlertsPage.openJSAlert();

        // 3. Get alert text
        String actualAlertText = jsAlertsPage.getAlertText();

        // 4. Accept alert
        jsAlertsPage.acceptAlert();

        // 5. Get result text
        String actualResultText = jsAlertsPage.getResultText();

        // VERIFICATIONS
        // 1. Verify alert text
        verifyAlertText(actualAlertText, "I am a JS Alert");

        // 2. Verify result text
        verifyResultText(actualResultText, "You successfully clicked an alert");
    }

    @Parameters({ "isAccepted", "expectedResultText" })
    @Test
    public void ConfirmTest(boolean isAccepted, String expectedResultText) {
        // 1. Navigate to alerts page
        JSAlertsPage jsAlertsPage = navigateToJSAlertsPage();

        // 2. Click on alert button
        jsAlertsPage.openJSConfirm();

        // 3. Get alert text
        String actualAlertText  = jsAlertsPage.getAlertText();

        // 4. If statement - Accept or dismiss alert
        if (isAccepted) jsAlertsPage.acceptAlert();
        else jsAlertsPage.dismissAlert();

        // 5. Get result text
        String actualResultText = jsAlertsPage.getResultText();
        
        // VERIFICATIONS
        // 1. Verify alert text
        verifyAlertText(actualAlertText, "I am a JS Confirm");

        // 2. Verify result text
        verifyResultText(actualResultText, expectedResultText);
    }

    @Parameters({ "isAccepted", "inputText", "expectedAlertText", "expectedResultText" })
    @Test
    public void PromptTest(boolean isAccepted, String inputText, String expectedAlertText, String expectedResultText) {
        // 1. Navigate to alerts page
        JSAlertsPage jsAlertsPage = navigateToJSAlertsPage();

        // 2. Click on alert button
        jsAlertsPage.openJSPrompt();

        // 3. Get alert text
        String actualAlertText = jsAlertsPage.getAlertText();

        // 4. Input text
        jsAlertsPage.typeTextIntoAlert(inputText);

        // 4. If statement - Accept or dismiss alert
        if (isAccepted) jsAlertsPage.acceptAlert();
        else jsAlertsPage.dismissAlert();

        // 5. Get result text
        String actualResultText = jsAlertsPage.getResultText();

        // VERIFICATIONS
        // 1. Verify alert text
        verifyAlertText(actualAlertText, expectedAlertText);

        // 2. Verify result text
        verifyResultText(actualResultText, expectedResultText);
    }
}
