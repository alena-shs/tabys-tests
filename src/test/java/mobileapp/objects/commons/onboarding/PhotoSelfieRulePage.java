package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhotoSelfieRulePage {
    private SelenideElement header = $(AppiumBy.xpath("//*[@text='Selfie']")),
            firstRule = $(AppiumBy.xpath("//*[@text='Stand in a lighted place']"));

    @Step("Verify that the selfie rule page is fully loaded and has all the necessary elements (new onboarding)")
    public PhotoSelfieRulePage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(25));
        firstRule.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

//    @Step("Submit the selfie rule page and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }

}
