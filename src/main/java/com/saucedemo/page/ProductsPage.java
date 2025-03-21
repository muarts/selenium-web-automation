package com.saucedemo.page;

import com.saucedemo.ProductSortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.List;

public class ProductsPage extends PageBase {

    private final By pageTitle = By.cssSelector("[data-test=\"title\"]");
    private final By productItemName = By.cssSelector("[data-test=\"inventory-item-name\"]");
    private final By productsSortContainer = By.cssSelector("[data-test=\"product-sort-container\"]");
    private final By productsSortZtoAOption = By.cssSelector("[value=\"za\"]");
    private final By productsSortLowToHighOption = By.cssSelector("[value=\"lohi\"]");
    private final By productsSortHighToLowOption = By.cssSelector("[value=\"hilo\"]");
    private final By productPrices = By.cssSelector("[data-test='inventory-item-price']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfPageTitle() {
        return getText(pageTitle);
    }

    public List<String> getNamesOfAllProductsListed() {
        return getTextsOfAllElements(productItemName);
    }

    public List<Double> getPricesOfAllProductsListed() {
        List<String> stringPrices = getTextsOfAllElements(productPrices);
        return stringPrices.stream()
                .map(priceElement -> priceElement.replace("$", "")) // Remove "$" symbol
                .map(Double::parseDouble)
                .toList();
    }

    public void sortProducts(ProductSortOption productSortOption) {
        click(productsSortContainer);
        switch (productSortOption) {
            case ProductSortOption.NAME_Z_TO_A:
                click(productsSortZtoAOption);
                break;
            case ProductSortOption.PRICE_LOW_TO_HIGH:
                click(productsSortLowToHighOption);
                break;
            case ProductSortOption.PRICE_HIGH_TO_LOW:
                click(productsSortHighToLowOption);
                break;
        }
    }

}
