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

public class ProfileTab {
    private final static Logger logger = LoggerFactory.getLogger(ProfileTab.class);
    @Step("Open the 'Personal information' screen")
    public void clickPersonalInformation(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            WebElement personalInformation = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.className("//android.widget.TextView[@text='Personal information']")));
            personalInformation.isEnabled();
            personalInformation.click();
        }
    }
}
