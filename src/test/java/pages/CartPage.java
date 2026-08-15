package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {
    private final By checkoutButton = By.cssSelector(DATA_TEST_PATTERN.formatted("checkout"));
    private final By inventoryItemName = By.cssSelector(".inventory_item_name ");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    @Step("Получить список наименований товаров в корзине")
    public ArrayList<String> getProductsNames() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(inventoryItemName));
        List<WebElement> allProductsNames = driver.findElements(inventoryItemName);
        ArrayList<String> names = new ArrayList<>();

        for (WebElement productBlock : allProductsNames) {
            names.add(productBlock.getText());
        }
        return names;
    }

    public void clickCheckout() {
        wait.until(ExpectedConditions.elementToBeClickable(checkoutButton)).click();
    }
}
