package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class VideocheckRulesPage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Video verification']")),
            secondaryText = $(AppiumBy.xpath("//*[@text='Hold the ID at face level without covering it with your fingers or head and shoot a 5 second video.']")),
            firstRule = $(AppiumBy.xpath("//*[@text='Prepare your ID card']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Make a video']"));

    @Step("Verify that the page is fully loaded and has all the necessary elements (new onboarding)")
    public VideocheckRulesPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        secondaryText.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        firstRule.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }

//    @Step("Submit and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }

}
