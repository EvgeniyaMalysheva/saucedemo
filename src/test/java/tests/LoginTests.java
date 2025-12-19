package tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import testdata.TestData;

import static testdata.TestData.*;

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
                .setPassword(TestData.wrongPassword)
                .clickLoginButton()
                .getErrorMessage("Username and password do not match any user in this service");
    }

    @Test
    @DisplayName("Логин заблокированного пользователя")
    public void lockedOutUserLoginTest() {
        loginPage.openLoginPage()
                .setUsername(LOCKED_OUT_USER)
                .setPassword(STANDARD_PASSWORD)
                .clickLoginButton()
                .getErrorMessage("Sorry, this user has been locked out.");
    }

    @Test
    @DisplayName("Логин с пустыми полями")
    public void emptyFieldsLoginTest() {
        loginPage.openLoginPage()
                .setUsername("")
                .setPassword("")
                .clickLoginButton()
                .getErrorMessage("Username is required");
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
