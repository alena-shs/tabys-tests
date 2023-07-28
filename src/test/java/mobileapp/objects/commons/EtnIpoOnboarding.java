package mobileapp.objects.commons;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class EtnIpoOnboarding {
    private SelenideElement availableButton = $(AppiumBy.className("android.widget.Button")),
            availableInput = $(AppiumBy.className("android.widget.EditText"));
    private ElementsCollection inputFields = $$(AppiumBy.className("android.widget.EditText")),
            availableButtons = $$(AppiumBy.className("android.widget.Button"));

    @Step("Proceed (with the only button on the screen)")
    public EtnIpoOnboarding pressOnAvailableButton() {
        availableButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        return this;
    }

//    @Step("Proceed (with dynamic forms special button)")
//    public EtnIpoOnboarding pressOnDynamicFormsNextButton(AppiumDriver mobileDriver) {
//        sleep(4000);
//        SelenideElement button = (SelenideElement) mobileDriver.findElement((By) $(AppiumBy.id("dynamic-forms-next-button")));
//        button.click();
//        sleep(4000);
//        return this;
//    }

    @Step("Enter in both emails")
    public EtnIpoOnboarding enterEmail(){
        ElementsCollection emailInputFields = inputFields.shouldHave(CollectionCondition.size(2), Duration.ofSeconds(5));
        emailInputFields.get(0).shouldHave(interactable, Duration.ofSeconds(10)).sendKeys("test@test.test");
        emailInputFields.get(1).shouldHave(interactable, Duration.ofSeconds(10)).sendKeys("test@test.test");
        return this;
    }

    @Step("Enter in the IIN")
    public EtnIpoOnboarding setIin(String iin) {
        inputFields.shouldHave(CollectionCondition.size(1), Duration.ofSeconds(5));
        availableInput.sendKeys(iin);
        return this;
    }

    @Step("Enter in the income source and get the result")
    public EtnIpoOnboarding setIncomeSource(String incomeSource) {
        ElementsCollection incomeButtons = $$(AppiumBy.className("android.widget.Button"));
        switch (incomeSource) {
            case "Business Income":
                incomeButtons.get(0).click();
                break;
            case "Other assets":
                incomeButtons.get(1).click();
                break;
            case "Salary":
                incomeButtons.get(2).click();
                break;
            case "Savings":
                incomeButtons.get(3).click();
                break;
        }
        incomeButtons.get(4).click();
         return this;
    }

    @Step("Verify that the 'Add bank card' screen is open")
    public EtnIpoOnboarding verifyAddBankCardScreen() {
        $(AppiumBy.xpath("//android.view.View[@text='Add bank card']")).shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Choose a CNP card")
    public EtnIpoOnboarding chooseCnpCard() {
        availableButtons.get(1).shouldHave(exist, Duration.ofSeconds(10)).click();
        $(AppiumBy.xpath("//android.view.View[@text='Bank fee']")).should(exist, Duration.ofSeconds(10));
        availableButtons.get(1).shouldHave(exist, Duration.ofSeconds(10)).click();
        return this;
    }
}