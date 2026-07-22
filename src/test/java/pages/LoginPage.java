package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final By loginInput = By.xpath("//*[@id='user-name']");
    private final By passwordInput = By.cssSelector("#password");
    private final By loginBtn = By.cssSelector("[id='login-button']");
    private final By errorMassage = By.cssSelector("h3[data-test='error']");
    WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public void login(final String userName, final String password) {
        driver.findElement(loginInput).sendKeys(userName);
        driver.findElement(passwordInput).sendKeys(password);
        driver.findElement(loginBtn).click();
    }

    public String getErrorMessageText() {
        return driver.findElement(errorMassage).getText();
    }
}
