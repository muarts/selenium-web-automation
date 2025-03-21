package com.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    private final By pageTitle = By.cssSelector("[data-test=\"title\"]");
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public boolean checkoutAndContinueShoppingButtonsAreDisplayed() {
        return isDisplayed(checkoutButton) && isDisplayed(continueShoppingButton);
    }

    public String getTextOfCartPageTitle() {
        return getText(pageTitle);
    }
}
