package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {

    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + CHECKOUT_BUTTON);
        }
        return this;

    }

    public static final String URL = "https://www.saucedemo.com/cart.html";

    public CartPage openPage() {
        driver.get(URL);
        return this;
    }

    public void publicDetailsShouldBeLike(String productName, String quantity, String price) {
        String actualPrice = driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
        String actualQuantity = driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
        assertEquals(actualPrice, price, "Price is not correct");
        assertEquals(actualQuantity, quantity, "Price is not correct");


    }
}
