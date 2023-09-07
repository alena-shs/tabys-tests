package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class PhotoIntroPage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Identification of the person']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Start identification']"));
    @Step("Verify that the photo section introduction page is fully loaded and has all the necessary elements")
    public PhotoIntroPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
}
