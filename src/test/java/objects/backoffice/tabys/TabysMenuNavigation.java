package objects.backoffice.tabys;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class TabysMenuNavigation {
    public static SelenideElement roleTabysButton = $(byText("ADMIN TABYS"));
    public static SelenideElement menuItemEtnInvestors = $(byText("ETN Investors"));
    public static SelenideElement pageTitle = $("app-title");
    @Step("Open the ETN Investors role")
    public TabysMenuNavigation openRoleAdminTabys() {
        roleTabysButton.click();
        return this;
    }

    @Step("Open 'ETN Investors' section")
    public TabysMenuNavigation openSectionEtnInvestors(){
        menuItemEtnInvestors.click();
        pageTitle.shouldHave(text("ETN Investors"));
        return this;
    }
}
