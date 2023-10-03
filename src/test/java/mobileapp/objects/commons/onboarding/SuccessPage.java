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

import static mobileapp.drivers.DriverUtils.*;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SuccessPage {
    private final static Logger logger = LoggerFactory.getLogger(SuccessPage.class);
    @Step("Verify that the onboarding success page is fully loaded and has all the necessary elements")
    public SuccessPage verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> promoteButton = wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.Button"), 1));
            assertTrue(promoteButton.get(0).isEnabled());
        }
        return this;
    }

    @Step("Press on Promote the queue")
    public SuccessPage promoteQueue(AppiumDriver driver) {

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
        }
        return this;
    }

    @Step("Verify that the 'Share with friends' page is fully loaded and has all the necessary elements")
    public SuccessPage verifySharingPageLoaded(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .xpath("//android.widget.TextView[@text[starts-with(., 'Shar')]]"), 1));

            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[@text='Exit']"), 10);
            waitForEnabled(driver, AppiumBy
                    .xpath("//*[@text='Exit']"), 10);
        }
        return this;
    }

    @Step("Exit")
    public void exit(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .xpath("//*[@text='Exit']"), 1)).get(0).click();
            driver.findElement(AppiumBy
                    .xpath("//*[@text='Exit']")).click();
        }
    }
}
