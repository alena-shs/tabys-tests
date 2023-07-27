package mobileapp.objects.commons;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class PinPage {
    @Step("Set up a new PIN code")
    public PinPage setUpPin(String pin){
        sleep(5000);
        $(AppiumBy.className("android.widget.EditText")).sendKeys(pin);
        sleep(5000);
        return this;
    }
}
