package pages;

import io.qameta.allure.Step;
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


    @Step("open Overview Page at SauceDemo")
    public OverviewPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-two.html");
        return this;
    }

    public OverviewPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BUTTON));
        } catch (TimeoutException var2) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + CART_BUTTON);
        }

        return this;
    }

    @Step("finish purchase in SauceDemo")
    public void finish() {
        driver.findElement(CART_BUTTON).click();
        driver.findElement(By.className("pony_express"));
    }
}
