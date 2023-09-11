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
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TabysNavigation {
    private final static Logger logger = LoggerFactory.getLogger(TabysNavigation.class);

    @Step("Verify that TABYS navigation is opened correctly")
    public TabysNavigation verifyNavigationAvailable(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            WebElement navigationPanelHome = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.view.View[@resource-id='tab-button-home-tab']")));
            navigationPanelHome.isEnabled();

            WebElement navigationPanelPortfolio = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.view.View[@resource-id='tab-button-goal-tab']")));
            navigationPanelPortfolio.isEnabled();

            WebElement navigationPanelShop = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.view.View[@resource-id='tab-button-shop-tab']")));
            navigationPanelShop.isEnabled();

            WebElement navigationPanelMessages = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.view.View[@resource-id='tab-button-message-tab']")));
            navigationPanelMessages.isEnabled();

            WebElement navigationPanelProfile = wait.until
                    (ExpectedConditions.visibilityOfElementLocated(
                            AppiumBy.xpath("//android.view.View[@resource-id='tab-button-profile-tab']")));
            navigationPanelProfile.isEnabled();
        }
        return this;
    }

    @Step("Choose 'Profile' in the navigation panel")
    public void clickTabProfile(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {

            WebElement navigationPanelProfile = wait.until

                    (ExpectedConditions.presenceOfElementLocated(
                            (AppiumBy.xpath("//android.view.View[@resource-id='tab-button-profile-tab']"))));
            assertTrue(navigationPanelProfile.isEnabled());

            navigationPanelProfile.click();
        }

    }
}
