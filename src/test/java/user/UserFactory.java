package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withIncorrectUsername() {
        return new User(
                PropertyReader.getProperty("saucedemo.incorrect_name"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withIncorrectPassword() {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.incorrect_password"));
    }

    public static User withLockedAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.locked_user"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyUsername() {
        return new User(
                PropertyReader.getProperty("saucedemo.empty"),
                PropertyReader.getProperty("saucedemo.password"));
    }

    public static User withEmptyPassword() {
        return new User(
                PropertyReader.getProperty("saucedemo.user"),
                PropertyReader.getProperty("saucedemo.empty"));
    }

    public static User withEmptyUsernameAndPassword() {
        return new User(
                PropertyReader.getProperty("saucedemo.empty"),
                PropertyReader.getProperty("saucedemo.empty"));
    }
}
