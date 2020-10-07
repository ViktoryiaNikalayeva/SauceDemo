package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {
    @Test

    public void NullUsernameLoginTest() {
        loginPage.openPage();
        loginPage.NullUsernameLogin("", PASSWORD);
        WebElement ErrorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > h3"));

    }

    @Test

    public void NullPasswordLoginTest() {
        loginPage.openPage();
        loginPage.NullPasswordLogin(USERNAME, "");
        WebElement ErrorMessage = driver.findElement(By.cssSelector("#login_button_container > div > form > h3"));

    }


}
