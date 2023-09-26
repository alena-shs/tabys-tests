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
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class IncomeSourcePage {
    private final static Logger logger = LoggerFactory.getLogger(IncomeSourcePage.class);

    @Step("Verify that the page is fully loaded and has all the necessary elements")
    public IncomeSourcePage verifyPageLoaded(AppiumDriver driver) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> incomeKeyword = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.TextView[contains(@text, 'ncome')]")));
            assertEquals(2, incomeKeyword.size());

            sleep(3000);

            List<WebElement> availableButtons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));
            assertEquals(5, availableButtons.size());
            for (int elementNumber = 0; elementNumber < availableButtons.size(); elementNumber++) {
                assertTrue(availableButtons.get(elementNumber).isEnabled());
            }


        }
        return this;
    }
    @Step("Enter in the income source and get the result")
    public IncomeSourcePage setIncomeSource(AppiumDriver driver, String incomeSource) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            WebElement incomeSourceButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.Button[@text='"+ incomeSource +"']")));
            assertTrue(incomeSourceButton.isEnabled());
            incomeSourceButton.click();
        }
        return this;
    }

//    @Step("Enter in the income source and get the result")
//    public void confirmIncomeSource(AppiumDriver driver) {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2));
//
//        if (Objects.equals(mobileenv, "browserstack-ios")){
//            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
//        } else {
//            List<WebElement> continueButton = wait.until
//                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
//                            AppiumBy.xpath("//android.widget.Button[@text='Continue']")));
//            assertEquals(1, continueButton.size());
//            assertTrue(continueButton.get(0).isEnabled());
//            continueButton.get(0).click();
//        }
//    }
}
