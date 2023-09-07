package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class UserConsentPage {
    private final SelenideElement
            header = $(AppiumBy.xpath("//*[@text='User Consent']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='I read everything, continue']"));


    @Step("Verify that the page is fully loaded and has all the necessary elements")
    public UserConsentPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
}
