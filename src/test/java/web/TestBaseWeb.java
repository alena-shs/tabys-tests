package web;

import com.codeborne.selenide.logevents.SelenideLogger;
import web.config.ProjectConfiguration;
import commons.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import web.backoffice.objects.common.BackofficeCommon;
import web.backoffice.objects.tabys.InvestorPersonalPage;
import web.backoffice.objects.tabys.TabysMenuNavigation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBaseWeb
{
    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();
//    public static BodyConstructors bodyConstructors = new BodyConstructors();
    BackofficeCommon backofficeCommon = new BackofficeCommon();
    TabysMenuNavigation tabysMenuNavigation = new TabysMenuNavigation();
    InvestorPersonalPage investorPersonalPage = new InvestorPersonalPage();


    @BeforeAll
    static void beforeAll() {
        projectConfiguration.configure();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }

}
