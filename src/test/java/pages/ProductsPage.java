package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div" +
            "[@class='inventory_item']//child::*[text()='Add to cart']";
    private final By counter = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-badge"));
    private final By cartIcon = By.cssSelector(DATA_TEST_PATTERN.formatted("shopping-cart-link"));
    private final By addToCartBtn = By.xpath(TEXT_LOCATOR_PATTERN.formatted("Add to cart"));

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    @Step("Добавить товар {goodsName} в корзину")
    public void addToCart(final String goodsName) {
        By goods = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(goods).click();
    }

    @Step("Добавить товар с индексом {goodsIndex} в корзину")
    public void addToCart(int goodsIndex) {
        driver.findElements(addToCartBtn).get(goodsIndex).click();
    }

    @Step("Получить количество товаров в счетчике корзины")
    public String checkCounterValue() {
        return driver.findElement(counter).getText();
    }

    @Step("Получить цвет счетчика корзины")
    public String checkCounterColorValue() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    @Step("Перейти в корзину")
    public void switchToCart() {
        driver.findElement(cartIcon).click();
    }
}
