package com.saucedemo.page;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import static com.saucedemo.testdata.CommonConstant.PROD_URL;
import static com.saucedemo.testdata.CommonConstant.STANDARD_USER_USERNAME;

public class PageBase {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public PageBase(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    public WebElement findElement(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement findElement(WebElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void click(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator))
                .click();
    }

    public String getText(By locator) {
        return findElement(locator)
                .getText();
    }

    public void bypassLoginAndGetHere(String path) {
        driver.manage().addCookie(new Cookie("session-username", STANDARD_USER_USERNAME));
        driver.get(PROD_URL + path);
    }

    public String getText(WebElement element) {
        return findElement(element)
                .getText();
    }

    public List<WebElement> findElements(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public List<String> getTextsOfAllElements(By locator) {
        List<WebElement> elements = findElements(locator);
        return elements.stream()
                .map(this::getText)
                .collect(Collectors.toList());
    }

    public boolean isDisplayed(By locator) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator)).isDisplayed();
        } catch (TimeoutException te) {
            return false;
        }
    }

}
