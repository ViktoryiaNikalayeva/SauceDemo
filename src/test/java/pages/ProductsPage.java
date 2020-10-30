package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class ProductsPage extends BasePage {
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    public static final By PRODUCTS_LABEL = By.cssSelector(".product_label");
    public static final String URL = "https://www.saucedemo.com/inventory.html";

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("open Products Page at SauceDemo")
    public ProductsPage openPage() {
        driver.get("https://www.saucedemo.com/inventory.html");
        return this;
    }

    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_LABEL));
        } catch (TimeoutException var2) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + PRODUCTS_LABEL);
        }

        return this;
    }

    @Step("add to cart products")
    public ProductsPage addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
        return this;
    }

    public WebElement getFirstItem() {
        return driver.findElements(By.className("inventory_item_name")).get(0);
    }

    public ProductsPage sort(String sortingMethod) {
        Select sorting = new Select(driver.findElement(By.className("product_sort_container")));
        sorting.selectByVisibleText(sortingMethod);
        return this;
    }
}
