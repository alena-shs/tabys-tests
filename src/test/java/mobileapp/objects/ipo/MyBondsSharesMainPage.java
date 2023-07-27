package mobileapp.objects.ipo;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;


import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;

public class MyBondsSharesMainPage {
    private SelenideElement mainPageHeader = $(AppiumBy.xpath("//android.view.View[@text='My Bonds/Shares']")),
            myBalanceButton = $(AppiumBy.xpath("//android.widget.TextView[@text='My balance']")),
            cashAccountButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Cash account']")),
            offeringsVotingsButton = $(AppiumBy.xpath("//android.widget.Button[@text='Offerings / Votings']")),
            myProfileButton = $(AppiumBy.xpath("//android.view.View[@text='My profile']")),
            ordersButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Orders']")),
            messagesButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Messages']"));
    private SelenideElement navigationPanelHome = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-home-tab']")),
            navigationPanelPortfolio = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-goal-tab']")),
            navigationPanelShop = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-shop-tab']")),
            navigationPanelMessages = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-message-tab']")),
            navigationPanelProfile = $(AppiumBy.xpath("//android.view.View[@resource-id='tab-button-profile-tab']"));

    private SelenideElement myCardsAddNew = $(AppiumBy.xpath("//android.widget.TextView[@text='Register new card']"));

    @Step("Verify that the page is opened correctly")
    public MyBondsSharesMainPage verifyMainPageLoaded() {
        mainPageHeader.shouldHave(exist, Duration.ofSeconds(25)).click();
        myBalanceButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        cashAccountButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        offeringsVotingsButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        myProfileButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        ordersButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        messagesButton.shouldHave(exist, Duration.ofSeconds(25)).click();
        navigationPanelHome.shouldHave(exist, Duration.ofSeconds(25)).click();
        navigationPanelPortfolio.shouldHave(exist, Duration.ofSeconds(25)).click();
        navigationPanelShop.shouldHave(exist, Duration.ofSeconds(25)).click();
        navigationPanelMessages.shouldHave(exist, Duration.ofSeconds(25)).click();
        navigationPanelProfile.shouldHave(exist, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Verify that the 'Add bank card' screen is open")
    public MyBondsSharesMainPage myProfileTap() {
        myProfileButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }

}
