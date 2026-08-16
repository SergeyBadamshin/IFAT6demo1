package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ProductsNaming {
    BACKPACK("Sauce Labs Backpack"),
    BIKE_LIGHT("Sauce Labs Bike Light"),
    BOLT_T_SHIRT("Sauce Labs Bolt T-Shirt");

    private final String productName;
}
