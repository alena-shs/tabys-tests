package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhotoIntroPage {
    private SelenideElement header = $(AppiumBy.xpath("//*[@text='Identification of the person']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Start identification']"));
    @Step("Verify that the photo section introduction page is fully loaded and has all the necessary elements")
    public PhotoIntroPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(25));
        nextButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }
//    @Step("Submit the photo section introduction page and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }
}
