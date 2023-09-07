package mobileapp.objects.commons;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.*;
import static mobileapp.data.MobileTestData.defaultEmail;

public class MobileCommonElements {
    private SelenideElement availableButton = $(AppiumBy.className("android.widget.Button")),
            onboardingNextButton = $(AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")),
            availableInput = $(AppiumBy.className("android.widget.EditText"));
    private ElementsCollection inputFields = $$(AppiumBy.className("android.widget.EditText")),
            availableButtons = $$(AppiumBy.className("android.widget.Button"));

    @Step("Proceed (with the only button on the screen)")
    public MobileCommonElements tapOnAvailableButton() {
        availableButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Proceed with onboarding")
    public void proceedOnboarding() {
        sleep(1000);
        onboardingNextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
    }

    @Step("Enter in both emails")
    public MobileCommonElements enterEmail(){
        ElementsCollection emailInputFields = inputFields.shouldHave(CollectionCondition.size(2), Duration.ofSeconds(5));
        emailInputFields.get(0).shouldHave(interactable, Duration.ofSeconds(10)).sendKeys(defaultEmail);
        emailInputFields.get(1).shouldHave(interactable, Duration.ofSeconds(10)).sendKeys(defaultEmail);
        return this;
    }
}