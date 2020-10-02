package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static org.testng.Assert.assertEquals;

public class CartPage extends BasePage {
    public CartPage(WebDriver driver) {
        super(driver);
    }

    String priceLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='inventory_item_price']";
    String quantityLocator = "//*[contains(text(),'%s')]/ancestor::*[@class='cart_item']" +
            "//div[@class='cart_quantity']";


    public static final String URL = "https://www.saucedemo.com/cart.html";

    public void openPage() {
        driver.get(URL);
    }

    public void publicDetailsShouldBeLike(String productName, String quantity, String price) {
        String actualPrice = driver.findElement(By.xpath(String.format(priceLocator, productName))).getText();
        String actualQuantity = driver.findElement(By.xpath(String.format(quantityLocator, productName))).getText();
        assertEquals(actualPrice, price, "Price is not correct");
        assertEquals(actualQuantity, quantity, "Price is not correct");

    }
}
