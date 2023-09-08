package mobileapp.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static commons.OnboardingUtils.getLastUniqueNumber;
import static mobileapp.data.MobileTestData.defaultPinCode;

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
        otpPage.enterRestorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        mobileCommonElements
                .tapOnAvailableButton();
        pinPage
                .setUpPinFirst(defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded()
                .etnRegistrationButtonClick();
        onboardingMigrationPage
                .agreeToMigrate();
        // proceed form "Add bank card"
        cardIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardRulePage.verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardBasePage
                .verifyPageLoaded()
                .chooseCnpCard()
                .verifyFeeModalOpened()
                .confirmChooseCnpCard();
        // TODO modal windows don't show up??? and we can't add card manually or with API
        photoModal.verifyPageLoaded();
    }


//    @Test
//    @Tags({
//            @Tag("mobile"),
//            @Tag("tabys"),
//            @Tag("ipo"),
//            @Tag("migration")
//    })
//    void migrationEtnToIpo() {
////        Get a last unique number for the given project
////        Unique - means that it only exists in the given project
//        String phoneNumber = getLastUniqueNumber("TABYS");
//        startPage
//                .clickImAlreadyRegistered();
//        loginNumberPage
//                .tapForgotPassword();
//        passwordRecoveryPage
//                .enterPhoneNumber(phoneNumber)
//                .initiateRegistrationOtp();
//        otpPage
//                .enterResorePasswordOtpCode(phoneNumber);
//        passwordSetupPage
//                .setPasswordNewAccount();
//        etnIpoOnboarding
//                .pressOnAvailableButton();
//        pinPage
//                .setUpPinFirst(defaultPinCode);
//        tabysNavigation
//                .verifyNavigationAvailable();
//        homeTab
//                .verifyPageLoaded()
//                .etnRegistrationButtonClick();
//        onboardingMigrationPage
//                .agreeToMigrate();
//        cardIntroductoryPage.verifyPageLoaded().proceed();
//        nameCardPage.verifyPageLoaded().proceed();
//        cardsBasePage
//                .verifyPageLoaded()
//                .chooseCnpCard()
//                .verifyFeeModalOpened()
//                .confirmChooseCnpCard();
//    }

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
        otpPage.enterRestorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        mobileCommonElements
                .tapOnAvailableButton();
        pinPage
                .setUpPinFirst(defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded()
                .etnRegistrationButtonClick();
        onboardingMigrationPage
                .agreeToMigrate();
        cardIntroPage.verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardRulePage.verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardBasePage
                .verifyPageLoaded()
                .chooseCnpCard()
                .verifyFeeModalOpened()
                .confirmChooseCnpCard();
        photoModal.verifyPageLoaded();
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
        otpPage.enterRestorePasswordOtpCode(phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount();
        mobileCommonElements
                .tapOnAvailableButton();
        pinPage
                .setUpPinFirst(defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded().ipoBannerClick();
        myBondsSharesMainPage
                .verifyPageLoaded()
                .myProfileTap();
        myProfileInformation
                .verifyPageLoaded()
                .selectDocumentsTab();
        myProfileDocuments
                .verifyPageLoaded()
                .myCardsTap();
        myCardsPage
                .verifyPageLoaded()
                .registerNewCardsTap();
        cardIntroPage.verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardRulePage.verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardBasePage
                .verifyPageLoaded()
                .chooseCnpCard()
                .verifyFeeModalOpened()
                .confirmChooseCnpCard();
        photoModal.verifyPageLoaded();
        // TODO: Add card steps
    }
}
