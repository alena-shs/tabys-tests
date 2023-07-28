package mobileapp.objects.commons;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static mobileapp.data.MobileTestData.defaultPassword;

public class PasswordSetupPage {
    @Step("Enter in password and confirm it")
    public PasswordSetupPage setPasswordNewAccount() {
        sleep(2000);
        ElementsCollection passwordFields = $$(AppiumBy.className("android.widget.EditText"));
        passwordFields.shouldHave(CollectionCondition.size(2), Duration.ofSeconds(10));
        passwordFields.get(0).shouldHave(interactable, Duration.ofSeconds(10)).sendKeys(defaultPassword);
        passwordFields.get(1).shouldHave(interactable, Duration.ofSeconds(10)).sendKeys(defaultPassword);
        return this;
    }
}
