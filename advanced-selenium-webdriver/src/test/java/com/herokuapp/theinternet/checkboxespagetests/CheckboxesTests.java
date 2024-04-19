package com.herokuapp.theinternet.checkboxespagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.CheckboxesPage;

public class CheckboxesTests extends TestUtilities {
    @Test
    public void checkboxesTest() {
        // Open home page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        // Navigate to checkboxes page
        CheckboxesPage checkboxesPage = welcomePage.clickCheckboxesLink();

        // Select all checkboxes
        checkboxesPage.selectAllCheckboxes();

        // Verify all checkboxes
        Assert.assertTrue(checkboxesPage.areAllCheckboxesSelected(), "Not all checkboxes are selected");
    }
}
