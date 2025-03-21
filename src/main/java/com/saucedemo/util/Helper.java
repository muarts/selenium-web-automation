package com.saucedemo.util;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Random;

public class Helper {

    public static String getRandomString() {
        return RandomStringUtils.randomAlphanumeric(10);
    }

    public static int getRandomNumber(int max) {
        Random random = new Random();
        return random.nextInt(max);
    }

}
