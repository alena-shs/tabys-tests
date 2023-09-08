package mobileapp.objects.commons;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;

import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordRecoveryPage {
    @Step("Enter in the phone number for recovery")
    public PasswordRecoveryPage enterPhoneNumber(AppiumDriver driver, String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            System.out.println("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            WebElement header = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Phone number']")));

            WebElement inputField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.className("android.widget.EditText")));
            assertTrue(inputField.isEnabled());

            inputField.click();
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.className("android.widget.EditText")))
                    .sendKeys(phoneNumber.substring(1));
        }
        return this;
    }

    @Step("Click 'Get SMS code to initiate OTP")
    public void initiateRegistrationOtp(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            System.out.println("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            WebElement button = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.className("android.widget.Button")));
            assertTrue(button.isEnabled());
            button.click();
        }
    }
}
