package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class InvestorSteps {
    //TODO Investor steps for Tabys and IPO
    SelenideElement
            header = $(AppiumBy.xpath("//android.view.View[@text='Your investor status']")),
            stepInstallTabys = $(AppiumBy.xpath("//android.view.View[@text='Install Tabys']")),
            stepLogin = $(AppiumBy.xpath("//android.view.View[@text='Login to the application']"));
    SelenideElement nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Continue']"));

    @Step("Verify that all ETN investor steps are showing correct steps")
    public InvestorSteps  verifyOnboardingStepsPage() {
        header.shouldHave(visible, Duration.ofSeconds(25)).click();
        stepInstallTabys.shouldHave(visible, Duration.ofSeconds(25)).click();
        stepLogin.shouldHave(visible, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Proceed to the onboarding")
    public void proceed(){
        nextButton.click();
    }
}
