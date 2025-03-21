package com.saucedemo;

import com.saucedemo.page.LoginPage;
import com.saucedemo.page.ProductsPage;
import com.saucedemo.page.common.SideBar;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import static com.saucedemo.testdata.CommonConstant.PRODUCTS_PAGE_PATH;

public class SideBarTest extends TestBase {

    @Test
    public void testLogout() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.bypassLoginAndGetHere(PRODUCTS_PAGE_PATH);
        SideBar sideBar = new SideBar(driver);
        LoginPage loginPage = sideBar.clickLogoutButton();

        assertThat(loginPage.loginButtonDisplayed(), is(equalTo(Boolean.TRUE)));

    }
}
