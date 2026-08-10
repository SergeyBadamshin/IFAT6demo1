package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.admin_user_name"),
                PropertyReader.getProperty("saucedemo.correct_password"));
    }

    public static User withIncorrectUsername() {
        return new User(
                PropertyReader.getProperty("saucedemo.incorrect_name"),
                PropertyReader.getProperty("saucedemo.correct_password"));
    }

    public static User withIncorrectPassword() {
        return new User(
                PropertyReader.getProperty("saucedemo.admin_user_name"),
                PropertyReader.getProperty("saucedemo.incorrect_password"));
    }

    public static User withLockedAdminPermission() {
        return new User(
                PropertyReader.getProperty("saucedemo.locked_user_name"),
                PropertyReader.getProperty("saucedemo.correct_password"));
    }
}
