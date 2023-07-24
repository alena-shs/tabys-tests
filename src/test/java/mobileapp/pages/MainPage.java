package mobileapp.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class MainPage {
    private SelenideElement availableButton = $(AppiumBy.className("android.widget.Button"));

    @Step("Press on ETN Registration button")
    public MainPage etnRegistrationButtonClick() {
        availableButton.shouldHave(Condition.exist, Duration.ofSeconds(5));
        availableButton.click();
        return this;
    }

    @Step("Proceed to registration from the investor steps modal")
    public MainPage proceedFromInvestorSteps(){
        availableButton.shouldHave(Condition.exist, Duration.ofSeconds(5));
        availableButton.click();
        return this;
    }

    @Step("Press on My bonds/shares button")
    public MainPage ipoBannerClick() {
        $(AppiumBy.xpath("//android.view.View[@text='My Bonds/Shares']")).shouldHave(interactable, Duration.ofSeconds(10)).click();
        sleep(100);
        return this;
    }

}
