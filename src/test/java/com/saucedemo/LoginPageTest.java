package com.saucedemo;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LoginPageTest {

    @Test
    public void testSmoke() {
        ChromeDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.close();
    }
}
