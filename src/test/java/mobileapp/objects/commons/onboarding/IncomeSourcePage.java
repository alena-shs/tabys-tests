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

public class IncomeSourcePage {
    private final static Logger logger = LoggerFactory.getLogger(IncomeSourcePage.class);

    @Step("Verify that the page is fully loaded and has all the necessary elements")
    public IncomeSourcePage verifyPageLoaded(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            waitForDisplayed(driver, AppiumBy
                    .xpath("//android.widget.TextView[contains(@text, 'ncome')]"), 15);

            List<WebElement> availableButtons = wait.until
                    (visibilityOfNElementsLocatedBy(
                            AppiumBy.className("android.widget.Button"), 5));
            for (WebElement availableButton : availableButtons) {
                assertTrue(availableButton.isEnabled());
            }
        }
        return this;
    }

    @Step("Enter in the income source and get the result")
    public void setIncomeSource(AppiumDriver driver, String incomeSource) throws InterruptedException {
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            waitForDisplayed(driver, AppiumBy
                    .xpath("//android.widget.Button[@text='"+ incomeSource +"']"), 5);
            waitForEnabled(driver, AppiumBy
                    .xpath("//android.widget.Button[@text='"+ incomeSource +"']"), 5);
            driver.findElement(AppiumBy
                    .xpath("//android.widget.Button[@text='"+ incomeSource +"']")).click();
        }
    }
}
