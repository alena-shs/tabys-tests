package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class IinPage {
    private SelenideElement availableInput = $(AppiumBy.className("android.widget.EditText")),
            header = $(AppiumBy.xpath("//*[@text='Personal information']")),
            countryFoundText =  $(AppiumBy.xpath("//*[@text='Kazakhstan']")),
            nextButton = $(AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")),
    citizenOfKazakhstanButton = $(AppiumBy.xpath("//*[@text='I am a citizen of Kazakhstan']"));
    private ElementsCollection inputFields = $$(AppiumBy.className("android.widget.EditText"));

    @Step("Verify that the IIN input page is fully loaded and has all the necessary elements")
    public IinPage verifyPageLoaded() {
        inputFields.shouldHave(CollectionCondition.size(1), Duration.ofSeconds(25));
        header.shouldHave(visible, Duration.ofSeconds(25));
        nextButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

    @Step("Enter in the IIN")
    public IinPage setIin(String iin) {
        availableInput.sendKeys(iin);
        return this;
    }

    @Step("Verify that IIN is found")
    public IinPage verifyIinFound() {
        countryFoundText.shouldHave(visible, Duration.ofSeconds(25));
        citizenOfKazakhstanButton.shouldHave(not(visible), Duration.ofSeconds(25));
        return this;
    }

//    @Step("Submit the IIN input page and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(exist, Duration.ofSeconds(25)).click();
//    }
}
