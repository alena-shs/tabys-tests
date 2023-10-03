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
            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[@text='Phone number']"), 20);

            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.EditText"), 1));
            waitForDisplayed(driver, AppiumBy
                    .className("android.widget.EditText"), 10);
            waitForEnabled(driver, AppiumBy
                    .className("android.widget.EditText"), 10);

            driver.findElement(AppiumBy.className("android.widget.EditText")).click();
//            sleep(1000);
            System.out.println(phoneNumber.substring(1));
//            wait.until(ExpectedConditions.attributeContains(AppiumBy.className("android.widget.EditText"), "text", "+7"));
            waitForDisplayed(driver, AppiumBy.xpath("//android.widget.EditText[@text='+7']"), 20);
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
            List<WebElement> buttons = wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.Button"), 1));
            waitForEnabled(driver, AppiumBy
                    .className("android.widget.Button"), 10);

            waitForDisplayed(driver, AppiumBy
                            .className("android.widget.Button"), 10);
            wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.className("android.widget.Button")));

            buttons.get(0).click();
            buttons.get(0).click();
            buttons.get(0).click();
        }
    }
}
