
package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OverviewPage extends BasePage {
    private final By productNames = By.cssSelector(".inventory_item_name");
    private final By productPrices = By.cssSelector(".inventory_item_price");
    private final By itemTotal = By.cssSelector(".summary_subtotal_label");
    private final By finishBtn = By.cssSelector(DATA_TEST_PATTERN.formatted("finish"));

    public OverviewPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductsNames() {
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productNames)
        );
        return driver.findElements(productNames)
                .stream()
                .map(WebElement::getText)
                .toList();
    }

    public List<Double> getProductsPrices() {
        wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(productPrices)
        );

        return driver.findElements(productPrices)
                .stream()
                .map(WebElement::getText)
                .map(price -> Double.parseDouble(price.replace("$", "")))
                .toList();
    }

    public double getProductsTotal() {
        return getProductsPrices()
                .stream()
                .mapToDouble(Double::doubleValue)
                .sum();
    }

    public double getItemTotal() {
        String total = wait.until(ExpectedConditions.visibilityOfElementLocated(itemTotal)).getText();
        return Double.parseDouble(total.replace("Item total: $", "")
        );
    }

    public void clickFinish() {
        wait.until(ExpectedConditions.elementToBeClickable(finishBtn)).click();
    }
}
