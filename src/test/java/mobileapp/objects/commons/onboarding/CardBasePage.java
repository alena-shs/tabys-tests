package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class CardBasePage {
    SelenideElement
            header = $(AppiumBy.xpath("//*[@text='Register new card']")),
            kaspiCardIcon = $(AppiumBy.xpath("//android.widget.Image[@text='kaspi_card']")),
            cnpCardIcon = $(AppiumBy.xpath("//android.widget.Image[@text='bank_card_blue']")),
            cnpButtonNoCard = $(AppiumBy.xpath("//android.widget.Button[@text='Add another card']"));
    SelenideElement
            modalChooseKaspiButton = $(AppiumBy.xpath("//android.widget.Button[@text='Add Kaspi card']")),
            modalChooseCnpButton = $(AppiumBy.xpath("//android.widget.Button[@text='Add another bank card']"));

    @Step("Verify that the cards main page is fully loaded and has all the necessary elements")
    public CardBasePage verifyPageLoaded(){
        header.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        kaspiCardIcon.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        cnpCardIcon.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }

    @Step("Choose CNP card over Kaspi card")
    public CardBasePage chooseCnpCard(){
        cnpButtonNoCard.click();
        return this;
    }

    @Step("Verify that the CNP fees modal is open")
    public CardBasePage verifyFeeModalOpened() {
        modalChooseKaspiButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        modalChooseCnpButton.shouldHave(visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        return this;
    }

    @Step("Choose a CNP card")
    public void confirmChooseCnpCard() {
        modalChooseCnpButton.click();
    }
}
