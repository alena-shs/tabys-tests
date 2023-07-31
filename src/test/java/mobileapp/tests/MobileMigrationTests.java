package mobileapp.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.sleep;
import static commons.OnboardingUtils.getLastUniqueNumber;

public class MobileMigrationTests extends TestBaseMobile{

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationIpotToEtn() {
//        Get a last unique number for the given project
//        Unique - means that it only exists in the given project
        String phoneNumber = getLastUniqueNumber("TABYS_IPO");
        startPage
                .clickImAlreadyRegistered();
        loginNumberPage
                .tapForgotPassword();
        passwordRecoveryPage
                .enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage
                .enterResorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        etnIpoOnboarding
                .pressOnAvailableButton();
        pinPage
                .setUpPin("1111");
        mainPage
                .etnRegistrationButtonClick();
        onboardingMigrationPage
                .agreeToMigrate();
        // proceed form "Add bank card"
        etnIpoOnboarding
                .verifyAddBankCardScreen()
                .pressOnAvailableButton()
                // proceed from "name card"
                .pressOnAvailableButton()
                .chooseCnpCard();
        // TODO modal windows don't show up??? and we can't add card manually or with API
    }


    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationEtnToIpo() {
//        Get a last unique number for the given project
//        Unique - means that it only exists in the given project
        String phoneNumber = getLastUniqueNumber("TABYS");
        startPage
                .clickImAlreadyRegistered();
        loginNumberPage
                .tapForgotPassword();
        passwordRecoveryPage
                .enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage
                .enterResorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        etnIpoOnboarding
                .pressOnAvailableButton();
        pinPage
                .setUpPin("1111");
        mainPage.ipoBannerClick();
        onboardingMigrationPage
                .agreeToMigrate();
        etnIpoOnboarding
                .verifyAddBankCardScreen()
                .pressOnAvailableButton()
                // proceed from "name card"
                .pressOnAvailableButton()
                .chooseCnpCard();
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("migration")
    })
    void migrationKazpostToEtn() {
//        Get a last unique number for the given project
//        Unique - means that it only exists in the given project
        String phoneNumber = getLastUniqueNumber("KAZPOST");
        startPage
                .clickImAlreadyRegistered();
        loginNumberPage
                .tapForgotPassword();
        passwordRecoveryPage
                .enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage
                .enterResorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        etnIpoOnboarding
                .pressOnAvailableButton();
        pinPage
                .setUpPin("1111");
        mainPage
                .etnRegistrationButtonClick();
//        onboardingMigrationPage.agreeToMigrate();
        onboardingMigrationPage
                .agreeToMigrate();
        // proceed form "Add bank card"
        etnIpoOnboarding
                .verifyAddBankCardScreen()
                .pressOnAvailableButton()
                // proceed from "name card"
                .pressOnAvailableButton()
                .chooseCnpCard();
        sleep(100000);
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationKazpostToIpo() {
//        Get a last unique number for the given project
//        Unique - means that it only exists in the given project
        String phoneNumber = getLastUniqueNumber("KAZPOST");
        startPage
                .clickImAlreadyRegistered();
        loginNumberPage
                .tapForgotPassword();
        passwordRecoveryPage
                .enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage
                .enterResorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        etnIpoOnboarding
                .pressOnAvailableButton();
        pinPage
                .setUpPin("1111");
        mainPage.verifyMainPage()
                .ipoBannerClick();
        myBondsSharesMainPage
                .verifyMainPageLoaded()
                .myProfileTap();
        myProfileInformation
                .verifyInformationPageLoaded()
                .selectDocumentsTab();
        myProfileDocuments
                .profileDocumentsTabLoaded()
                .myCardsTap();
        myCardsPage
                .profileDocumentsTabLoaded()
                .registerNewCardsTap();
        etnIpoOnboarding
                .verifyAddBankCardScreen()
                .pressOnAvailableButton()
                // proceed from "name card"
                .pressOnAvailableButton()
                .chooseCnpCard();
        // TODO: Add a card steps

        sleep(100000);
    }
}
