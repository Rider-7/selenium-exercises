package com.herokuapp.theinternet.multiplewindowspagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.MultipleWindowsPage;
import com.herokuapp.theinternet.pages.NewWindowPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class MultipleWindowsTests extends TestUtilities {

    @Test
    public void MultipleWindowsTest() {
        // 1. Navigate to multiple windows page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        MultipleWindowsPage multipleWindowsPage = welcomePage.clickMultipleWindowsLink();

        // 2. Click on 'Click Here' link to create new window/tab
        multipleWindowsPage.openNewWindow();

        // 3. Switch to new window tab
        NewWindowPage newWindowPage = multipleWindowsPage.switchToNewWindowPage();

        // VERIFICATIONS
        // 4. Verify header text
        String pageSource = newWindowPage.getCurrentPageSource();
        Assert.assertTrue(pageSource.contains("New Window"), "New page source does not exist: ");
    }
}
