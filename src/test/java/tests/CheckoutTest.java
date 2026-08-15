package tests;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import user.UserFactory;
import java.util.List;

import static checkoutuser.checkoutUserFactory.validUser;
import static enums.ProductsNaming.*;
import static enums.TitleNaming.*;

public class CheckoutTest extends BaseTest {
    List<String> GoodsInCart =
            List.of(BACKPACK.getProductName(),
                    BIKE_LIGHT.getProductName(),
                    BOLT_T_SHIRT.getProductName());

    @Test
    public void checkoutTest() {
        System.out.println("CheckoutTest.correctCheckout running in thread: " + Thread.currentThread().getId());
        SoftAssert softAssert = new SoftAssert();
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        softAssert.assertEquals(productsPage.getNamePage(), PRODUCTS.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        for (String goodName : GoodsInCart) {
            productsPage.addToCart(goodName);
        }
        productsPage.switchToCart();
        softAssert.assertEquals(productsPage.getNamePage(), CART.getDisplayName(),
                "Name of the page doesn't correspond to the expected");

        softAssert.assertEquals(cartPage.getProductsNames().size(), 3);
        softAssert.assertEquals(cartPage.getProductsNames(), GoodsInCart);
        cartPage.clickCheckout();
        softAssert.assertEquals(productsPage.getNamePage(), CHECKOUT.getDisplayName(),
                "Name of the page doesn't correspond to the expected");
        checkoutPage.checkout(validUser());
        softAssert.assertAll();
    }
}
