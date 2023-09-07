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

public class IncomeSourcePage {
    private final SelenideElement
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='That is right, continue']"));
    private final ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));


    @Step("Verify that the page is fully loaded and has all the necessary elements")
    public IncomeSourcePage verifyPageLoaded() {
        availableButtons.shouldHave(CollectionCondition.size(5), Duration.ofSeconds(defaultWaitingOfSeconds));
        nextButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }
    @Step("Enter in the income source and get the result")
    public void setIncomeSource(String incomeSource) {
        SelenideElement incomeSourceButton = $(AppiumBy.xpath("//android.widget.Button[@text='"+ incomeSource +"']"));
        incomeSourceButton.click();
    }
}
