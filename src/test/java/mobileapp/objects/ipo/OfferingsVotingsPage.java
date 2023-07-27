package mobileapp.objects.ipo;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class OfferingsVotingsPage {
    private SelenideElement myProfileDocumentsTab = $(AppiumBy.xpath("//android.view.View[@text='DOCUMENTS']")),
            documentsMyCardsButton = $(AppiumBy.xpath("//android.widget.TextView[@text='My cards']"));

    @Step("Verify that the 'Add bank card' screen is open")
    public OfferingsVotingsPage myProfileDocumentsSelect() {
        sleep(15000);
        myProfileDocumentsTab.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Verify that the 'Add bank card' screen is open")
    public OfferingsVotingsPage documentsCardsTap() {
        documentsMyCardsButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }
}
