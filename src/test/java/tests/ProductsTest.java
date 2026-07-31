package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class ProductsTest extends BaseTest {

    List<String> goodsList =
            List.of("Sauce Labs Onesie",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Bolt T-Shirt");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertTrue(productsPage.pageIsOpen(), "Страница Products не открылась");
        productsPage.addToCart(0);
        for (String goodName : goodsList) {
            productsPage.addToCart(goodName);
        }

        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColorValue(), "rgba(226, 35, 26, 1)");
    }
}
