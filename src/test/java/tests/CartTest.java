package tests;

import org.testng.annotations.Test;
import user.UserFactory;

import java.util.List;

import static org.testng.Assert.*;

public class CartTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Backpack",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Bolt T-Shirt");

    @Test
    public void checkGoodsAdded() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        for (String goodName : goodsList) {
            productsPage.addToCart(goodName);
        }
        productsPage.switchToCart();
        assertEquals(cartPage.getProductsNames(), goodsList);
    }
}
