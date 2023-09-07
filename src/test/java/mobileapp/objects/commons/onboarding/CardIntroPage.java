package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardIntroPage {
    private SelenideElement header = $(AppiumBy.xpath("//*[@text='Add bank card']")),
            nextButton = $(AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']"));
    @Step("Verify that the card introductory page is fully loaded and has all the necessary elements")
    public CardIntroPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(35));
        nextButton.shouldHave(exist, Duration.ofSeconds(35));
        return this;
    }
//    @Step("Submit the card introductory page and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }
}
