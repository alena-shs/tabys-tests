package mobileapp.objects.commons;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class PhotoModal {
    private SelenideElement startCamera = $(AppiumBy.xpath("//android.view.View[@text='TURN ON CAMERA']")),
            removePhoto = $(AppiumBy.xpath("//android.view.View[@text='REMOVE THE PHOTO']")),
            close = $(AppiumBy.xpath("//android.view.View[@text='CLOSE']"));
    @Step("Verify that the modal to take photos is fully loaded and has all the necessary elements")
    public PhotoModal verifyPageLoaded() {
        startCamera.shouldHave(visible, Duration.ofSeconds(25));
        removePhoto.shouldHave(visible, Duration.ofSeconds(25));
        close.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

}
