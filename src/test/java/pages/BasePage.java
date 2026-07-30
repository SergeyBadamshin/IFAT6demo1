package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    public static final String BASE_URL = "https://www.saucedemo.com/";
    public static final String DATA_TEST = "[data-test='%s']";
    private final By pageName = getByDataTest("title");

    public By getByDataTest(String dataTest) {
        return By.cssSelector(DATA_TEST.formatted(dataTest));
    }

    WebDriver driver;
    WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }

    public boolean pageIsOpen() {
        return driver.findElement(pageName).isDisplayed();
    }
}
