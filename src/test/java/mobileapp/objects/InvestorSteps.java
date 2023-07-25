package mobileapp.objects;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class InvestorSteps {
    //TODO Investor steps for Tabys and IPO
    @Step("Enter in both emails")
    public InvestorSteps  checkTitle() {
        SelenideElement header = $(AppiumBy.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.webkit.WebView/android.webkit.WebView/android.view.View/android.view.View/android.view.View/android.view.View/android.view.View[2]/android.view.View[2]/android.view.View[1]"));
        header.shouldHave(text("Your investor status"));
        return this;
    }
}
