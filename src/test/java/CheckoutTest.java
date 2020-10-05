import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;


public class CheckoutTest extends BaseTest {

    @Test

    public void NullFirstNameCheckoutTest() {
        checkoutPage.openPage();
        checkoutPage.NullFirstNameCheckout("", "BH", "HZ");
        WebElement Errormessage = driver.findElement(By.cssSelector("#checkout_info_container > div > form > h3"));

    }

    @Test

    public void NullLastNameCheckoutTest() {
        checkoutPage.openPage();
        checkoutPage.NullLastNameCheckout("AJ", "", "HZ");
        WebElement Errormessage = driver.findElement(By.cssSelector("#checkout_info_container > div > form > h3"));

    }

    @Test

    public void NullPostalCodeCheckoutTest() {
        checkoutPage.openPage();
        checkoutPage.NullPostalCodeCheckout("AJ", "BH", "");
        WebElement Errormessage = driver.findElement(By.cssSelector("#checkout_info_container > div > form > h3"));

    }
}
