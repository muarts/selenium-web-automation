package com.saucedemo;

import com.saucedemo.page.LoginPage;
import com.saucedemo.page.ProductsPage;
import org.testng.annotations.Test;

import static com.saucedemo.CommonConstant.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginPageTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(VALID_USERNAME, VALID_PASSWORD);
        assertThat(productsPage.getTextOfPageTitle(), is(equalTo(PRODUCTS_PAGE_TITLE)));
    }

    @Test
    public void testReturnAnErrorWhenUsernameAndOrPasswordInvalid() {
        LoginPage loginPage = new LoginPage(driver);
        String errorLoginMessage = loginPage.loginError("invalid_username", "invalid_password");

        assertThat(errorLoginMessage, is(equalTo(ERROR_LOGIN_MESSAGE)));
    }
}
