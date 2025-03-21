package com.saucedemo.page;

import com.saucedemo.testdata.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPage extends PageBase {

    private final By pageTitle = By.cssSelector("[data-test=\"title\"]");
    private final By checkoutButton = By.id("checkout");
    private final By continueShoppingButton = By.id("continue-shopping");
    private final By productName = By.cssSelector("[data-test=\"inventory-item-name\"]");
    private final By productDetail = By.cssSelector("[data-test=\"inventory-item-desc\"]");
    private final By productPrice = By.cssSelector("[data-test=\"inventory-item-price\"]");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public Product getProductInCart() {
        Product product = new Product();
        product.setProductName(getText(findElement(productName)));
        product.setProductPrice(getText(findElement(productPrice)));
        product.setProductDetail(getText(findElement(productDetail)));
        return product;
    }

    public boolean checkoutAndContinueShoppingButtonsAreDisplayed() {
        return isDisplayed(checkoutButton) && isDisplayed(continueShoppingButton);
    }

    public String getTextOfCartPageTitle() {
        return getText(pageTitle);
    }
}
