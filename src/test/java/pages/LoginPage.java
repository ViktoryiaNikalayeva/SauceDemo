package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
    public static final String URL = "https://www.saucedemo.com/index.html";
    public static final By USERNAME_INPUT = By.id("user-name");
    public static final By PASSWORD_INPUT = By.id("password");
    public static final By LOGIN_BUTTON = By.id("login-button");


    public LoginPage(WebDriver driver) {
        super(driver);

    }

    public void openPage() {
        driver.get(URL);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void NullUsernamelogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("");
        driver.findElement(PASSWORD_INPUT).sendKeys("secret_sauce");
        driver.findElement(LOGIN_BUTTON).click();
    }

    public void NullPasswordlogin(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys("standard_user");
        driver.findElement(PASSWORD_INPUT).sendKeys("");
        driver.findElement(LOGIN_BUTTON).click();
    }



}
