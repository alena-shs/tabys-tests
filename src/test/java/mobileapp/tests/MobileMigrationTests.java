package mobileapp.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static commons.OnboardingUtils.getLastUniqueNumber;
import static mobileapp.data.MobileTestData.*;

public class MobileMigrationTests extends TestBaseMobile{

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationIpoToEtn() {
//        Get a last unique number for the given project
//        Unique - means that it only exists in the given project
        String phoneNumber = getLastUniqueNumber("TABYS_IPO");
        startPage
                .clickImAlreadyRegistered(driver);
        loginNumberPage
                .tapForgotPassword(driver);
        passwordRecoveryPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage.enterRestorePasswordOtpCode(driver, phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver)
                .etnRegistrationButtonClick(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
//        // proceed form "Add bank card"
        cardIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage.verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardBasePage
                .verifyPageLoaded(driver)
                .chooseCnpCard(driver)
                .verifyFeeModalOpened(driver)
                .confirmChooseCnpCard(driver);
//        // TODO modal windows don't show up??? and we can't add card manually or with API
        photoModal.verifyPageLoaded(driver);
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
                .clickImAlreadyRegistered(driver);
        loginNumberPage
                .tapForgotPassword(driver);
        passwordRecoveryPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage.enterRestorePasswordOtpCode(driver, phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver)
                .ipoBannerClick(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
        cardIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage.verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardBasePage
                .verifyPageLoaded(driver)
                .chooseCnpCard(driver)
                .verifyFeeModalOpened(driver)
                .confirmChooseCnpCard(driver);
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
                .clickImAlreadyRegistered(driver);
        loginNumberPage
                .tapForgotPassword(driver);
        passwordRecoveryPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage.enterRestorePasswordOtpCode(driver, phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver)
                .etnRegistrationButtonClick(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
        cardIntroPage.verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage.verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardBasePage
                .verifyPageLoaded(driver)
                .chooseCnpCard(driver)
                .verifyFeeModalOpened(driver)
                .confirmChooseCnpCard(driver);
        photoModal.verifyPageLoaded(driver);
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
                .clickImAlreadyRegistered(driver);
        loginNumberPage
                .tapForgotPassword(driver);
        passwordRecoveryPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage.enterRestorePasswordOtpCode(driver, phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver).ipoBannerClick(driver);
        myBondsSharesMainPage
                .verifyPageLoaded(driver)
                .myProfileTap(driver);
        myProfileInformation
                .verifyPageLoaded(driver)
                .selectDocumentsTab(driver);
        myProfileDocuments
                .verifyPageLoaded(driver)
                .myCardsTap(driver);
        myCardsPage
                .verifyPageLoaded(driver)
                .registerNewCardsTap(driver);
        cardIntroPage.verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage.verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardBasePage
                .verifyPageLoaded(driver)
                .chooseCnpCard(driver)
                .verifyFeeModalOpened(driver)
                .confirmChooseCnpCard(driver);
        photoModal.verifyPageLoaded(driver);
//        // TODO: Add card steps
    }
}
