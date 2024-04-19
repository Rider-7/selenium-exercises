package com.herokuapp.theinternet.draganddroppagetests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.herokuapp.theinternet.base.TestUtilities;
import com.herokuapp.theinternet.pages.DragAndDropPage;
import com.herokuapp.theinternet.pages.WelcomePage;

public class DragAndDropTests extends TestUtilities {
    
    @Test
    public void DragAndDropTest() {
        
    // 1. Navigate to drag and drop page
    WelcomePage welcomePage = new WelcomePage(driver, log);
    welcomePage.openPage();
    DragAndDropPage dragAndDropPage = welcomePage.clickDragAndDropLink();

    // 2. Drag and drop box A onto box B
    dragAndDropPage.dragAToB();

    // VERIFICATIONS
    // 3. Verify text swapped places
    SoftAssert softAssert = new SoftAssert();
    softAssert.assertEquals(dragAndDropPage.getColumnAText(), "B", "Column A text was not swapped: ");
    softAssert.assertEquals(dragAndDropPage.getColumnBText(), "A", "Column B text was not swapped: ");
    softAssert.assertAll();
    }
}
