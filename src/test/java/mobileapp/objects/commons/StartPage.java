package mobileapp.objects.commons;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class StartPage {
    private final SelenideElement splashMessages = $(AppiumBy.xpath("//android.view.View[@resource-id='splash-message-container']")),
            background = $(AppiumBy.xpath("//*[@resource-id='background-content']"));
    ElementsCollection availableButtons = $$(AppiumBy.className("android.widget.Button"));

    @Step("Click on 'Ready to start'")
    public void clickReadyToStart() {
        splashMessages.shouldHave(not(exist), Duration.ofSeconds(15));
        background.shouldHave(visible, Duration.ofSeconds(15));
        availableButtons.shouldHave(size(2), Duration.ofSeconds(15));
        while (availableButtons.size()==2){
            availableButtons.get(1).click();
        }
    }

    @Step("Click on 'I'm already registered'")
    public void clickImAlreadyRegistered() {
        splashMessages.shouldHave(not(exist), Duration.ofSeconds(15));
        background.shouldHave(visible, Duration.ofSeconds(15));
        availableButtons.shouldHave(size(2), Duration.ofSeconds(15));
        while (availableButtons.size()==2){
            availableButtons.get(1).click();
        }
    }


}
