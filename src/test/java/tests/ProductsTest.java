package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ProductsTest extends BaseTest {


    @Test
    public void productsShouldBeAddedIntoCart() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .addToCart("Sauce Labs Fleece Jacket");
        cartPage
                .openPage()
                .isPageOpened()
                .publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
    }

    @Test
    public void productsShouldBeSortedByNameZATest() {
        WebElement firstItem = productsPage
                .openPage()
                .isPageOpened()
                .sort("Name (Z to A)")
                .getFirstItem();
        Assert.assertEquals(firstItem.getText(), "Test.allTheThings() T-Shirt (Red)");
    }

    @Test
    public void productsShouldBeSortedByNameAZTest() {
        WebElement firstItem = productsPage
                .openPage()
                .isPageOpened()
                .sort("Name (A to Z)")
                .getFirstItem();
        Assert.assertEquals(firstItem.getText(), "Sauce Labs Backpack");
    }

    @Test
    public void productsShouldBeSortedByPriceLowHighTest() {
        WebElement firstItem = productsPage
                .openPage()
                .isPageOpened()
                .sort("Price (low to high)")
                .getFirstItem();
        Assert.assertEquals(firstItem.getText(), "Sauce Labs Onesie");
    }

    @Test
    public void productsShouldBeSortedByPriceHighLowTest() {
        WebElement firstItem = productsPage
                .openPage()
                .isPageOpened()
                .sort("Price (high to low)")
                .getFirstItem();
        Assert.assertEquals(firstItem.getText(), "Sauce Labs Fleece Jacket");
    }
}
