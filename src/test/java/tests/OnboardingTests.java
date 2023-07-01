package tests;

import objects.backoffice.tabys.TabysMenuNavigation;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static testdata.KazpostData.*;

@Tags({
        @Tag("backoffice "),
        @Tag("onboarding-migration")})
public class OnboardingTests extends TestBase {
    @Test
    void acceptedEtnInvestorsCorrectView(){
        open("https://backoffice-test.aixkz.com/login");
        backofficeCommon.backofficeLogin();
        tabysMenuNavigation
                .openRoleAdminTabys()
                .openSectionEtnInvestors();
        investorPersonalPage.openFirstEtnInvestor()
                .checkTimestamps()
                .checkIinNameDoB();
    }
}
