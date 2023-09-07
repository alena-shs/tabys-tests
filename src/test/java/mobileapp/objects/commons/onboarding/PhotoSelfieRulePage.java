package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class PhotoSelfieRulePage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Selfie']")),
            firstRule = $(AppiumBy.xpath("//*[@text='Stand in a lighted place']"));

    @Step("Verify that the selfie rule page is fully loaded and has all the necessary elements (new onboarding)")
    public PhotoSelfieRulePage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        firstRule.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
}
