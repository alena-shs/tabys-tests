package tests;

import database.AcsDatabaseConnections;
import objects.KazpostLoginPage;
import objects.KazpostOnboardingPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static testdata.KazpostData.*;

@Tags({
        @Tag("kazpost"),
        @Tag("onboarding-migration")})
public class KazpostTests extends TestBase{
    KazpostLoginPage kazpostLoginPage = new KazpostLoginPage();
    KazpostOnboardingPage kazpostOnboardingPage = new KazpostOnboardingPage();
    static AcsDatabaseConnections acsDatabase = new AcsDatabaseConnections();
    public static String phoneNumber = "+72220000912";

    @Test
    @DisplayName("Onboarding for Kazpost with a new number")
    void onboardingKazpost() {
        kazpostLoginPage.openKazpostMainPage()
                .registerWithNewNumber(phoneNumber);
        String registrationCode = acsDatabase.PhoneNumberConfirmationCode(phoneNumber);
        System.out.println(registrationCode);
        kazpostLoginPage.sendRegistrationKazpostCode(registrationCode);
        kazpostOnboardingPage.enterAddress(city, address)
                .enterSourceOfIncome(sourceOfIncome)
                .enterPep(isPep);
    }
}
