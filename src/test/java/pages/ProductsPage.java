package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import static org.testng.Assert.assertEquals;

public class ProductsPage extends BasePage {
    String addToCartLocator = "//*[contains(text(),'%s')]/ancestor::div[@class='inventory_item']//button";
    public static final By PRODUCTS_LABEL = By.cssSelector(".product_label");
    public static final String URL = "https://www.saucedemo.com/inventory.html";
    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public ProductsPage openPage() {
        driver.get(URL);
        return this;
    }


    public ProductsPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(PRODUCTS_LABEL));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + PRODUCTS_LABEL);
        }
        return this;
    }

    public ProductsPage addToCart(String productName) {
        driver.findElement(By.xpath(String.format(addToCartLocator, productName))).click();
        return this;
    }
    public ProductsPage sortingByNameZA (String sortingMethod) {
      Select sorting = new Select (driver.findElement(By.className("product_sort_container")));
        sorting.selectByVisibleText("Name (Z to A)");
        assertEquals(sorting.getFirstSelectedOption().getText(), "Name (Z to A)");
      return this;
    }
    public ProductsPage sortingByNameAZ (String sortingMethod) {
        Select sorting = new Select (driver.findElement(By.className("product_sort_container")));
        sorting.selectByVisibleText("Name (A to Z)");
        assertEquals(sorting.getFirstSelectedOption().getText(), "Name (A to Z)");
        return this;
    }
    public ProductsPage sortingByPriceLowHigh (String sortingMethod) {
        Select sorting = new Select (driver.findElement(By.className("product_sort_container")));
        sorting.selectByVisibleText("Price (low to high)");
        assertEquals(sorting.getFirstSelectedOption().getText(), "Price (low to high)");
        return this;
    }
    public ProductsPage sortingByPriceHighLow (String sortingMethod) {
        Select sorting = new Select (driver.findElement(By.className("product_sort_container")));
        sorting.selectByVisibleText("Price (high to low)");
        assertEquals(sorting.getFirstSelectedOption().getText(), "Price (high to low)");
        return this;
    }
}
