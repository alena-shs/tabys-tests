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

public class CardRulePage {
    private final static Logger logger = LoggerFactory.getLogger(CardRulePage.class);
    @Step("Verify that the 'Name card' page (cards rule page) is fully loaded and has all the necessary elements")
    public CardRulePage verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> header = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Name card']")));
            assertEquals(1, header.size());

            List<WebElement> nextButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));
            assertEquals(1, nextButton.size());
            assertTrue(nextButton.get(0).isEnabled());
        }
        return this;
    }
}
