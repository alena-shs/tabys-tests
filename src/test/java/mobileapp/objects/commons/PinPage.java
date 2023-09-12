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

import static com.codeborne.selenide.Selenide.sleep;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PinPage {
    private final static Logger logger = LoggerFactory.getLogger(PinPage.class);

    @Step("Set up a new PIN code")
    public PinPage setUpPinFirst(AppiumDriver driver, String pin){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Come up with 4 digit pin code to log in']")));

            sleep(2000);

            List<WebElement> input = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            (AppiumBy.className("android.widget.EditText"))));
            assertEquals(4, input.size());
            assertTrue(input.get(0).isEnabled());

            input.get(0).sendKeys(pin);
            sleep(2000);
        }
        return this;
    }

    @Step("Set up a new PIN code")
    public void repeatPin(AppiumDriver driver, String pin){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Repeat 4-digit PIN to login']")));

            List<WebElement> input = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            (AppiumBy.className("android.widget.EditText"))));
            assertEquals(4, input.size());
            assertTrue(input.get(0).isEnabled());

            input.get(0).sendKeys(pin);
            sleep(2000);
        }
    }
}
