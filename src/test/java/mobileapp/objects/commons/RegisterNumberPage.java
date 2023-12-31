package mobileapp.objects.commons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class RegisterNumberPage {
    private final SelenideElement inputField = $(AppiumBy.className("android.widget.EditText")),
            button = $(AppiumBy.className("android.widget.Button"));
    @Step("Proceed from Register page")
    public RegisterNumberPage enterPhoneNumber(String phoneNumber) {
        inputField.shouldHave(Condition.appear, Duration.ofSeconds(defaultWaitingOfSeconds)).click();
        inputField.sendKeys(phoneNumber.substring(1));
        return this;
    }

    @Step("Click 'Get SMS code to initiate OTP")
    public void initiateRegistrationOtp() {
        button.click();
    }
}
