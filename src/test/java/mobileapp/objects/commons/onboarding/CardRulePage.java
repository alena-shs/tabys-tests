package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class CardRulePage {
    private SelenideElement header = $(AppiumBy.xpath("//*[@text='Name card']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button"));
    @Step("Verify that the 'Name card' page (cards rule page) is fully loaded and has all the necessary elements")
    public CardRulePage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(25));
        nextButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }
//    @Step("Submit the 'Name card' page (cards rule page) and go to the next page")
//    public void proceed() {
//        nextButton.click();
//        nextButton.click();
//    }
}
