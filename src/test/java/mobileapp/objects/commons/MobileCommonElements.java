package mobileapp.objects.commons;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.Objects;

import static java.lang.Thread.sleep;
import static mobileapp.drivers.DriverUtils.waitForDisplayed;
import static mobileapp.drivers.DriverUtils.waitForEnabled;
import static mobileapp.tests.TestBaseMobile.mobileenv;

public class MobileCommonElements {
    private final static Logger logger = LoggerFactory.getLogger(MobileCommonElements.class);
    @Step("Proceed (with the only button on the screen)")
    public MobileCommonElements tapOnAvailableButton(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            sleep(500);
            waitForDisplayed(driver, AppiumBy
                    .className("android.widget.Button"), 15);
            waitForEnabled(driver, AppiumBy
                    .className("android.widget.Button"), 15);
            driver.findElement(AppiumBy.className("android.widget.Button")).click();
            sleep(500);
//            wait.until
//                    (ExpectedConditions.visibilityOfElementLocated(
//                            AppiumBy.className("android.widget.Button")));
//            WebElement availableButton = wait.until
//                    (ExpectedConditions.elementToBeClickable(
//                            AppiumBy.className("android.widget.Button")));
//            availableButton.click();
        }
        return this;
    }

    @Step("Proceed with onboarding")
    public void proceedOnboarding(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            sleep(500);
            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[@resource-id='dynamic-forms-next-button']"), 10);
            waitForEnabled(driver, AppiumBy
                    .xpath("//*[@resource-id='dynamic-forms-next-button']"), 10);
//            List<WebElement> onboardingNextButton = wait.until
//                    (visibilityOfNElementsLocatedBy(
//                            AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']"),1));
//            List<WebElement> onboardingNextButton = wait.until
//                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                            AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")));
//            assertEquals(1, onboardingNextButton.size());
//            assertTrue(onboardingNextButton.get(0).isEnabled());
            driver.findElement(AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")).click();
            sleep(500);
        }
    }
}