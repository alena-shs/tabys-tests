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

public class VideocheckRulesPage {
    private final static Logger logger = LoggerFactory.getLogger(VideocheckRulesPage.class);
    @Step("Verify that the page is fully loaded and has all the necessary elements (new onboarding)")
    public VideocheckRulesPage verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> header = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Video verification']")));
            assertEquals(1, header.size());

            List<WebElement> secondaryText = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Hold the ID at face level without covering it with your fingers or head and shoot a 5 second video.']")));
            assertEquals(1, secondaryText.size());

            List<WebElement> firstRule = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Prepare your ID card']")));
            assertEquals(1, firstRule.size());

//            List<WebElement> nextButton = wait.until
//                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                            AppiumBy.xpath("//*[@text='Make a video']")));
//            assertEquals(1, nextButton.size());
//            assertTrue(nextButton.get(0).isEnabled());
        }
        return this;
    }
}
