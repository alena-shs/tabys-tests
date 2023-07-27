package mobileapp.objects.commons;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;

public class OnboardingMigrationPage {
    private ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));
    @Step("Proceed (with the only button on the screen)")
    public void agreeToMigrate() {
        availableButtons.get(1).shouldHave(exist, Duration.ofSeconds(25)).click();
        sleep(10000);
    }
}
