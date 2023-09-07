package mobileapp.objects.ipo;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Selenide.$;

public class MyBondsSharesMainPage {
    private final SelenideElement mainPageHeader = $(AppiumBy.xpath("//*[@text='My Bonds/Shares']")),
            myBalanceButton = $(AppiumBy.xpath("//*[@text='My balance']")),
            cashAccountButton = $(AppiumBy.xpath("//*[@text='Cash account']")),
            offeringsVotingsButton = $(AppiumBy.xpath("//*[@text='Offerings / Votings']")),
            myProfileButton = $(AppiumBy.xpath("//*[@text='My profile']")),
            ordersButton = $(AppiumBy.xpath("//*[@text='Orders']")),
            messagesButton = $(AppiumBy.xpath("//*[@text='Messages']"));

    @Step("Verify that 'My bonds/Shares' page is opened correctly")
    public MyBondsSharesMainPage verifyPageLoaded() {
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
    public void myProfileTap() {
        myProfileButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
    }

}
