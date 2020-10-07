package tests;

import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {

    @Test
    public void ProductsShouldBeAddedIntoCart() {
        loginPage.openPage();
        loginPage.login(USERNAME, PASSWORD);
        productsPage.addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage();
        cartPage.isPageOpened();
        cartPage.publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
        checkoutPage.openPage();
        checkoutPage.checkout("AJ", "BH", "HZ");

    }
}
