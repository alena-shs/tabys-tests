package mobileapp.objects.commons.onboarding;

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
import static mobileapp.drivers.DriverUtils.visibilityOfNElementsLocatedBy;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class OnboardingMigrationPage {
    private final static Logger logger = LoggerFactory.getLogger(OnboardingMigrationPage.class);
    @Step("Verify that the 'Share with friends'page is fully loaded and has all the necessary elements")
    public OnboardingMigrationPage verifyMigrationPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> sharingHeader = wait.until
                    (visibilityOfNElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Confirm data']"), 1));

            List<WebElement> accessCode = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[contains(@text, 'Access code')]")));
            assertEquals(1, accessCode.size());
            assertTrue(accessCode.get(0).isEnabled());

            List<WebElement> agree = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[contains(@text, 'open account')]")));
            assertEquals(1, agree.size());
            assertTrue(agree.get(0).isEnabled());

            List<WebElement> openingAgreement = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[contains(@text, 'Agreement')]")));
            assertEquals(1, openingAgreement.size());
            assertTrue(openingAgreement.get(0).isEnabled());

            List<WebElement> privacyPolicy = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[contains(@text, 'Privacy')]")));
            assertEquals(1, privacyPolicy.size());
            assertTrue(privacyPolicy.get(0).isEnabled());

            List<WebElement> termsOfUse = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[contains(@text, 'Terms of Use')]")));
            assertEquals(1, termsOfUse.size());
            assertTrue(termsOfUse.get(0).isEnabled());

            List<WebElement> disagree = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[contains(@text, 'update')]")));
            assertEquals(1, disagree.size());
            assertTrue(disagree.get(0).isEnabled());

            List<WebElement> buttons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));
            assertEquals(2, buttons.size());
            assertTrue(buttons.get(0).isEnabled());
            assertTrue(buttons.get(1).isEnabled());
        }
        return this;
    }

    @Step("Verify that the 'Share with friends'page is fully loaded and has all the necessary elements")
    public void agreeOpenAccount(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (Objects.equals(mobileenv, "browserstack-ios")) {
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            sleep(1000);
            driver.findElement(AppiumBy.xpath("//android.widget.Button[contains(@text, 'open account')]")).click();
            sleep(1000);
        }
    }
}
