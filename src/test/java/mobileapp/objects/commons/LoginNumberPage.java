package mobileapp.objects.commons;

import com.codeborne.selenide.ElementsCollection;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.*;
import static mobileapp.data.MobileTestData.defaultWaitingOfSeconds;

public class LoginNumberPage {
    ElementsCollection inputFields = $$(AppiumBy.className("android.widget.EditText"));
    @Step("Enter credentials")
    public LoginNumberPage enterPhoneNumber(String phoneNumber, String password) {
        inputFields.get(0).sendKeys(phoneNumber.substring(1));
        inputFields.get(1).sendKeys(password);
        return this;
    }

    @Step("Proceed to the next page with credentials")
    public void proceed() {
        $(AppiumBy.className("android.widget.Button")).click();
        sleep(5000);
    }

    @Step("Tap on Forgot Password")
    public void tapForgotPassword() {
        $(AppiumBy.xpath("//*[@text='Forgot password?']")).shouldHave(interactable, Duration.ofSeconds(defaultWaitingOfSeconds)).click();
    }
}
