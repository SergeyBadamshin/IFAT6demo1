package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import user.UserFactory;

import java.util.List;

import static enums.TitleNaming.CART;
import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.*;

@Epic("Интернет-магазин")
@Feature("Корзина")
public class CartTest extends BaseTest {
    List<String> goodsList =
            List.of("Sauce Labs Backpack",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Bolt T-Shirt");

    @Story("Добавление 3-х товаров в корзину")
    @Test
    public void checkGoodsAdded() {
        System.out.println("CartTest.checkGoodsAdded running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertEquals(productsPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        for (String goodName : goodsList) {
            productsPage.addToCart(goodName);
        }
        productsPage.switchToCart();
        assertEquals(productsPage.getNamePage(), CART.getDisplayName(),
                "Name of the page doesn't correspond to the expected");

        assertFalse(cartPage.getProductsNames().isEmpty());
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Bolt T-Shirt"));
        assertEquals(cartPage.getProductsNames(), goodsList);
    }
}
