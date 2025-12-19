package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPage {

    private final SelenideElement
            usernameInput = $("[data-test='username']"),
            passwordInput = $("[data-test='password']"),
            loginButton = $("[data-test='login-button']"),
            epicSadface = $("[data-test='error']");

    @Step("Открываем страницу логина")
    public LoginPage openLoginPage() {
        open("/");
        $(".login_logo").shouldHave(text("Swag Labs"));

        return this;
    }

    @Step("Ввод имени пользователя {{username}}")
    public LoginPage setUsername(String username) {
        usernameInput.setValue(username);

        return this;
    }

    @Step("Ввод пароля {password}")
    public LoginPage setPassword(String password) {
        passwordInput.setValue(password);

        return this;
    }

    @Step("Нажимаем кнопку Login")
    public LoginPage clickLoginButton() {
        loginButton.click();

        return this;
    }

    @Step("Вывод сообщения об ошибке")
    public void getErrorMessage(String error) {
        epicSadface.shouldHave(text(error));
    }

}
