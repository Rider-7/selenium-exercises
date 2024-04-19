package com.herokuapp.theinternet.base;

import org.testng.annotations.DataProvider;

public class TestUtilities extends BaseTest {

    @DataProvider(name="users")
    protected static Object[][] users() {
        return new Object[][] {
            {1, "tomsmith", "incorrectPassword", "Your password is invalid!"},
            {2, "incorrectUsername", "SuperSecretPassword!", "Your username is invalid!"}
        };
    } 
}
