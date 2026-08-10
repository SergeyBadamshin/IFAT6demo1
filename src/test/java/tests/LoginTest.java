package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void correctLoginAndPassword() {
        System.out.println("LoginTest.correctLogin running in thread: " + Thread.currentThread().getId());
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertEquals(productsPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withIncorrectUsername(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withIncorrectPassword(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withLockedAdminPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {new User("","secret_sauce"), "Epic sadface: Username is required"},
                {new User("standard_user",""), "Epic sadface: Password is required"},
                {new User("",""), "Epic sadface: Username is required"}
        };
    }

    @Test(priority = 2, dataProvider = "loginData")
    public void incorrectLogin(User user, String errorMsg) {
        System.out.println("LoginTest.IncorrectLogin running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMsg);
    }
}
