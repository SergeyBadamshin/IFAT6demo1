package enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ErrorMessage {
    ERROR_WRONG_INPUT("Epic sadface: Username and password do not match any user in this service"),
    ERROR_LOCKED_USER("Epic sadface: Sorry, this user has been locked out."),
    ERROR_USER_REQUIRED("Epic sadface: Username is required"),
    ERROR_PASSWORD_REQUIRED("Epic sadface: Password is required");

    private final String message;

}
