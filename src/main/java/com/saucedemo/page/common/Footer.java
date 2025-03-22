package com.saucedemo.page.common;

import com.saucedemo.page.PageBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Footer extends PageBase {

    private final By footerText = By.cssSelector("[data-test=\"footer-copy\"]");
    
    public Footer(WebDriver driver) {
        super(driver);
    }

    public String getFooterText() {
        return getText(footerText);
    }
}
