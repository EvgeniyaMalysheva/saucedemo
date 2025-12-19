package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import pages.InventoryPage;
import pages.LoginPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {
    protected LoginPage loginPage = new LoginPage();
    protected InventoryPage inventoryPage = new InventoryPage();

    @BeforeAll
    static void setBrowserParams() {
        Configuration.baseUrl = "https://www.saucedemo.com";
    }

    @BeforeEach
    void addAllureSelenideListener() {
        SelenideLogger.addListener(
                "AllureSelenide",
                new AllureSelenide()
        );
    }

    @AfterEach
    void addScreenshotAndCloseDriver() {
        Attach.screenshotAs("Last screenshot");
        closeWebDriver();
    }
}
