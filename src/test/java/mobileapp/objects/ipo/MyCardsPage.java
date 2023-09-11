package mobileapp.objects.ipo;

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

public class MyCardsPage {
    private final static Logger logger = LoggerFactory.getLogger(MyCardsPage.class);

    @Step("Verify that 'My profile' page is opened correctly")
    public MyCardsPage verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> header = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.view.View[@text='My cards']")));
            assertEquals(1, header.size());

            List<WebElement> button = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.TextView[@text='Register new card']")));
            assertEquals(1, button.size());
            assertTrue(button.get(0).isEnabled());
        }
        return this;
    }

    @Step("Choose to Register new card")
    public void registerNewCardsTap(AppiumDriver driver) {
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Register new card']")).click();
        driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Register new card']")).click();
    }
}

