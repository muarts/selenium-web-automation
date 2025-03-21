package com.saucedemo.page;

import com.saucedemo.testdata.Product;
import com.saucedemo.testdata.ProductSortOption;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static com.saucedemo.util.Helper.getRandomNumber;

public class ProductsPage extends PageBase {

    private final By pageTitle = By.cssSelector("[data-test=\"title\"]");
    private final By productItemName = By.cssSelector("[data-test=\"inventory-item-name\"]");
    private final By productDetail = By.cssSelector("[data-test=\"inventory-item-desc\"]");
    private final By productsSortContainer = By.cssSelector("[data-test=\"product-sort-container\"]");
    private final By productsSortZtoAOption = By.cssSelector("[value=\"za\"]");
    private final By productsSortLowToHighOption = By.cssSelector("[value=\"lohi\"]");
    private final By productsSortHighToLowOption = By.cssSelector("[value=\"hilo\"]");
    private final By productPrice = By.cssSelector("[data-test='inventory-item-price']");
    private final By shoppingCartButton = By.id("shopping_cart_container");
    private final By productDescription = By.cssSelector("[data-test=\"inventory-item-description\"]");
    private final By addToCartButton = By.cssSelector("[name*=\"add-to-cart\"]");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public CartPage clickShoppingCardButton() {
        click(shoppingCartButton);
        return new CartPage(driver);
    }

    public String getTextOfPageTitle() {
        return getText(pageTitle);
    }

    public List<String> getNamesOfAllProductsListed() {
        return getTextsOfAllElements(productItemName);
    }

    public List<Double> getPricesOfAllProductsListed() {
        List<String> stringPrices = getTextsOfAllElements(productPrice);
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

    public Product addProductToTheCart() {
        WebElement productDescriptionElement = findElements(productDescription).get(getRandomNumber(0, 5));
        WebElement addToCart = findElement(productDescriptionElement).findElement(addToCartButton);
        addToCart.click();
        Product product = new Product();
        product.setProductName(getText(findElement(productDescriptionElement).findElement(productItemName)));
        product.setProductPrice(getText(findElement(productDescriptionElement).findElement(productPrice)));
        product.setProductDetail(getText(findElement(productDescriptionElement).findElement(productDetail)));
        return product;
    }

}
