package web;

import com.codeborne.selenide.Selenide;
import commons.database.config.DatabaseConnectConfig;
import io.qameta.allure.*;
import mobileapp.config.AuthBrowserstackConfig;
import mobileapp.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.config.AuthWebConfig;
import web.config.WebConfig;
import web.kazpost.tests.TestBaseWeb;

public class SampleTests  extends TestBaseWeb {
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());

    public static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    public static AuthWebConfig authWebConfig = ConfigFactory.create(AuthWebConfig.class, System.getProperties());
    @Test
    @Epic("Sample CI tests")
    @Feature("Sample CI tests - mobile")
    @Story("Checking if CI is working")
    @Owner("Alena Shomanova")
    @Severity(SeverityLevel.BLOCKER)
    @Description("Test that verifies that this CI is working")
    @Tag("sample")
    public void openGoogleWeb(){
        System.out.println("Acs test URL: " + databaseConnectConfig.acsTestUrl());
        System.out.println("Onboarding test URL:" + databaseConnectConfig.onboardingTestUrl());
        System.out.println("Cash test URL: " + databaseConnectConfig.cashTestUrl());
        System.out.println("Username: " + databaseConnectConfig.user());
        System.out.println("Password: " + databaseConnectConfig.password());

        System.out.println("Selenoid login: " + authWebConfig.loginSelenoid());
        System.out.println("Selenoid password:" + authWebConfig.passwordSelenoid());
        System.out.println("Selenoid URL:" + authWebConfig.remoteUrl());
        System.out.println("Browser: " + webConfig.browser());
        System.out.println("Browser version: " + webConfig.browserVersion());
        System.out.println("Browser size:  " + webConfig.browserSize());
        System.out.println("Base URL: " + webConfig.baseUrl());

        System.out.println("https://" + authWebConfig.loginSelenoid() + ":" + authWebConfig.passwordSelenoid() + "@" + authWebConfig.remoteUrl() + "/wd/hub");
        Selenide.open();
    }
}
