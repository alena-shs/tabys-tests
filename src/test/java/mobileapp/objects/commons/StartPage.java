package mobileapp.objects.commons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import mobileapp.helpers.MobileUtils;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class StartPage {
    private final SelenideElement splashMessages = $(AppiumBy.xpath("//android.view.View[@resource-id='splash-message-container']")),
            availableButton = $(AppiumBy.className("android.widget.Button"));

    @Step("Click on 'Ready to start'")
    public void clickReadyToStart() {
        AndroidDriver mobileDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        splashMessages.shouldHave(not(visible), Duration.ofSeconds(20));
        availableButton.shouldHave(Condition.visible, Duration.ofSeconds(20));
        MobileUtils.tapWithPercentages(mobileDriver, 0.5, 0.9, 400); //with duration 200ms
    }

    @Step("Click on 'I'm already registered'")
    public void clickImAlreadyRegistered() {
//        ElementsCollection buttons = $$(AppiumBy.className("android.widget.Button"));
//        buttons.get(1).click();

        AndroidDriver mobileDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        sleep(10000);
        MobileUtils.tapWithPercentages(mobileDriver, 0.5, 0.99, 400); //with duration 200ms
        MobileUtils.tapWithPercentages(mobileDriver, 0.5, 0.99, 400);
    }


}
