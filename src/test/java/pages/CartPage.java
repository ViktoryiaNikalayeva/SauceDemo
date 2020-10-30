package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CartPage extends BasePage {
    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']//div[@class='cart_quantity']";
    public static final By CHECKOUT_BUTTON = By.cssSelector(".checkout_button");
    public static final String URL = "https://www.saucedemo.com/cart.html";

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public CartPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CHECKOUT_BUTTON));
        } catch (TimeoutException var2) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + CHECKOUT_BUTTON);
        }
        return this;
    }

    @Step("open Cart Page at SauceDemo")
    public CartPage openPage() {
       driver.get("https://www.saucedemo.com/cart.html");
        return this;
    }

    public CartPage publicDetailsShouldBeLike(String productName, String quantity, String price) {
        String actualPrice = driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
        String actualQuantity = driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
        org.testng.Assert.assertEquals(actualPrice, price, "Price is not correct");
        org.testng.Assert.assertEquals(actualQuantity, quantity, "Price is not correct");
        return this;
    }
}