package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class CardIntroPage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Add bank card']")),
            nextButton = $(AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']"));
    @Step("Verify that the card introductory page is fully loaded and has all the necessary elements")
    public CardIntroPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(exist, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
}
