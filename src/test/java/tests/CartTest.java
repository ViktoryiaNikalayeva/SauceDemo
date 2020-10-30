package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {

    @Test (description = "add product")
    public void productsShouldBeAddedIntoCartAndCheckout() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .addToCart("Sauce Labs Fleece Jacket")
                .addToCart("Sauce Labs Backpack")
                .addToCart("Sauce Labs Bolt T-Shirt")
                .addToCart("Sauce Labs Bike Light")
                .addToCart("Sauce Labs Onesie")
                .addToCart("Test.allTheThings() T-Shirt (Red)");
        cartPage
                .openPage()
                .isPageOpened()
                .publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99")
                .publicDetailsShouldBeLike("Sauce Labs Backpack", "1", "29.99")
                .publicDetailsShouldBeLike("Sauce Labs Bolt T-Shirt", "1", "15.99")
                .publicDetailsShouldBeLike("Sauce Labs Bike Light", "1", "9.99")
                .publicDetailsShouldBeLike("Sauce Labs Onesie", "1", "7.99")
                .publicDetailsShouldBeLike("Test.allTheThings() T-Shirt (Red)", "1", "15.99");
        checkoutPage
                .isPageOpened();
    }
}
