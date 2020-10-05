package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    public static final By PRODUCTS_LABEL = By.cssSelector(".product_label");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + PRODUCTS_LABEL);
        }
    }

    public void addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
    }
}
