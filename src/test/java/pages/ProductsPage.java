package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductsPage extends BasePage {
    private final By pageName = getByDataTest("title");
    private static final String ADD_TO_CART = "//*[text()='%s']//ancestor::div" +
            "[@class='inventory_item']//child::*[text()='Add to cart']";
    private final By counter = getByDataTest("shopping-cart-badge");
    private final By cartIcon = getByDataTest("shopping-cart-link");
    private final By addToCartBtn = By.xpath("//*[text()='Add to cart']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getNamePage() {
        return driver.findElement(pageName).getText();
    }

    public void addToCart(final String goodsName) {
        By goods = By.xpath(ADD_TO_CART.formatted(goodsName));
        driver.findElement(goods).click();
    }

    public void addToCart(int goodsIndex) {
        driver.findElements(addToCartBtn).get(goodsIndex).click();
    }

    public String checkCounterValue() {
        return driver.findElement(counter).getText();
    }

    public String checkCounterColorValue() {
        return driver.findElement(counter).getCssValue("background-color");
    }

    public void switchToCart() {
        driver.findElement(cartIcon).click();
    }
}
