package mobileapp.objects.tabys;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class TabysNavigation {
    private final SelenideElement navigationPanelHome = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-home-tab']")),
            navigationPanelPortfolio = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-goal-tab']")),
            navigationPanelShop = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-shop-tab']")),
            navigationPanelMessages = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-message-tab']")),
            navigationPanelProfile = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-profile-tab']"));

    @Step("Verify that TABYS navigation is opened correctly")
    public TabysNavigation verifyNavigationAvailable() {
        navigationPanelHome.shouldHave(exist, Duration.ofSeconds(25));
        navigationPanelPortfolio.shouldHave(exist, Duration.ofSeconds(25));
        navigationPanelShop.shouldHave(exist, Duration.ofSeconds(25));
        navigationPanelMessages.shouldHave(exist, Duration.ofSeconds(25));
        navigationPanelProfile.shouldHave(exist, Duration.ofSeconds(25));
        return this;
    }

    @Step("Choose 'Profile' in the navigation panel")
    public void clickTabProfile() {
        navigationPanelProfile.click();
    }
}
