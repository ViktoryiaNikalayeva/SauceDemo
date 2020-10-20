package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class LoginTest extends BaseTest {


    @Test

    public void UserShouldBeLoginUser() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
    }

    @Test
    public void NullUsernameLoginTest() {
        loginPage.openPage();
        loginPage.NullUsernameLogin("", PASSWORD);
        WebElement ErrorMessage = driver.findElement(By.xpath("//h3[starts-with(.,'Epi')]"));

    }

    @Test

    public void NullPasswordLoginTest() {
        loginPage.openPage();
        loginPage.NullPasswordLogin(USERNAME, "");
        WebElement ErrorMessage = driver.findElement(By.xpath("(//h3[contains(.,'Password')])"));

    }
    @Test

    public void UnknownUsernameLoginTest() {
        loginPage.openPage();
        loginPage.UnknownUsernameLogin("bzbz", PASSWORD);
        WebElement ErrorMessage = driver.findElement(By.xpath("(//h3[contains(.,'match')])"));

    }
    @Test

    public void UnknownPasswordLoginTest() {
        loginPage.openPage();
        loginPage.UnknownPasswordLogin(USERNAME, "bzbz");
        WebElement ErrorMessage = driver.findElement(By.xpath("(//h3[contains(.,'service')])"));

    }
}
