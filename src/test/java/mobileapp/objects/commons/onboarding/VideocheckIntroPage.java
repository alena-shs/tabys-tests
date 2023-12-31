package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class VideocheckIntroPage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Video verification']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Start a verification']"));
    @Step("Verify that the video verification intro page is fully loaded and has all the necessary elements")
    public VideocheckIntroPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
//    @Step("Submit the video verification intro page and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }
}
