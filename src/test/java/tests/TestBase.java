package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
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

    @AfterEach
    void closeDriver() {
        closeWebDriver();
    }
}
