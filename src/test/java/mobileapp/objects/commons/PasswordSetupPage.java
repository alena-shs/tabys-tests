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
import static mobileapp.data.MobileTestData.defaultPassword;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PasswordSetupPage {
    private final static Logger logger = LoggerFactory.getLogger(PasswordSetupPage.class);
    @Step("Enter in password and confirm it")
    public void setPasswordNewAccount(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            sleep(2000);

            List<WebElement> passwordFields = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.EditText")));
            assertTrue(passwordFields.get(0).isEnabled());
            assertTrue(passwordFields.get(1).isEnabled());
            assertEquals(2, passwordFields.size());

            passwordFields.get(0).sendKeys(defaultPassword);
            passwordFields.get(1).sendKeys(defaultPassword);
        }
    }
}
