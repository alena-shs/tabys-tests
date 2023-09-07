package mobileapp.objects.commons;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selenide.$$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class MigrationPage{
        private final ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));
    @Step("Assert that the migration page opened correctly")
    public MigrationPage assertMigrationPageStructure(){
        availableButtons.shouldHave(size(2), Duration.ofSeconds(defaultWaitingOfSeconds));

        return this;
    }
}
