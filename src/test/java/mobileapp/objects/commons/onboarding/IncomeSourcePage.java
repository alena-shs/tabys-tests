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

public class IncomeSourcePage {
    private SelenideElement
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='That is right, continue']"));
    private ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));


    @Step("Verify that the page is fully loaded and has all the necessary elements")
    public IncomeSourcePage verifyPageLoaded() {
        availableButtons.shouldHave(CollectionCondition.size(5), Duration.ofSeconds(25));
        nextButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }
    @Step("Enter in the income source and get the result")
    public IncomeSourcePage setIncomeSource(String incomeSource) {
        SelenideElement incomeSourceButton = $(AppiumBy.xpath("//android.widget.Button[@text='"+ incomeSource +"']"));
        incomeSourceButton.click();
//        switch (incomeSource) {
//            case "Business Income":
//                availableButtons.get(0).click();
//                break;
//            case "Other assets":
//                availableButtons.get(1).click();
//                break;
//            case "Salary":
//                availableButtons.get(2).click();
//                break;
//            case "Savings":
//                availableButtons.get(3).click();
//                break;
//        }
        return this;
    }

//    @Step("Submit and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }
}
