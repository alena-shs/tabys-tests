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
import java.util.Objects;

import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MyBondsSharesMainPage {
    private final static Logger logger = LoggerFactory.getLogger(MyBondsSharesMainPage.class);

    @Step("Verify that 'My bonds/Shares' page is opened correctly")
    public MyBondsSharesMainPage verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='My Bonds/Shares']")));

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='My balance']")));

            WebElement cashAccountButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Cash account']")));
            assertTrue(cashAccountButton.isEnabled());

            WebElement offeringsVotingsButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Offerings / Votings']")));
            assertTrue(offeringsVotingsButton.isEnabled());

            WebElement myProfileButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='My profile']")));
            assertTrue(myProfileButton.isEnabled());

            WebElement ordersButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Orders']")));
            assertTrue(ordersButton.isEnabled());

            WebElement messagesButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Messages']")));
            assertTrue(messagesButton.isEnabled());
        }
        return this;
    }

    @Step("Go to 'My profile' section")
    public void myProfileTap(AppiumDriver driver) {
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//*[@text='My profile']")).click();
        }
    }

}
