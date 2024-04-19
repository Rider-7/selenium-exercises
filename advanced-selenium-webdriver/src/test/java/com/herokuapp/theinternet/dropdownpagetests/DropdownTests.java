package com.herokuapp.theinternet.dropdownpagetests;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.WelcomePage;
import com.herokuapp.theinternet.pages.DropdownPage;

public class DropdownTests extends TestUtilities {

    @Parameters({ "value" })
    @Test
    public void DropdownTest(String value) {

        // 1. Navigate to dropdown page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();
        DropdownPage dropdownPage = welcomePage.clickDropdownLink();
        
        // 2. Select option
        dropdownPage.selectOption(value);

        // 3. Verify option is selected
        String errMsg = "Expected option not selected - Expected: " + 
            value + ", Actual: " + dropdownPage.getSelectedOption() + "\n";
        Assert.assertTrue(dropdownPage.isOptionSelected(value), errMsg);

    }

}
