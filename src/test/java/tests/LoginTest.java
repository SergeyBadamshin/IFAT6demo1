package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void correctLoginAndPassword() {
        loginPage.login("standard_user", "secret_sauce");
        String nameOfNewPage = driver.findElement(By.xpath("//span[@data-test='title']")).getText();
        assertEquals(nameOfNewPage, "Products");
    }

    @Test
    public void lockedUserLogin() {
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test
    public void emptyUserLogin() {
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }

    @Test
    public void emptyPasswordLogin() {
        loginPage.login("standard_user", "");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Password is required");
    }

    @Test
    public void wrongPasswordLogin() {
        loginPage.login("standard_user", "standard_user");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username and password do not match any user in this service");
    }

    @Test
    public void emptyUserAndPasswordLogin() {
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.getErrorMessageText(), "Epic sadface: Username is required");
    }
}
