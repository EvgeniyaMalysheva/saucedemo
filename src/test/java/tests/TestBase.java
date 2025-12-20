package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import utils.AttachUtils;
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
        Configuration.browser = System.getProperty("browser", "chrome");
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
        AttachUtils.screenshotAs("Last screenshot");
        closeWebDriver();
    }
}
