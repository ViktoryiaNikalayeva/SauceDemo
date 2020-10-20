package tests;

import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {

    @Test
    public void ProductsShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .addToCart("Sauce Labs Fleece Jacket");
        cartPage
                .openPage()
                .isPageOpened()
                .publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
        checkoutPage
                .openPage()
                .checkout("AJ", "BH", "HZ");
        overviewPage
                .openPage()
                .isPageOpened()
                .finish();


    }

}
