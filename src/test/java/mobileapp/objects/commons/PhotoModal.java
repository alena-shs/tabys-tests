package mobileapp.objects.commons;

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

public class PhotoModal {
    private final static Logger logger = LoggerFactory.getLogger(PhotoModal.class);
    @Step("Verify that the modal to take photos is fully loaded and has all the necessary elements")
    public PhotoModal verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> startCamera = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.view.View[@text='TURN ON CAMERA']")));
            assertEquals(1, startCamera.size());
            assertTrue(startCamera.get(0).isEnabled());

            List<WebElement> removePhoto = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.view.View[@text='REMOVE THE PHOTO']")));
            assertEquals(1, removePhoto.size());
            assertTrue(removePhoto.get(0).isEnabled());

            List<WebElement> close = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.view.View[@text='CLOSE']")));
            assertEquals(1, close.size());
            assertTrue(close.get(0).isEnabled());
        }
        return this;
    }

}
