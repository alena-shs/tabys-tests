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
import static mobileapp.drivers.DriverUtils.visibilityOfNElementsLocatedBy;
import static mobileapp.tests.TestBaseMobile.mobileenv;
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

            List<WebElement> input = wait.until(visibilityOfNElementsLocatedBy(
                    AppiumBy.className("android.widget.EditText"), 4));
            for(WebElement element : driver.findElements(AppiumBy.className("android.widget.EditText"))){
                assertTrue(element.isEnabled());
            }

//            assertTrue(input.get(0).isEnabled());

            driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(pin);
            // Give some time for the pin code to get processed
            sleep(3000);
        }
        return this;
    }

    @Step("Set up a new PIN code")
    public void repeatPin(AppiumDriver driver, String pin){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            if (driver.findElements(AppiumBy.className("android.widget.EditText")).size()==4){
                wait.until
                        (ExpectedConditions.visibilityOfElementLocated(
                                AppiumBy.xpath("//*[@text='Repeat 4-digit PIN to login']")));

                assertTrue(driver.findElements(AppiumBy.className("android.widget.EditText")).get(0).isEnabled());

                driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(pin);
                // Give some time for the pin code to get processed
                sleep(2000);
            } else {
                logger.info("Note that the app didn't require to repeat PIN code");
            }
        }
    }
}
