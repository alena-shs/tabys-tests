package mobileapp.objects.tabys;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class EtnPersonalInformation {
    private final SelenideElement firstNameField = $(AppiumBy.xpath("//android.widget.TextView[@text='Name']")),
            firstNameValue = $(AppiumBy.xpath("//android.widget.TextView[@text='Name']/following-sibling::android.widget.TextView"));
    private final SelenideElement lastNameField = $(AppiumBy.xpath("//android.widget.TextView[@text='Surname']")),
            lastNameValue = $(AppiumBy.xpath("//android.widget.TextView[@text='Surname']/following-sibling::android.widget.TextView"));
    private final SelenideElement phoneNumberValue = $(AppiumBy.xpath("//android.widget.TextView[@text[starts-with(., '+')]]"));
    private final SelenideElement emailField = $(AppiumBy.xpath("//android.widget.TextView[@text='Email']"));
    private final SelenideElement investorSinceValue = $(AppiumBy.xpath("//android.widget.TextView[@text[contains(., 'year')]]"));
    private final SelenideElement updateDataButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Update data']")),
            deleteAccountButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Delete the account']"));

    @Step("Verify that 'My profile' information tab page is fully loaded and has all the necessary elements")
    public EtnPersonalInformation verifyPageLoaded(){
        firstNameField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(firstNameValue.getAttribute("text"), "");
        lastNameField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(lastNameValue.getAttribute("text"), "");
        phoneNumberValue.shouldHave(exist, Duration.ofSeconds(25));
        investorSinceValue.shouldHave(exist, Duration.ofSeconds(25));
        emailField.shouldHave(exist, Duration.ofSeconds(25));
        updateDataButton.shouldHave(exist, Duration.ofSeconds(25));
        deleteAccountButton.shouldHave(exist, Duration.ofSeconds(25));
        return this;
    }

    @Step("Click on 'Update data' button")
    public void tapUpdateData(){
        updateDataButton.shouldHave(exist, Duration.ofSeconds(25)).click();
    }
}
