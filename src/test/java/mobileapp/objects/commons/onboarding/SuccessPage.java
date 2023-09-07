package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class SuccessPage {
    private SelenideElement
            sharingHeader = $(AppiumBy.xpath("//*[@text[starts-with(., 'Shar')]]")),
            promoteButton = $(AppiumBy.className("android.widget.Button")),
            exitButton = $(AppiumBy.xpath("//*[@text='Exit']"));
    @Step("Verify that the onboarding success page is fully loaded and has all the necessary elements")
    public SuccessPage verifyPageLoaded() {
        promoteButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }
    @Step("Press on Promote the queue")
    public SuccessPage promoteQueue() {
        promoteButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Verify that the 'Share with friends'page is fully loaded and has all the necessary elements")
    public SuccessPage verifySharingPageLoaded() {
        sharingHeader.shouldHave(visible, Duration.ofSeconds(25));
        exitButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

    @Step("Exit")
    public void exit() {
        exitButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
    }
}
