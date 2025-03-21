package com.saucedemo.page.common;

import com.saucedemo.page.LoginPage;
import com.saucedemo.page.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SideBar extends PageBase  {

    private final By logoutButton = By.cssSelector("[data-test=\"logout-sidebar-link\"]");
    private final By sideBarButton = By.id("react-burger-menu-btn");

    public SideBar(WebDriver driver) {
        super(driver);
    }

    public LoginPage clickLogoutButton() {
        click(sideBarButton);
        click(logoutButton);
        return new LoginPage(driver);
    }
}
