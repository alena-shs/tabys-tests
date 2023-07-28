package mobileapp.objects.ipo;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.not;
import static com.codeborne.selenide.Selenide.$;

public class MyProfileInformation {
    private SelenideElement firstNameField = $(AppiumBy.xpath("//android.view.View[@text='Name']")),
            firstNameValue = $(AppiumBy.xpath("//android.view.View[@text='Name']/following-sibling::android.widget.TextView and string-length(@text)>0"));
    private SelenideElement lastNameField = $(AppiumBy.xpath("//android.view.View[@text='Surname']")),
            lastNameValue = $(AppiumBy.xpath("//android.view.View[@text='Surname']/following-sibling::android.widget.TextView"));
    private SelenideElement phoneNumberField = $(AppiumBy.xpath("//android.view.View[@text='Phone number']")),
            phoneNumberValue = $(AppiumBy.xpath("//android.view.View[@text='Phone number']/following-sibling::android.widget.TextView"));
    private SelenideElement emailField = $(AppiumBy.xpath("//android.view.View[@text='Email']"));
    private SelenideElement updateDataButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Update data']")),
            accessCodeButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Access code']")),
            deleteAccountButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Delete the account']"));
    private SelenideElement informationTab = $(AppiumBy.xpath("//android.view.View[@text='INFORMATION']")),
            documentsTab = $(AppiumBy.xpath("//android.view.View[@text='DOCUMENTS']"));
    @Step("Verify that 'My profile' page is opened correctly")
    public MyProfileInformation verifyInformationPageLoaded(){
        firstNameField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(firstNameValue.getAttribute("text"), "");
        lastNameField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(lastNameValue.getAttribute("text"), "");
        phoneNumberField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(phoneNumberValue.getAttribute("text"), "");
        emailField.shouldHave(exist, Duration.ofSeconds(25));
        updateDataButton.shouldHave(exist, Duration.ofSeconds(25));
        accessCodeButton.shouldHave(exist, Duration.ofSeconds(25));
        deleteAccountButton.shouldHave(exist, Duration.ofSeconds(25));
        informationTab.shouldHave(exist, Duration.ofSeconds(25));
        documentsTab.shouldHave(exist, Duration.ofSeconds(25));
        return this;
    }

    @Step("Verify that 'My profile' page is opened correctly")
    public MyProfileInformation selectDocumentsTab(){
        documentsTab.click();
        return this;
    }
}
