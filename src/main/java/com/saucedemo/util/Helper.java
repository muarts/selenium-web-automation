package com.saucedemo.util;

import org.apache.commons.lang3.RandomStringUtils;

public class Helper {

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }
}
