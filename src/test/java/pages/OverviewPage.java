package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class OverviewPage extends BasePage {

    public static final String URL = "https://www.saucedemo.com/checkout-step-two.html";
    public static final By CART_BUTTON = By.cssSelector(".cart_button");


    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public OverviewPage openPage() {
        driver.get(URL);
        return this;
    }

    public OverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + CART_BUTTON);
        }
        return this;
    }
    public void finish () {
        driver.findElement(CART_BUTTON).click();
        driver.findElement(By.className("pony_express"));

    }

}
