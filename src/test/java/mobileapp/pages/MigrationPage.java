package mobileapp.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MigrationPage{
        private ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));
    @Step("")
    public MigrationPage assertMigrationPageStructure(){
        availableButtons.shouldHave(size(2), Duration.ofSeconds(5));

        return this;
    }
}
