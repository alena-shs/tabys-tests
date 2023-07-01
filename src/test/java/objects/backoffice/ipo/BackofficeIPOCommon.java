package objects.backoffice.ipo;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class BackofficeIPOCommon {
    public static SelenideElement roleIpoButton = $(byText("ADMIN IPO"));
    @Step("Login into ADMIN IPO role")
    void backofficeLoginIPO(){
        roleIpoButton.click();
    }
}
