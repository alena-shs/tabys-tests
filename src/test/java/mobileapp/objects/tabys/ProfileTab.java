package mobileapp.objects.tabys;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;

public class ProfileTab {
    private final SelenideElement personalInformation = $(AppiumBy.xpath("//android.widget.TextView[@text='Personal information']"));
    @Step("Open the 'Personal information' screen")
    public void clickPersonalInformation() {
        personalInformation.shouldHave(Condition.visible, Duration.ofSeconds(25)).click();
    }
}
