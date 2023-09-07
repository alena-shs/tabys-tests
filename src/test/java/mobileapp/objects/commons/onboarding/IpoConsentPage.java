package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class IpoConsentPage {
    private final SelenideElement openButton = $(AppiumBy.xpath("//android.widget.Button[@text[starts-with(., 'Open')]]"));
    private final ElementsCollection images = $$(AppiumBy.className("android.widget.Image"));

    @Step("Verify that the IPO 'Open account' page is fully loaded and has all the necessary elements (new onboarding)")
    public IpoConsentPage verifyPageLoaded() {
        openButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        images.shouldHave(CollectionCondition.size(3), Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }

    @Step("Submit the IPO 'Open account' page and go to the next page")
    public void proceed() {
        openButton.shouldHave(interactable, Duration.ofSeconds(25)).click();}
}
