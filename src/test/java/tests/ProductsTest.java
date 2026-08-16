package tests;

import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;
import user.UserFactory;

import java.util.List;

import static enums.TitleNaming.PRODUCTS;
import static org.testng.Assert.assertEquals;

@Epic("Интернет-магазин")
@Feature("Страница товаров")
public class ProductsTest extends BaseTest {

    List<String> goodsList =
            List.of("Sauce Labs Onesie",
                    "Sauce Labs Bike Light",
                    "Sauce Labs Bolt T-Shirt");

    @Story("Проверка отображения индикатора корзины после добавления товаров")
    @Test
    public void checkGoodsAdded() {
        System.out.println("ProductsTest.checkGoodsAdded running in thread: " + Thread.currentThread().getId());

        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        assertEquals(productsPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        productsPage.addToCart(0);
        for (String goodName : goodsList) {
            productsPage.addToCart(goodName);
        }

        assertEquals(productsPage.checkCounterValue(), "4");
        assertEquals(productsPage.checkCounterColorValue(), "rgba(226, 35, 26, 1)");
    }
}
