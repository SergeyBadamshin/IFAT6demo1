package tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import user.User;
import user.UserFactory;

import static enums.ErrorMessage.*;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

@Epic("Интернет-магазин")
@Feature("Авторизация")
@Owner("Бадамшин Сергей sergeybadms@gmail.com")
public class LoginTest extends BaseTest {

    @Story("Удачная авторизация")
    @Test(priority = 1)
    @Severity(SeverityLevel.BLOCKER)
    @TmsLink("IFAT6demo1")
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
                {UserFactory.withIncorrectUsername(), ERROR_WRONG_INPUT.getMessage()},
                {UserFactory.withIncorrectPassword(), ERROR_WRONG_INPUT.getMessage()},
                {UserFactory.withLockedAdminPermission(), ERROR_LOCKED_USER.getMessage()},
                {new User("","secret_sauce"), ERROR_USER_REQUIRED.getMessage()},
                {new User("standard_user",""), ERROR_PASSWORD_REQUIRED.getMessage()},
                {new User("",""), ERROR_USER_REQUIRED.getMessage()}
        };
    }

    @Story("Неудачная авторизация")
    @Test(priority = 2, dataProvider = "loginData")
    @Severity(SeverityLevel.BLOCKER)
    public void incorrectLogin(User user, String errorMsg) {
        System.out.println("LoginTest.IncorrectLogin running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(user);
        assertTrue(loginPage.isErrorDisplayed());
        assertEquals(loginPage.getErrorText(), errorMsg);
    }
}
