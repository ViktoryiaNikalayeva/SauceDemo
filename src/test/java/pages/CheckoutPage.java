package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {
    public static final By FIRST_NAME_INPUT = By.id("first-name");
    public static final By LAST_NAME_INPUT = By.id("last-name");
    public static final By POSTAL_CODE_INPUT = By.id("postal-code");
    public static final By CART_BUTTON = By.cssSelector(".cart_button");


    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @Step("open Checkout Page at SauceDemo")
    public CheckoutPage openPage() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        return this;
    }

    public CheckoutPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BUTTON));
        } catch (TimeoutException var2) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + CART_BUTTON);
        }

        return this;
    }

    @Step("enter first, last name, postal code and finish checkout")
    public CheckoutPage checkout(String firstname, String lastname, String postalcode) {
        driver.findElement(FIRST_NAME_INPUT).sendKeys(firstname);
        driver.findElement(LAST_NAME_INPUT).sendKeys(lastname);
        driver.findElement(POSTAL_CODE_INPUT).sendKeys(postalcode);
        driver.findElement(CART_BUTTON).click();
        return this;
    }

    public WebElement getErrorMessageCheckout() {
        return driver.findElement(By.xpath("//h3[contains(.,'required')]"));
    }
}
