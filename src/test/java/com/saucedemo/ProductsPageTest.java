package com.saucedemo;

import com.saucedemo.page.ProductsPage;
import org.testng.annotations.Test;

import java.util.Collections;
import java.util.List;
import static com.saucedemo.CommonConstant.PRODUCTS_PAGE_PATH;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

public class ProductsPageTest extends TestBase {

    @Test
    public void testProductsFilteringAToZWhenUserLandsToThePage() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.bypassLoginAndGetHere(PRODUCTS_PAGE_PATH);
        List<String> products = productsPage.getNamesOfAllProductsListed();
        List<String> aToZSortedProducts = products.stream().sorted(String::compareToIgnoreCase).toList();

        assertThat(products, is(equalTo(aToZSortedProducts)));
    }

    @Test
    public void testSortProductsByNameZtoA() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.bypassLoginAndGetHere(PRODUCTS_PAGE_PATH);
        productsPage.sortProducts(ProductSortOption.NAME_Z_TO_A);

        List<String> products = productsPage.getNamesOfAllProductsListed();

        List<String> zToASortedProducts = products.stream()
                .sorted(Collections.reverseOrder(String::compareToIgnoreCase))
                .toList();

        assertThat(products, is(equalTo(zToASortedProducts)));
    }

    @Test
    public void testSortProductsByPriceLowToHigh() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.bypassLoginAndGetHere(PRODUCTS_PAGE_PATH);
        productsPage.sortProducts(ProductSortOption.PRICE_LOW_TO_HIGH);

        List<Double> pricesOfAllProductsListed = productsPage.getPricesOfAllProductsListed();
        List<Double> lowToHighSortedProducts = pricesOfAllProductsListed.stream()
                .sorted()
                .toList();

        assertThat(pricesOfAllProductsListed, is(equalTo(lowToHighSortedProducts)));
    }

    @Test
    public void testSortProductsByPriceHighToLow() {
        ProductsPage productsPage = new ProductsPage(driver);
        productsPage.bypassLoginAndGetHere(PRODUCTS_PAGE_PATH);
        productsPage.sortProducts(ProductSortOption.PRICE_HIGH_TO_LOW);

        List<Double> pricesOfAllProductsListed = productsPage.getPricesOfAllProductsListed();
        List<Double> highToLowSortedProducts = pricesOfAllProductsListed.stream()
                .sorted((a, b) -> Double.compare(b, a))
                .toList();

        assertThat(pricesOfAllProductsListed, is(equalTo(highToLowSortedProducts)));
    }
}
