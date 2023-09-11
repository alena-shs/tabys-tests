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

public class MyProfileDocuments {
    private final static Logger logger = LoggerFactory.getLogger(MyProfileDocuments.class);

    @Step("Verify that 'My profile' page is opened correctly")
    public MyProfileDocuments verifyPageLoaded(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            WebElement myCardsButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='My cards']")));
            myCardsButton.isEnabled();
            WebElement myAccountButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='My account']")));
            myAccountButton.isEnabled();
            WebElement termsOfServiceButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Terms of service']")));
            termsOfServiceButton.isEnabled();
            WebElement privacyPolicyButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Privacy policy']")));
            privacyPolicyButton.isEnabled();
            WebElement agreementCsdButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Agreement with AIX CSD']")));
            agreementCsdButton.isEnabled();
        }
        return this;
    }

    @Step("Go to 'My cards' section")
    public void myCardsTap(AppiumDriver driver) {
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='My cards']")).click();
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='My cards']")).click();
        }
    }
}
