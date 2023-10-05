package mobileapp.objects.commons;

import commons.database.requests.AcsFetchOtp;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Objects;

import static commons.database.requests.AcsFetchOtp.userRestorePasswordCode;
import static mobileapp.drivers.DriverUtils.visibilityOfNElementsLocatedBy;
import static mobileapp.drivers.DriverUtils.waitForDisplayed;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OtpPage {
    private final static Logger logger = LoggerFactory.getLogger(OtpPage.class);
    AcsFetchOtp acsDatabaseConnections = new AcsFetchOtp();
    @Step("Enter registration OTP Code")
    public void enterRegistrationOtpCode(AppiumDriver driver, String phoneNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            String registrationCode = acsDatabaseConnections.phoneNumberConfirmationCode(phoneNumber);

            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[contains(@text, 'PIN')]"), 30);

            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.EditText"), 4));
            for(WebElement element : driver.findElements(AppiumBy.className("android.widget.EditText"))){
                assertTrue(element.isEnabled());
            }

            driver.findElements(AppiumBy
                    .className("android.widget.EditText")).get(0)
                    .sendKeys(registrationCode);
        }
    }

    @Step("Enter password restoring OTP code")
    public void enterRestorePasswordOtpCode(AppiumDriver driver, String phoneNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            String restorePasswordOtp = userRestorePasswordCode(phoneNumber);

            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[contains(@text, 'PIN')]"), 30);

            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.EditText"), 4));
            for(WebElement element : driver.findElements(AppiumBy.className("android.widget.EditText"))){
                assertTrue(element.isEnabled());
            }

            driver.findElements(AppiumBy
                    .className("android.widget.EditText")).get(0)
                    .sendKeys(restorePasswordOtp);
        }
    }
}
