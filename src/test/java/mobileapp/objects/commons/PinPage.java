package mobileapp.objects.commons;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class PinPage {
    private final SelenideElement setupPinText = $(AppiumBy.xpath("//*[@text='Come up with 4 digit pin code to log in']")),
    repeatPinText = $(AppiumBy.xpath("*[@text='Repeat 4-digit PIN to login']"));
    private ElementsCollection input = $$(AppiumBy.className("android.widget.EditText"));
    @Step("Set up a new PIN code")
    public PinPage setUpPinFirst(String pin){
        setupPinText.shouldHave(Condition.visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        input.shouldHave(CollectionCondition.size(4), Duration.ofSeconds(defaultWaitingOfSeconds));
        input.get(0).sendKeys(pin);
        sleep(2000);
        return this;
    }

    @Step("Set up a new PIN code")
    public void repeatPin(String pin){
        repeatPinText.shouldHave(Condition.visible, Duration.ofSeconds(defaultWaitingOfSeconds));
        input.shouldHave(CollectionCondition.size(4), Duration.ofSeconds(defaultWaitingOfSeconds));
        input.get(0).sendKeys(pin);
        sleep(2000);
    }
}
