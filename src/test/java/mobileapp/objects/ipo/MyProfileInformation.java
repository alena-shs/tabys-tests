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
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MyProfileInformation {
    private final static Logger logger = LoggerFactory.getLogger(MyProfileInformation.class);

    @Step("Verify that 'My profile' information tab page is fully loaded and has all the necessary elements")
    public MyProfileInformation verifyPageLoaded(AppiumDriver driver){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Name']")));
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Surname']")));
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Email']")));
            wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text[starts-with(., '+')]]")));

            WebElement firstNameValue = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Name']/following-sibling::android.widget.TextView")));
            assertNotEquals("", firstNameValue.getAttribute("text"));

            WebElement lastNameValue = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Surname']/following-sibling::android.widget.TextView")));
            assertNotEquals(lastNameValue.getAttribute("text"), "");

            WebElement updateDataButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Update data']")));
            updateDataButton.isEnabled();

            WebElement deleteAccountButton = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.widget.TextView[@text='Delete the account']")));
            deleteAccountButton.isEnabled();

            WebElement informationTab = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='INFORMATION']")));
            informationTab.isEnabled();

            WebElement documentsTab = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@text='DOCUMENTS']")));
            documentsTab.isEnabled();
        }
        return this;
    }

    @Step("Go to 'My profile' page's Documents tab")
    public void selectDocumentsTab(AppiumDriver driver){

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//*[@text='DOCUMENTS']")).click();
        }
    }

    @Step("Click on 'Update data' button")
    public void tapUpdateData(AppiumDriver driver){
        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text='Update data']")).click();

        }
    }
}
