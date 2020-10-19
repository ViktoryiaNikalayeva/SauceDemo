package tests;

import org.testng.annotations.Test;

public class OverviewTest extends BaseTest {


    @Test
    public void purchaseShouldBeFinished() {
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
                .checkout(FIRST_NAME, LAST_NAME, POSTAL_CODE);
        overviewPage
                .openPage()
                .isPageOpened()
                .finish();
    }
}
