import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;


public class SauceDemoHW {

    WebDriver driver;

    @BeforeMethod

    public void setup() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setHeadless(false);
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

   @Test
    public void SauceDemo1() {
        driver.get("https://www.saucedemo.com/index.html");
        WebElement UserName = driver.findElement(By.id("user-name"));
        WebElement Password = driver.findElement(By.id("password"));
        WebElement Login = driver.findElement(By.id("login-button"));
        WebElement All = driver.findElement(By.tagName("div"));
    }

    @Test
    public void SauceDemo2() {
        driver.get("https://www.saucedemo.com/inventory.html");
        WebElement PW = driver.findElement(By.className("page_wrapper"));
        WebElement Peek = driver.findElement(By.className("peek"));
        WebElement MenuButton = driver.findElement(By.id("menu_button_container"));
        WebElement InvContainer = driver.findElement(By.id("inventory_container"));
        WebElement Product1 = driver.findElement(By.xpath("//*[@id='item_4_title_link']"));
        WebElement Product2 = driver.findElement(By.cssSelector("#item_0_title_link"));
        WebElement Product3 = driver.findElement(By.id("item_1_title_link"));
        WebElement Product4 = driver.findElement(By.cssSelector("#item_5_title_link"));
        WebElement Product5 = driver.findElement(By.cssSelector("#item_2_title_link"));
        WebElement Product6 = driver.findElement(By.cssSelector("#item_3_title_link"));
        WebElement FR = driver.findElement(By.className("footer_robot"));
        WebElement TW = driver.findElement(By.className("social_twitter"));
        WebElement FB = driver.findElement(By.className("social_facebook"));
        WebElement LI = driver.findElement(By.className("social_linkedin"));
        WebElement PST = driver.findElement(By.className("product_sort_container"));
        WebElement Footer = driver.findElement(By.className("footer"));

    }

    @Test
    public void SauceDemo3() {
        driver.get("https://www.saucedemo.com/cart.html");
        WebElement CQL = driver.findElement(By.className("cart_quantity_label"));
        WebElement CDL = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_list > div.cart_desc_label"));
        WebElement CCC = driver.findElement(By.cssSelector("#cart_contents_container > div > div.cart_footer > a.btn_action.checkout_button"));


    }

    @Test
    public void SauceDemo4() {
        driver.get("https://www.saucedemo.com/checkout-step-one.html");
        WebElement FirstName = driver.findElement(By.id("first-name"));
        WebElement LastName = driver.findElement(By.id("last-name"));
        WebElement PostalCode = driver.findElement(By.id("postal-code"));
        WebElement Cancel = driver.findElement(By.linkText("CANCEL"));
        WebElement FC = driver.findElement(By.className("footer_copy"));

    }

    @Test
    public void SauceDemo5() {
        driver.get("https://www.saucedemo.com/inventory-item.html?id=4");
        WebElement Name = driver.findElement(By.className("inventory_details_name"));
        WebElement Price = driver.findElement(By.className("inventory_details_price"));
        Name.getText();
        Price.getText();
        System.out.println("Наименование товара" + " " + Name.getText());
        System.out.println("Цена товара" + " " + Price.getText());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();

    }
}
