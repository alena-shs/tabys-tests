package mobileapp.objects.ipo;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class MyCardsPage {
    private final SelenideElement title = $(AppiumBy.xpath("//android.view.View[@text='My cards']")) ;
    private final SelenideElement registerNewCardButton = $(AppiumBy.xpath("//android.widget.TextView[@text='Register new card']"));

    @Step("Verify that 'My profile' page is opened correctly")
    public MyCardsPage verifyPageLoaded() {
        title.shouldHave(visible, Duration.ofSeconds(25));
        registerNewCardButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

    @Step("Choose to Register new card")
    public void registerNewCardsTap() {
        registerNewCardButton.click();
        registerNewCardButton.click();
        registerNewCardButton.click();
    }
}

