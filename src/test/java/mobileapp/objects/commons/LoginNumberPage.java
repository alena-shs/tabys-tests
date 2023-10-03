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

import static com.codeborne.selenide.Selenide.sleep;
import static mobileapp.drivers.DriverUtils.visibilityOfNElementsLocatedBy;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginNumberPage {
    private final static Logger logger = LoggerFactory.getLogger(LoginNumberPage.class);
    @Step("Enter credentials")
    public LoginNumberPage enterCredentials(AppiumDriver driver, String phoneNumber, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            List<WebElement> inputFields = wait.until
                    (visibilityOfNElementsLocatedBy(
                            AppiumBy.className("android.widget.EditText"), 2));

            inputFields.get(0).sendKeys(phoneNumber.substring(1));
            inputFields.get(1).sendKeys(password);
        }
        return this;
    }

    @Step("Tap on Forgot Password")
    public void tapForgotPassword(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            WebElement forgotPasswordButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Forgot password?']")));
            assertTrue(forgotPasswordButton.isEnabled());

            forgotPasswordButton.click();
        }
    }
}
