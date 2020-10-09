package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class LoginPage extends BasePage {
    public static final String URL = "https://www.saucedemo.com/index.html";
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public LoginPage openPage() {
        driver.get(URL);
        return this;
    }

    public LoginPage isPageOpened() {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(LOGIN_BUTTON));
        } catch (TimeoutException ex) {
            Assert.fail("Страница не загрузилась. Не найдена кнопка по локатору" + LOGIN_BUTTON);
        }
        return this;
    }

    public LoginPage attemptToLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
        return this;
    }

    public ProductsPage login(String username, String password) {
        attemptToLogin(username, password);
        return new ProductsPage(driver);
    }

    public void NullUsernameLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void NullPasswordLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("");
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void UnknownUsernameLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("bzbz");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }
    public void UnknownPasswordLogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("bzbz");
        driver.findElement(LOGIN_BUTTON).click();
    }
}
