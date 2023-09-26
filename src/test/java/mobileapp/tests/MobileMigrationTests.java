package mobileapp.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static commons.OnboardingUtils.getLastUniqueNumber;
import static mobileapp.data.MobileTestData.*;

@Epic("Onboarding")
@Feature("Onboarding wih data migration - mobile")
@Owner("Alena Shomanova")
public class MobileMigrationTests extends TestBaseMobile{

    @Test
    @Story("Onboarding with data migration from IPO to Tabys(ETN)")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test that verifies that data migration from IPO to Tabys(ETN) can go without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationIpoToEtn() throws InterruptedException {
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
        onboardingMigrationPage
                .verifyMigrationPageLoaded(driver)
                .agreeOpenAccount(driver);
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
    @Story("Onboarding with data migration from Tabys(ETN) to IPO")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test that verifies that data migration from Tabys(ETN) to IPO can go without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationEtnToIpo() throws InterruptedException {
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
    @Story("Onboarding with data migration from Kazpost to Tabys(ETN)")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test that verifies that data migration from Kazpost to Tabys(ETN) can go without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("migration")
    })
    void migrationKazpostToEtn() throws InterruptedException {
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
    @Story("Onboarding with data migration from Kazpost to IPO")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test that verifies that data migration from Kazpost to IPO can go without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("ipo"),
            @Tag("migration")
    })
    void migrationKazpostToIpo() throws InterruptedException {
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
