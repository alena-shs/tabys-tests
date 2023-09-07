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

public class PhotoIdPage {
    private SelenideElement header = $(AppiumBy.xpath("//*[@text[starts-with(., 'ID')]]"));
    private ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button")),
            availablePhotoFields = $$(AppiumBy.xpath("//android.view.View[@resource-id='photo-clickable']"));

    @Step("Verify that the ID photo page is fully loaded and has all the necessary elements (new onboarding)")
    public PhotoIdPage verifyPageLoadedNewOnboarding() {
        header.shouldHave(visible, Duration.ofSeconds(25));
        availableButtons.shouldHave(CollectionCondition.size(3), Duration.ofSeconds(25));
        availablePhotoFields.shouldHave(CollectionCondition.size(2), Duration.ofSeconds(25));
        return this;
    }

    @Step("Add front photo")
    public PhotoIdPage addFrontPhoto() {
        availableButtons.get(0).click();
        // TODO: add the following steps
        return this;
    }

    @Step("Add back side photo")
    public PhotoIdPage addBackPhoto() {
        availableButtons.get(1).click();
        // TODO: add the following steps
        return this;
    }

}
