package mobileapp.objects.ipo;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MyProfileDocuments {
    private final SelenideElement myCardsButton = $(AppiumBy.xpath("//android.widget.TextView[@text='My cards']")),
            myAccountButton = $(AppiumBy.xpath("//android.widget.TextView[@text='My account']")),
            termsOfServiceButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Terms of service']")),
            privacyPolicyButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Privacy policy']")),
            agreementCsdButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Agreement with AIX CSD']"));

    @Step("Verify that 'My profile' page is opened correctly")
    public MyProfileDocuments verifyPageLoaded() {
        myCardsButton.shouldHave(visible, Duration.ofSeconds(25));
        myAccountButton.shouldHave(visible, Duration.ofSeconds(25));
        termsOfServiceButton.shouldHave(visible, Duration.ofSeconds(25));
        privacyPolicyButton.shouldHave(visible, Duration.ofSeconds(25));
        agreementCsdButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

    @Step("Go to 'My cards' section")
    public void myCardsTap() {
        myCardsButton.click();
        myCardsButton.click();
    }
}
