package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test(priority = 1)
    public void correctLoginAndPassword() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(productsPage.pageIsOpen(), "Страница Products не открылась");
        assertEquals(productsPage.getNamePage(), "Products",
                "Name of the page doesn't correspond to te expected");
    }

    @DataProvider()
    public Object[][] loginData() {
        return new Object[][]{
                {UserFactory.withIncorrectUsername(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withIncorrectPassword(), "Epic sadface: Username and password do not match any user in this service"},
                {UserFactory.withLockedAdminPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {UserFactory.withEmptyUsername(), "Epic sadface: Username is required"},
                {UserFactory.withEmptyPassword(), "Epic sadface: Password is required"},
                {UserFactory.withEmptyUsernameAndPassword(), "Epic sadface: Username is required"}
        };
    }

    @Test(priority = 2, dataProvider = "loginData")
    public void incorrectLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMsg);
    }
}
