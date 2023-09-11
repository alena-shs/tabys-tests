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

public class CardBasePage {
    private final static Logger logger = LoggerFactory.getLogger(CardBasePage.class);

    @Step("Verify that the cards main page is fully loaded and has all the necessary elements")
    public CardBasePage verifyPageLoaded(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> header = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//*[@text='Register new card']")));
            assertEquals(1, header.size());

            List<WebElement> kaspiCardIcon = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Image[@text='kaspi_card']")));
            assertEquals(1, kaspiCardIcon.size());

            List<WebElement> cnpCardIcon = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Image[@text='bank_card_blue']")));
            assertEquals(1, cnpCardIcon.size());
        }
        return this;
    }

    @Step("Choose CNP card over Kaspi card")
    public CardBasePage chooseCnpCard(AppiumDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> cnpButtonNoCard = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[@text='Add another card']")));
            assertEquals(1, cnpButtonNoCard.size());
            assertTrue(cnpButtonNoCard.get(0).isEnabled());
            cnpButtonNoCard.get(0).click();
        }
        return this;
    }

    @Step("Verify that the CNP fees modal is open")
    public CardBasePage verifyFeeModalOpened(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> modalChooseKaspiButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[@text='Add Kaspi card']")));
            assertEquals(1, modalChooseKaspiButton.size());
            assertTrue(modalChooseKaspiButton.get(0).isEnabled());

            List<WebElement> modalChooseCnpButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[@text='Add another bank card']")));
            assertEquals(1, modalChooseCnpButton.size());
            assertTrue(modalChooseCnpButton.get(0).isEnabled());

        }
        return this;
    }

    @Step("Choose a CNP card")
    public void confirmChooseCnpCard(AppiumDriver driver) {

        driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add another bank card']"))
                .click();
    }
}
