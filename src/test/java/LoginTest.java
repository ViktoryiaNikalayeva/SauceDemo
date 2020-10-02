
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {
    @Test

    public void NullUsernameLoginTest() {
        loginPage.openPage();
        loginPage.NullUsernamelogin("", PASSWORD);
        WebElement Errormessage = driver.findElement(By.cssSelector("#login_button_container > div > form > h3"));

    }

    @Test

    public void NullPasswordLoginTest() {
        loginPage.openPage();
        loginPage.NullPasswordlogin(USERNAME, "");
        WebElement Errormessage = driver.findElement(By.cssSelector("#login_button_container > div > form > h3"));

    }


}
