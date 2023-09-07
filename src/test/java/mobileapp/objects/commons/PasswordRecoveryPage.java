package mobileapp.objects.commons;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PasswordRecoveryPage {
    private final SelenideElement
            header = $(AppiumBy.xpath("//*[@text='Phone number']")),
            inputField = $(AppiumBy.className("android.widget.EditText")),
            button = $(AppiumBy.className("android.widget.Button"));
    @Step("Proceed from Register page")
    public PasswordRecoveryPage enterPhoneNumber(String phoneNumber) {
        sleep(2000);
        header.shouldHave(Condition.visible, Duration.ofSeconds(10));
        inputField.shouldHave(Condition.appear, Duration.ofSeconds(10)).click();
        sleep(1000);
        inputField.sendKeys(phoneNumber.substring(1));
        return this;
    }

    @Step("Click 'Get SMS code to initiate OTP")
    public void initiateRegistrationOtp() {
        sleep(2000);
        button.click();
        sleep(2000);
    }
}
