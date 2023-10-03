package mobileapp.objects.commons.onboarding;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static mobileapp.drivers.DriverUtils.*;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CardRulePage {
    private final static Logger logger = LoggerFactory.getLogger(CardRulePage.class);
    @Step("Verify that the 'Name card' page (cards rule page) is fully loaded and has all the necessary elements")
    public CardRulePage verifyPageLoaded(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[@text='Name card']"), 2);

            waitForDisplayed(driver, AppiumBy
                    .className("android.widget.Button"), 2);
            waitForEnabled(driver, AppiumBy
                    .className("android.widget.Button"), 2);
            List<WebElement> nextButton = wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.Button"), 1));
            assertTrue(nextButton.get(0).isEnabled());
        }
        return this;
    }
}
