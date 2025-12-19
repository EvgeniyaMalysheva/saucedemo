package pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class InventoryPage {
    private final SelenideElement
            pageTitle = $("[data-test='title']");
    private final ElementsCollection
            inventoryItems = $$("[data-test='inventory-item']");


    @Step("Проверка загрузки страницы после авторизации")
    public void wasOpened() {
        pageTitle.shouldHave(text("Products"));
        inventoryItems.shouldHave(sizeGreaterThan(0));
    }

    @Step("Ожидание загрузки страницы")
    public InventoryPage isWaitingToOpen() {
        pageTitle.shouldBe(visible, Duration.ofSeconds(15));

        return this;
    }

}
