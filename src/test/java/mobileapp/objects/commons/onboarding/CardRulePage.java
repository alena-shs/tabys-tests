package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class CardRulePage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Name card']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button"));
    @Step("Verify that the 'Name card' page (cards rule page) is fully loaded and has all the necessary elements")
    public CardRulePage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
}
