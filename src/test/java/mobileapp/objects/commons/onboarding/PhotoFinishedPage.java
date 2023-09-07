package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class PhotoFinishedPage {
    private final SelenideElement header = $(AppiumBy.xpath("//*[@text='Identification completed']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Continue registration']")),
            doneButton = $(AppiumBy.xpath("//android.widget.Button[@text='Done']"));
    @Step("Verify that the 'Identification completed' page is fully loaded and has all the necessary elements")
    public PhotoFinishedPage verifyPageLoaded() {
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
    @Step("Check if onboarding is stuck. If YES, keep pressing on 'Done' button. WARNING: This is a bug that verification gets stuck sometimes. Please remove this step once the bug is fixed")
    public void checkOnboardingStuck() {
        try {
            while (doneButton.exists()) {
                doneButton.click();
            }
        } catch (NoSuchElementException e){
            System.out.println(e.getMessage());
        }
    }
}
