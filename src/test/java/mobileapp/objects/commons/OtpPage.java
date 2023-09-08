package mobileapp.objects.commons;

import commons.database.requests.AcsFetchOtp;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static commons.database.requests.AcsFetchOtp.userRestorePasswordCode;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtpPage {
    AcsFetchOtp acsDatabaseConnections = new AcsFetchOtp();
    @Step("Enter registration OTP Code")
    public void enterRegistrationOtpCode(AppiumDriver driver, String phoneNumber){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            System.out.println("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            String registrationCode = acsDatabaseConnections.phoneNumberConfirmationCode(phoneNumber);

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[contains(@text, 'PIN')]")));

            List<WebElement> otp = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            (AppiumBy.className("android.widget.EditText"))));
            assertEquals(4, otp.size());
            assertTrue(otp.get(0).isEnabled());

            otp.get(0).sendKeys(registrationCode);
        }
    }

    @Step("Enter password restoring OTP code")
    public void enterRestorePasswordOtpCode(AppiumDriver driver, String phoneNumber){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            System.out.println("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            String restorePasswordOtp = userRestorePasswordCode(phoneNumber);

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[contains(@text, 'PIN')]")));

            List<WebElement> otp = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            (AppiumBy.className("android.widget.EditText"))));
            assertEquals(4, otp.size());
            assertTrue(otp.get(0).isEnabled());

            otp.get(0).sendKeys(restorePasswordOtp);
        }
    }
}
