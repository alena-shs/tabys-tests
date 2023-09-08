package mobileapp.objects.commons;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;

import static com.codeborne.selenide.Selenide.sleep;
import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StartPage {


    @Step("Click on 'Ready to start'")
    public void clickReadyToStart(WebDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            System.out.println("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            sleep(10000);
            WebElement background = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@resource-id='background-content']")));

            List<WebElement> availableButtons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));

            assertEquals(2, availableButtons.size());
            assertTrue(availableButtons.get(0).isEnabled());

            availableButtons.get(0).click();
        }
    }

    @Step("Click on 'I'm already registered'")
    public void clickImAlreadyRegistered(AppiumDriver driver) throws NoSuchElementException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            System.out.println("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            sleep(10000);
            WebElement background = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//*[@resource-id='background-content']")));

            List<WebElement> availableButtons = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.className("android.widget.Button")));

            assertEquals(2, availableButtons.size());
            assertTrue(availableButtons.get(1).isEnabled());

            availableButtons.get(1).click();
        }
    }


}
