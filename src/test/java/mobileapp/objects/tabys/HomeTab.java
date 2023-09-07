package mobileapp.objects.tabys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;

public class HomeTab {
    private SelenideElement availableButton = $(AppiumBy.className("android.widget.Button")),
            ipoBanner = $(AppiumBy.xpath("//*[@text='My Bonds/Shares']")),
            theLastInvestmentText = $(AppiumBy.xpath("//*[@text='The last investment']")),
            investedCounter = $(AppiumBy.xpath("//*[@text='Invested']")),
            incomeCounter = $(AppiumBy.xpath("//*[@text='Income']")),
            goalsCounter = $(AppiumBy.xpath("//*[@text='Goals']"));


    @Step("Verify that tabys home page is open")
    public HomeTab verifyPageLoaded() {
        investedCounter.shouldHave(exist, Duration.ofSeconds(25));
        incomeCounter.shouldHave(exist, Duration.ofSeconds(25));
        goalsCounter.shouldHave(exist, Duration.ofSeconds(25));
        theLastInvestmentText.shouldHave(exist, Duration.ofSeconds(25));
        return this;
    }

    @Step("Press on ETN Registration button")
    public HomeTab etnRegistrationButtonClick() {
        availableButton.shouldHave(Condition.exist, Duration.ofSeconds(25));
        availableButton.click();
        return this;
    }

    @Step("Press on My bonds/shares button")
    public HomeTab ipoBannerClick() {
        ipoBanner.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }
}
