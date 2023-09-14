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

public class IinPage {
    private final static Logger logger = LoggerFactory.getLogger(IinPage.class);

    @Step("Verify that the IIN input page is fully loaded and has all the necessary elements")
    public IinPage verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Personal information']")));

            List<WebElement> inputFields = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.EditText")));
            assertEquals(1, inputFields.size());
            assertTrue(inputFields.get(0).isEnabled());

            List<WebElement> buttons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));
            assertEquals(1, buttons.size());

            buttons.get(0).click();
        }
        return this;
    }

    @Step("Enter in the IIN")
    public IinPage setIin(AppiumDriver driver, String iin) {
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.className("android.widget.EditText")).sendKeys(iin);
        }
        return this;
    }

    @Step("Verify that IIN is found")
    public void verifyIinFound(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Kazakhstan']")));
            List<WebElement> kazakhstanCitizen = driver.findElements(
                    AppiumBy.xpath("//*[@text='I am a citizen of Kazakhstan']"));
            assertEquals(0, kazakhstanCitizen.size());
        }
    }
}
