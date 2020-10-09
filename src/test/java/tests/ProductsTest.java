package tests;

import org.testng.annotations.Test;


public class ProductsTest extends BaseTest {

    @Test
    public void ProductsShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .login(USERNAME, PASSWORD)
                .isPageOpened()
                .addToCart("Sauce Labs Fleece Jacket");
        cartPage
                .openPage()
                .isPageOpened()
                .publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");

    }

    @Test
    public void productsShouldBeSortedByNameFromZToATest() {
        productsPage
                .openPage()
                .isPageOpened()
                .sortingByNameZA("Name (Z to A)");

    }
    @Test
    public void productsShouldBeSortedByNameFromAToZTest() {
        productsPage
                .openPage()
                .isPageOpened()
                .sortingByNameAZ("Name (A to Z)");

    }
    @Test
    public void productsShouldBeSortedByPriceLowHighTest() {
        productsPage
                .openPage()
                .isPageOpened()
                .sortingByPriceLowHigh("Price (low to high)");

    }
    @Test
    public void productsShouldBeSortedByPriceHighLowTest() {
        productsPage
                .openPage()
                .isPageOpened()
                .sortingByPriceHighLow("Price (high to low)");

    }
}
