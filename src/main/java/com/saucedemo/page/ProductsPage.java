package com.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends PageBase {

    private final By pageTitle = By.cssSelector("[data-test=\"title\"]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfPageTitle() {
        return getText(pageTitle);
    }
}
