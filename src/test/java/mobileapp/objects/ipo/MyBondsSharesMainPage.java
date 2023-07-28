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
            myProfileButton = $(AppiumBy.xpath("//android.widget.TextView[@text='My profile']")),
            ordersButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Orders']")),
            messagesButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Messages']"));


    private SelenideElement myCardsAddNew = $(AppiumBy.xpath("//android.widget.TextView[@text='Register new card']"));

    @Step("Verify that 'My bonds/Shares' page is opened correctly")
    public MyBondsSharesMainPage verifyMainPageLoaded() {
        mainPageHeader.shouldHave(exist, Duration.ofSeconds(25));
        myBalanceButton.shouldHave(exist, Duration.ofSeconds(25));
        cashAccountButton.shouldHave(exist, Duration.ofSeconds(25));
        offeringsVotingsButton.shouldHave(exist, Duration.ofSeconds(25));
        myProfileButton.shouldHave(exist, Duration.ofSeconds(25));
        ordersButton.shouldHave(exist, Duration.ofSeconds(25));
        messagesButton.shouldHave(exist, Duration.ofSeconds(25));
        return this;
    }

    @Step("Go to 'My profile' section")
    public MyBondsSharesMainPage myProfileTap() {
        myProfileButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }

}
