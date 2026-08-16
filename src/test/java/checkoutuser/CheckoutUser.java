package checkoutuser;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter

public class CheckoutUser {
    private final String firstName;
    private final String lastName;
    private final String postalCode;
}
