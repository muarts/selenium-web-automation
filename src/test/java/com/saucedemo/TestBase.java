package com.saucedemo;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.saucedemo.CommonConstant.PROD_URL;

public class TestBase {

    protected WebDriver driver;

    @BeforeMethod
    public void startUp() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.setCapability("browserVersion", "114.0.5735.90");
        driver = new ChromeDriver(chromeOptions);
        driver.get(PROD_URL);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
