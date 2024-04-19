package com.herokuapp.theinternet.iframepagetests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.FramesPage;
import com.herokuapp.theinternet.pages.IFramePage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class IFrameTests extends TestUtilities {

    @Test
    public void IFrameTest() {
        // 1. Navigate to iframe page
        WelcomePage welcomePage = new WelcomePage(driver, log);
        welcomePage.openPage();

        FramesPage framesPage = welcomePage.clickFramesLink();
        IFramePage iFramePage = framesPage.clickOnIFrameLink();

        // 2. Verify iframe text
        Assert.assertEquals(iFramePage.getIFrameText(), "Your content goes here.", "Incorrect text message displayed in iframe: ");
    }
}
