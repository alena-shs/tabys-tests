package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class PhotoIdPage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text[starts-with(., 'ID')]]"));
    private final ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button")),
            availablePhotoFields = $$(AppiumBy.xpath("//android.view.View[@resource-id='photo-clickable']"));

    @Step("Verify that the ID photo page is fully loaded and has all the necessary elements (new onboarding)")
    public void verifyPageLoadedNewOnboarding() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        availableButtons.shouldHave(CollectionCondition.size(3), Duration.ofSeconds(defaultWaitingOfSeconds));
        availablePhotoFields.shouldHave(CollectionCondition.size(2), Duration.ofSeconds(defaultWaitingOfSeconds));
    }

    @Step("Add front photo")
    public void addFrontPhoto() {
        availableButtons.get(0).click();
        // TODO: add the following steps
    }

    @Step("Add back side photo")
    public void addBackPhoto() {
        availableButtons.get(1).click();
        // TODO: add the following steps
    }

}
