package mobileapp.objects.commons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private SelenideElement availableButton = $(AppiumBy.className("android.widget.Button")),
            ipoBanner = $(AppiumBy.xpath("//android.view.View[@text='My Bonds/Shares']")),
            theLastInvestmentText = $(AppiumBy.xpath("//android.view.View[@text='The last investment']")),
            investedCounter = $(AppiumBy.xpath("//android.widget.TextView[@text='Invested']")),
            incomeCounter = $(AppiumBy.xpath("//android.widget.TextView[@text='Income']")),
            goalsCounter = $(AppiumBy.xpath("//android.widget.TextView[@text='Goals']"));

    @Step("Press on ETN Registration button")
    public MainPage etnRegistrationButtonClick() {
        availableButton.shouldHave(Condition.exist, Duration.ofSeconds(5));
        availableButton.click();
        return this;
    }

    @Step("Proceed to registration from the investor steps modal")
    public MainPage proceedFromInvestorSteps(){
        availableButton.shouldHave(exist, Duration.ofSeconds(5));
        availableButton.click();
        return this;
    }

    @Step("Press on My bonds/shares button")
    public MainPage ipoBannerClick() {
        ipoBanner.shouldHave(interactable, Duration.ofSeconds(10)).click();
        return this;
    }

    @Step("Verify that main page is open")
    public MainPage verifyMainPage() {
        investedCounter.shouldHave(exist, Duration.ofSeconds(10)).click();
        incomeCounter.shouldHave(exist, Duration.ofSeconds(10)).click();
        goalsCounter.shouldHave(exist, Duration.ofSeconds(10)).click();
        theLastInvestmentText.shouldHave(exist, Duration.ofSeconds(10)).click();
        return this;
    }
}
