package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    public void isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(CART_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + CART_BUTTON);
        }
    }

    public static final By FIRST_NAME = By.id("first-name");
    public static final By LAST_NAME = By.id("last-name");
    public static final By POSTAL_CODE = By.id("postal-code");
    public static final By CONTINUE = By.xpath("//*[@id='checkout_info_container']/div/form/div[2]/input");
    public static final By CART_BUTTON = By.cssSelector(".cart_button");

    public static final String URL = "https://www.saucedemo.com/checkout-step-one.html";

    public void openPage() {
        driver.get(URL);
    }

    public void checkout(String firstname, String lastname, String postal_code) {
        driver.findElement(FIRST_NAME).sendKeys("AJ");
        driver.findElement(LAST_NAME).sendKeys("BH");
        driver.findElement(POSTAL_CODE).sendKeys("HZ");
        driver.findElement(CONTINUE).click();
    }

    public void NullFirstNameCheckout(String firstname, String lastname, String postal_code) {
        driver.findElement(FIRST_NAME).sendKeys("");
        driver.findElement(LAST_NAME).sendKeys("BH");
        driver.findElement(POSTAL_CODE).sendKeys("HZ");
        driver.findElement(CONTINUE).click();
    }

    public void NullLastNameCheckout(String firstname, String lastname, String postal_code) {
        driver.findElement(FIRST_NAME).sendKeys("AJ");
        driver.findElement(LAST_NAME).sendKeys("");
        driver.findElement(POSTAL_CODE).sendKeys("HZ");
        driver.findElement(CONTINUE).click();
    }

    public void NullPostalCodeCheckout(String firstname, String lastname, String postal_code) {
        driver.findElement(FIRST_NAME).sendKeys("AJ");
        driver.findElement(LAST_NAME).sendKeys("BH");
        driver.findElement(POSTAL_CODE).sendKeys("");
        driver.findElement(CONTINUE).click();
    }


}
