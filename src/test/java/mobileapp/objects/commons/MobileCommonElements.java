package mobileapp.objects.commons;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static java.lang.Thread.sleep;
import static mobileapp.drivers.DriverUtils.waitForDisplayed;
import static mobileapp.drivers.DriverUtils.waitForEnabled;
import static mobileapp.tests.TestBaseMobile.mobileenv;

public class MobileCommonElements {
    private final static Logger logger = LoggerFactory.getLogger(MobileCommonElements.class);
    @Step("Proceed (with the only button on the screen)")
    public void tapOnAvailableButton(AppiumDriver driver) throws InterruptedException {
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
        }
    }

    @Step("Proceed with onboarding")
    public void proceedOnboarding(AppiumDriver driver) throws InterruptedException {
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            sleep(500);
            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[@resource-id='dynamic-forms-next-button']"), 10);
            waitForEnabled(driver, AppiumBy
                    .xpath("//*[@resource-id='dynamic-forms-next-button']"), 10);
            driver.findElement(AppiumBy.xpath("//*[@resource-id='dynamic-forms-next-button']")).click();
            sleep(500);
        }
    }
}