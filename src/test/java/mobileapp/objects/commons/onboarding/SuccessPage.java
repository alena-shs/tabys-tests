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
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));
            assertEquals(1, promoteButton.size());
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

    @Step("Verify that the 'Share with friends'page is fully loaded and has all the necessary elements")
    public SuccessPage verifySharingPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> sharingHeader = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text[starts-with(., 'Shar')]]")));
            assertEquals(1, sharingHeader.size());

            List<WebElement> exitButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Exit']")));
            assertEquals(1, exitButton.size());
            assertTrue(exitButton.get(0).isEnabled());
        }
        return this;
    }

    @Step("Exit")
    public void exit(AppiumDriver driver) {

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//*[@text='Exit']")).click();
        }
    }
}
