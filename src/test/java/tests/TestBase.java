package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import objects.backoffice.common.BackofficeCommon;
import objects.backoffice.tabys.InvestorPersonalPage;
import objects.backoffice.tabys.TabysMenuNavigation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase
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
