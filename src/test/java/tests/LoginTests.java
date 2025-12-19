package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static data.ErrorMessages.*;
import static data.TestData.*;

@Owner("Evgenia Malysheva")
@DisplayName("Тесты на логин")
public class LoginTests extends TestBase {
    @Test
    @DisplayName("Успешный логин")
    public void successfulLoginTest() {
        loginPage.openLoginPage()
                .setUsername(STANDARD_USER)
                .setPassword(STANDARD_PASSWORD)
                .clickLoginButton();
        inventoryPage.wasOpened();
    }

    @Test
    @DisplayName("Логин с неверным паролем")
    public void wrongPasswordLoginTest() {
        loginPage.openLoginPage()
                .setUsername(STANDARD_USER)
                .setPassword(wrongPassword)
                .clickLoginButton()
                .getErrorMessage(INVALID_PASSWORD);
    }

    @Test
    @DisplayName("Логин заблокированного пользователя")
    public void lockedOutUserLoginTest() {
        loginPage.openLoginPage()
                .setUsername(LOCKED_OUT_USER)
                .setPassword(STANDARD_PASSWORD)
                .clickLoginButton()
                .getErrorMessage(USER_IS_LOCKED);
    }

    @Test
    @DisplayName("Логин с пустыми полями")
    public void emptyFieldsLoginTest() {
        loginPage.openLoginPage()
                .setUsername("")
                .setPassword("")
                .clickLoginButton()
                .getErrorMessage(USER_NAME_IS_EMPTY);
    }

    @Test
    @DisplayName("Логин пользователем с зависаниями страницы")
    public void performanceGlitchUserLoginTest() {
        loginPage.openLoginPage()
                .setUsername(PERFORMANCE_GLITCH_USER)
                .setPassword(STANDARD_PASSWORD)
                .clickLoginButton();
        inventoryPage.isWaitingToOpen()
                .wasOpened();
    }
}
