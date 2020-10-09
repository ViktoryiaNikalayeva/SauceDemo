package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @Test
    public void ProductsShouldBeAddedIntoCart() {
        loginPage.openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD)
                .addToCart("Sauce Labs Fleece Jacket");
        cartPage.openPage()
                .isPageOpened()
                .publicDetailsShouldBeLike("Sauce Labs Fleece Jacket", "1", "49.99");
        checkoutPage.openPage()
                .isPageOpened()
                .checkout("AJ", "BH", "HZ");
        overviewPage.openPage()
                .isPageOpened();

    }

    @Test

    public void NullFirstNameCheckoutTest() {
        checkoutPage.openPage();
        checkoutPage.NullFirstNameCheckout("", "BH", "HZ");
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(.,'First')]"));

    }

    @Test

    public void NullLastNameCheckoutTest() {
        checkoutPage.openPage();
        checkoutPage.NullLastNameCheckout("AJ", "", "HZ");
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[starts-with(.,'Error')]"));

    }

    @Test

    public void NullPostalCodeCheckoutTest() {
        checkoutPage.openPage();
        checkoutPage.NullPostalCodeCheckout("AJ", "BH", "");
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[contains(.,'Postal')]"));

    }
}
