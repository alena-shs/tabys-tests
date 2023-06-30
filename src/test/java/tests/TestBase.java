package tests;

import api.models.PhotoBody;
import com.codeborne.selenide.logevents.SelenideLogger;
import config.ProjectConfiguration;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

public class TestBase
{
    static ProjectConfiguration projectConfiguration = new ProjectConfiguration();

    @BeforeAll
    static void beforeAll() {
        projectConfiguration.configure();
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
    }
}
