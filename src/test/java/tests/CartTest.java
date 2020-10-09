package tests;

import org.testng.annotations.Test;

public class CartTest extends BaseTest {
    public CartTest() {
    }

    @Test
    public void ProductsShouldBeAddedIntoCartAndCheckout() {
        loginPage.openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .isPageOpened()
                .publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
        checkoutPage
                .openPage()
                .isPageOpened();

    }


}
