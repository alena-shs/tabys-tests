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
import java.util.NoSuchElementException;
import java.util.Objects;

import static java.lang.Thread.sleep;
import static mobileapp.drivers.DriverUtils.waitForDisplayed;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhotoFinishedPage {
    private final static Logger logger = LoggerFactory.getLogger(PhotoFinishedPage.class);
    @Step("Verify that the 'Identification completed' page is fully loaded and has all the necessary elements")
    public PhotoFinishedPage verifyPageLoaded(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            waitForDisplayed(driver, AppiumBy
                    .xpath("//*[@text='Identification completed']"), 30);

            List<WebElement> nextButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));
            assertEquals(2, nextButton.size());
            assertTrue(nextButton.get(0).isEnabled());

        }
        return this;
    }
//    @Step("Check if onboarding is stuck. If YES, keep pressing on 'Done' button. WARNING: This is a bug that verification gets stuck sometimes. Please remove this step once the bug is fixed")
//    public PhotoFinishedPage checkOnboardingStuck(AppiumDriver driver) {
//        try {
//            sleep(9000);
//            while (driver.findElements(AppiumBy.xpath("//android.widget.Button[@text='Done']")).size() != 0) {
//                driver.findElements(AppiumBy.xpath("//android.widget.Button[@text='Done']")).get(0).click();
//            }
//        } catch (NoSuchElementException | InterruptedException e){
//            System.out.println(e.getMessage());
//        }
//        return this;
//    }
}
