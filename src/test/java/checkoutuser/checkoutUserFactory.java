package checkoutuser;

public class checkoutUserFactory {
    public static CheckoutUser validUser() {
        return new CheckoutUser(
                "Sergey",
                "Badamshin",
                "426063"
        );
    }
}
