package com.saucedemo;

import com.saucedemo.page.common.Footer;
import org.testng.annotations.Test;

import static com.saucedemo.testdata.CommonConstant.FOOTER_TEXT;
import static com.saucedemo.testdata.CommonConstant.PRODUCTS_PAGE_PATH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class FooterTest extends TestBase {

    @Test
    public void testFooterTextIsVisible() {
        Footer footer = new Footer(driver);
        footer.bypassLoginAndGetHere(PRODUCTS_PAGE_PATH);
        assertThat(footer.getFooterText(), is(equalTo(FOOTER_TEXT)));
    }
}
