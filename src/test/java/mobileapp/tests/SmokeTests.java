package mobileapp.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

@Epic("Smoke tests")
@Feature("Smoke test")
@Owner("Alena Shomanova")
public class SmokeTests extends TestBaseMobile {

    @Test
    @Story("Smoke test without logging in")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test that checks if all the features for unregistered users can be went through without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void smokeTestUnregistered() throws InterruptedException {
        startPage
                .clickReadyToStart(driver);
        homeTab.verifyPageLoaded(driver);
        tabysNavigation.clickTabProfile(driver);
        profileTab.clickPersonalInformation(driver);

    }
}