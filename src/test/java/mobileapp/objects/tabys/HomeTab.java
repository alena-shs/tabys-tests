package mobileapp.objects.tabys;

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

public class HomeTab {
    private final static Logger logger = LoggerFactory.getLogger(HomeTab.class);

    @Step("Verify that tabys home page is open")
    public HomeTab verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Invested']")));

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Income']")));

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='Goals']")));

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='The last investment']")));
        }
        return this;
    }

    @Step("Press on ETN Registration button")
    public void etnRegistrationButtonClick(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            WebElement availableButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.className("android.widget.Button")));
            availableButton.isEnabled();
            availableButton.click();
        }
    }

    @Step("Press on My bonds/shares button")
    public void ipoBannerClick(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            WebElement ipoBanner = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.className("//*[@text='My Bonds/Shares']")));
            ipoBanner.isEnabled();
            ipoBanner.click();
        }
    }
}
