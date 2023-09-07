package mobileapp.objects.ipo;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class MyProfileInformation {
    private SelenideElement firstNameField = $(AppiumBy.xpath("//android.widget.TextView[@text='Name']")),
            firstNameValue = $(AppiumBy.xpath("//android.widget.TextView[@text='Name']/following-sibling::android.widget.TextView"));
    private SelenideElement lastNameField = $(AppiumBy.xpath("//android.widget.TextView[@text='Surname']")),
            lastNameValue = $(AppiumBy.xpath("//android.widget.TextView[@text='Surname']/following-sibling::android.widget.TextView"));
    private SelenideElement phoneNumberField = $(AppiumBy.xpath("//android.widget.TextView[@text='Phone number']")),
            phoneNumberValue = $(AppiumBy.xpath("//android.widget.TextView[@text[starts-with(., '+')]]"));
    private SelenideElement emailField = $(AppiumBy.xpath("//android.widget.TextView[@text='Email']"));
    private SelenideElement updateDataButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Update data']")),
            accessCodeButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Access code']")),
            deleteAccountButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Delete the account']"));
    private SelenideElement informationTab = $(AppiumBy.xpath("//*[@text='INFORMATION']")),
            documentsTab = $(AppiumBy.xpath("//*[@text='DOCUMENTS']"));
    @Step("Verify that 'My profile' information tab page is fully loaded and has all the necessary elements")
    public MyProfileInformation verifyPageLoaded(){
        firstNameField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(firstNameValue.getAttribute("text"), "");
        lastNameField.shouldHave(exist, Duration.ofSeconds(25));
        Assertions.assertNotEquals(lastNameValue.getAttribute("text"), "");
        phoneNumberField.shouldHave(exist, Duration.ofSeconds(25));
        phoneNumberValue.shouldHave(exist, Duration.ofSeconds(25));
        emailField.shouldHave(exist, Duration.ofSeconds(25));
        updateDataButton.shouldHave(exist, Duration.ofSeconds(25));
//        accessCodeButton.shouldHave(exist, Duration.ofSeconds(25));
        deleteAccountButton.shouldHave(exist, Duration.ofSeconds(25));
        informationTab.shouldHave(exist, Duration.ofSeconds(25));
        documentsTab.shouldHave(exist, Duration.ofSeconds(25));
        return this;
    }

    @Step("Go to 'My profile' page's Documents tab")
    public MyProfileInformation selectDocumentsTab(){
        documentsTab.click();
        return this;
    }

    @Step("Click on 'Update data' button")
    public void tapUpdateData(){
        updateDataButton.shouldHave(exist, Duration.ofSeconds(25)).click();
    }
}
