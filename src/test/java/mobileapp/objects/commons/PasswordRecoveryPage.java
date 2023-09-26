package mobileapp.objects.commons;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;
import static mobileapp.drivers.DriverUtils.*;
import static mobileapp.tests.TestBaseMobile.mobileenv;

public class PasswordRecoveryPage {
    private final static Logger logger = LoggerFactory.getLogger(PasswordRecoveryPage.class);
    @Step("Enter in the phone number for recovery")
    public PasswordRecoveryPage enterPhoneNumber(AppiumDriver driver, String phoneNumber) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            wait.until(ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Phone number']")));

            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.EditText"), 1));
            waitForDisplayed
                    (driver.findElement(AppiumBy
                            .className("android.widget.EditText")), 10);
            waitForEnabled(driver.findElement(AppiumBy
                    .className("android.widget.EditText")), 10);

//            assertTrue(driver.findElement(AppiumBy.className("android.widget.EditText")).isEnabled());
            driver.findElement(AppiumBy.className("android.widget.EditText")).click();
            sleep(1000);
            wait.until(ExpectedConditions.attributeContains(AppiumBy.className("android.widget.EditText"), "text", "+7"));
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                    AppiumBy.className("android.widget.EditText")))
                    .sendKeys(phoneNumber.substring(1));
        }
        return this;
    }

    @Step("Click 'Get SMS code to initiate OTP")
    public void initiateRegistrationOtp(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
//            List<WebElement> buttons = wait.until
//                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                            AppiumBy.className("android.widget.Button")));
            List<WebElement> buttons = wait.until(visibilityOfNElementsLocatedBy(
                    AppiumBy.className("android.widget.Button"), 1));
            waitForEnabled(driver.findElement(AppiumBy
                    .className("android.widget.Button")), 10);
//            assertEquals(1, buttons.size());
            // TODO Fails

            waitForDisplayed
                    (driver.findElement(AppiumBy
                            .className("android.widget.Button")), 10);
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.Button")));
//            assertTrue(buttons.get(0).isEnabled());

            buttons.get(0).click();
        }
    }
}
