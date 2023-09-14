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

import static mobileapp.data.MobileTestData.defaultEmail;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MobileCommonElements {
    private final static Logger logger = LoggerFactory.getLogger(MobileCommonElements.class);
    @Step("Proceed (with the only button on the screen)")
    public MobileCommonElements tapOnAvailableButton(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.className("android.widget.Button")));
            WebElement availableButton = wait.until
                    (ExpectedConditions.elementToBeClickable(
                            AppiumBy.className("android.widget.Button")));
            availableButton.click();
        }
        return this;
    }

    @Step("Proceed with onboarding")
    public void proceedOnboarding(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")));
            WebElement onboardingNextButton = wait.until
                    (ExpectedConditions.elementToBeClickable(
                            AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")));
            onboardingNextButton.click();
        }
    }

    @Step("Enter in both emails")
    public MobileCommonElements enterEmail(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> availableButtons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.EditText")));
            assertEquals(2, availableButtons.size());
            assertTrue(availableButtons.get(0).isEnabled());
            assertTrue(availableButtons.get(1).isEnabled());

            availableButtons.get(0).sendKeys(defaultEmail);
            availableButtons.get(1).sendKeys(defaultEmail);
        }
        return this;
    }
}