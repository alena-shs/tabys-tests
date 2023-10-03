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
import static mobileapp.drivers.DriverUtils.waitForDisplayed;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class IpoConsentPage {
    private final static Logger logger = LoggerFactory.getLogger(IpoConsentPage.class);

    @Step("Verify that the IPO 'Open account' page is fully loaded and has all the necessary elements (new onboarding)")
    public IpoConsentPage verifyPageLoaded(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            waitForDisplayed(driver, AppiumBy
                    .xpath("//android.widget.Button[@text[starts-with(., 'Open')]]"), 30);
//            List<WebElement> openButton = wait.until
//                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                            AppiumBy.xpath("//android.widget.Button[@text[starts-with(., 'Open')]]")));
//            assertEquals(1, openButton.size());
            sleep(500);

            wait.until
                    (visibilityOfNElementsLocatedBy(AppiumBy
                            .className("android.widget.Image"), 3));
        }
        return this;
    }

    @Step("Submit the IPO 'Open account' page and go to the next page")
    public void proceed(AppiumDriver driver) {

        if (Objects.equals(mobileenv, "browserstack-ios")) {
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text[starts-with(., 'Open')]]")).click();
        }
    }
}
