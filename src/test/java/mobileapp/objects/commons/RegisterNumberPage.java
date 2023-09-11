package mobileapp.objects.commons;

import com.codeborne.selenide.Selenide;
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

import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterNumberPage {
    private final static Logger logger = LoggerFactory.getLogger(RegisterNumberPage.class);
    @Step("Proceed from Register page")
    public RegisterNumberPage enterPhoneNumber(AppiumDriver driver, String phoneNumber) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            List<WebElement> inputFields = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("android.widget.EditText")));
            assertEquals(1, inputFields.size());
            assertTrue(inputFields.get(0).isEnabled());

            inputFields.get(0).click();
            Selenide.sleep(2000);

            driver.findElement(AppiumBy.xpath("android.widget.EditText"))
                    .sendKeys(phoneNumber.substring(1));
        }
        return this;
    }

    @Step("Click 'Get SMS code to initiate OTP")
    public void initiateRegistrationOtp(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){

            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> buttons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("android.widget.Button")));
            assertEquals(1, buttons.size());
            assertTrue(buttons.get(0).isEnabled());

            buttons.get(0).click();
        }
    }
}
