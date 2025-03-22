package com.saucedemo;

import com.saucedemo.page.LoginPage;
import com.saucedemo.page.ProductsPage;
import com.saucedemo.util.DataProviders;
import org.testng.annotations.Test;

import static com.saucedemo.testdata.CommonConstant.*;
import static com.saucedemo.util.Helper.getRandomString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class LoginPageTest extends TestBase {

    @Test
    public void testLogin() {
        LoginPage loginPage = new LoginPage(driver);
        ProductsPage productsPage = loginPage.login(STANDARD_USER_USERNAME, VALID_PASSWORD);
        assertThat(productsPage.getTextOfPageTitle(), is(equalTo(PRODUCTS_PAGE_TITLE)));
    }

    @Test(dataProvider = "usernameAndPasswordDataProvider", dataProviderClass = DataProviders.class)
    public void testReturnAnErrorWhenUsernameAndOrPasswordInvalid(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        String errorLoginMessage = loginPage.loginError(username, password);

        assertThat(errorLoginMessage, is(equalTo(ERROR_LOGIN_MESSAGE)));
    }

    @Test
    public void testLockedOutUser() {
        LoginPage loginPage = new LoginPage(driver);
        String errorLoginMessage = loginPage.loginError(LOCKED_OUT_USER_USERNAME, VALID_PASSWORD);

        assertThat(errorLoginMessage, is(equalTo(ERROR_USER_LOCKED_OUT)));
    }

    @Test
    public void testErrorMessageIsCorrect() {
        LoginPage loginPage = new LoginPage(driver);
        String errorLoginMessage = loginPage.loginError(getRandomString(), getRandomString());

        assertThat(errorLoginMessage, is(equalTo(INCORRECT_ERROR_LOGIN_MESSAGE)));
    }
}
