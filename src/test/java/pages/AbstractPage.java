package pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractPage {
    public WebDriver driver;
    public WebDriverWait wait;

    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    public AbstractPage(WebDriver driver, String url) {
        this(driver);
        driver.get(url);
    }

    public abstract AbstractPage isPageOpened();

    public void waitForPageLoaded() {
        ExpectedCondition var10001 = new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver)
                        .executeScript("return document.readyState", new Object[0])
                        .toString().equals("complete");
            }
        };
    }
}
