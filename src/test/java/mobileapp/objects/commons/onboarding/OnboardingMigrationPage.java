package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.sleep;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class OnboardingMigrationPage {
    private final ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));
    @Step("Proceed (with the only button on the screen)")
    public void agreeToMigrate() {
        availableButtons.get(1).shouldHave(exist, Duration.ofSeconds(defaultWaitingOfSeconds)).click();
        sleep(10000);
    }
}
