package com.saucedemo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase {

    private static final By errorLoginMessage = By.cssSelector("[data-test=\"error\"]");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private final By usernameInput = By.id("user-name");
    private final By passwordInput = By.id("password");
    private final By loginButton = By.id("login-button");

    public ProductsPage login(String username, String password) {
        findElement(usernameInput).sendKeys(username);
        findElement(passwordInput).sendKeys(password);
        click(loginButton);
        return new ProductsPage(driver);
    }

    public String loginError(String username, String password) {
        findElement(usernameInput).sendKeys(username);
        findElement(passwordInput).sendKeys(password);
        click(loginButton);
        return getText(errorLoginMessage);
    }
}
