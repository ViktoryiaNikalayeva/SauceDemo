package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


import static org.testng.Assert.assertEquals;

public class CheckoutTest extends BaseTest {


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
    }


    @DataProvider
    public Object[][] sortVars() {
        return new Object[][]{
                {"", LAST_NAME, POSTAL_CODE, "Error: First Name is required"},
                {FIRST_NAME, "", POSTAL_CODE, "Error: Last Name is required"},
                {FIRST_NAME, LAST_NAME, "", "Error: Postal Code is required"},
                {"", "", POSTAL_CODE, "Error: First Name is required"},
                {FIRST_NAME, "", "", "Error: Last Name is required"},
                {"", LAST_NAME, "", "Error: First Name is required"}
        };
    }

    @Test(dataProvider = "sortVars", description = "trying to enter wrong data")
    public void sortVars(String firstname, String lastname, String postalcode, String errorMessage) {
        checkoutPage
                .openPage()
                .isPageOpened()
                .checkout(firstname, lastname, postalcode);
        assertEquals(checkoutPage.getErrorMessageCheckout().getText(), errorMessage);
    }
}

