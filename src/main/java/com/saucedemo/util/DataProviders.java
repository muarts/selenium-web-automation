package com.saucedemo.util;

import org.testng.annotations.DataProvider;

import static com.saucedemo.testdata.CommonConstant.VALID_PASSWORD;
import static com.saucedemo.testdata.CommonConstant.STANDARD_USER_USERNAME;
import static com.saucedemo.util.Helper.getRandomString;

public class DataProviders {

    @DataProvider(name = "usernameAndPasswordDataProvider")
    public Object[][] statusDataProvider() {
        return new Object [][] {{STANDARD_USER_USERNAME, getRandomString()}, {getRandomString(), VALID_PASSWORD}, {getRandomString(), getRandomString()}};
    }

}
