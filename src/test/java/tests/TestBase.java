package tests;

import api.models.PhotoBody;
import api.utils.BodyConstructors;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import io.qameta.allure.selenide.AllureSelenide;
import objects.backoffice.common.BackofficeCommon;
import objects.backoffice.tabys.InvestorPersonalPage;
import objects.backoffice.tabys.TabysMenuNavigation;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase
{
    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();
    public static BodyConstructors bodyConstructors = new BodyConstructors();
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
}
