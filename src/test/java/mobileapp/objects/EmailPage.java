package mobileapp.objects;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import mobileapp.objects.commons.MobileCommonElements;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static mobileapp.data.MobileTestData.defaultEmail;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class EmailPage {
    private final static Logger logger = LoggerFactory.getLogger(MobileCommonElements.class);
    @Step("Verify that the Email page is opened and fully loaded")
    public EmailPage verifyPageLoaded(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> header = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Email']")));
            assertEquals(1, header.size());

            List<WebElement> availableInputs = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.EditText")));
            assertEquals(2, availableInputs.size());
            assertTrue(availableInputs.get(0).isEnabled());
            assertTrue(availableInputs.get(1).isEnabled());
        }
        return this;
    }

    @Step("Enter in both emails")
    public EmailPage enterEmail(AppiumDriver driver, String email){

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElements(AppiumBy.className("android.widget.EditText")).get(0).sendKeys(email);
            driver.findElements(AppiumBy.className("android.widget.EditText")).get(1).sendKeys(email);
        }
        return this;
    }

    @Step("Submit the email")
    public EmailPage submitEmail(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> availableButtons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Continue']")));
            assertEquals(1, availableButtons.size());
            assertTrue(availableButtons.get(0).isEnabled());

            availableButtons.get(0).click();
        }
        return this;
    }
}
