package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;


public class LoginTest extends BaseTest {


    @Test
    public void userShouldBeLoginUser() {
        loginPage
                .openPage()
                .isPageOpened()
                .login(USERNAME, PASSWORD);
    }

    @DataProvider
    public Object[][] loginVars() {
        return new Object[][]{
                {USERNAME, "", "Epic sadface: Password is required"},
                {"", PASSWORD, "Epic sadface: Username is required"},
                {"Lock", "Up78", "Epic sadface: Username and password do not match any user in this service"},
                {"", "", "Epic sadface: Username is required"},
                {"Lock", "", "Epic sadface: Password is required" },
                {"", "Up78", "Epic sadface: Username is required" }
        };
    }

    @Test(dataProvider = "loginVars")
    public void loginVars(String username, String password, String errorMessage) {
        loginPage
                .openPage()
                .isPageOpened()
                .login(username, password);
        assertEquals(loginPage.getErrorMessageLogin().getText(), errorMessage);
    }
}
