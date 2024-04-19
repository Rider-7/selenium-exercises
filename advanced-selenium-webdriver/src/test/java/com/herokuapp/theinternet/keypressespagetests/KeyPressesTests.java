package com.herokuapp.theinternet.keypressespagetests;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.KeyPressesPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class KeyPressesTests extends TestUtilities {

    @Test
    public void KeyPressTest() {
        // 1. Navigate to key presses page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        KeyPressesPage keyPressesPage = welcomePage.clickKeyPressesLink();

        // 2. Send key to page
        keyPressesPage.pressKeyWithActions(Keys.SPACE);

        // VERIFICATIONS
        // 3. Verify resultant key press text is on page
        Assert.assertEquals(keyPressesPage.getKeyedResult(), "You entered: SPACE", "Incorrect key displayed: ");
    }
}
