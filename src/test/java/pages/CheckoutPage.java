package pages;

import checkoutuser.CheckoutUser;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import tests.BaseTest;

import static pages.BasePage.DATA_TEST_PATTERN;


public class CheckoutPage extends BasePage {
    private final By firstNameInput = By.cssSelector(DATA_TEST_PATTERN.formatted("firstName"));
    private final By lastNameInput = By.cssSelector(DATA_TEST_PATTERN.formatted("lastName"));
    private final By postalCodeInput = By.cssSelector(DATA_TEST_PATTERN.formatted("postalCode"));
    private final By continueBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("continue"));

    public CheckoutPage (WebDriver driver) {
        super(driver);
    }

    @Step("Вводим валидные данные для оформления заказа")
    public void checkout(CheckoutUser checkoutUser) {
        driver.findElement(firstNameInput).sendKeys(checkoutUser.getFirstName());
        driver.findElement(lastNameInput).sendKeys(checkoutUser.getFirstName());
        driver.findElement(postalCodeInput).sendKeys(checkoutUser.getPostalCode());
        driver.findElement(continueBtn).click();
    }
}

