package mobileapp.tests;

import com.codeborne.selenide.Selenide;
import commons.OnboardingUtils;
import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static mobileapp.data.MobileTestData.*;

public class MobileUpdateDataTest extends TestBaseMobile {
    @Test
    @Epic("Onboarding")
    @Feature("Data update - mobile")
    @Story("Updating data on IPO")
    @Owner("Alena Shomanova")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test that verifies that a fully onboarded IPO user without any IPO/withdrawal orders can update their data (change income source to 'Savings')")
    @Tags({
            @Tag("mobile"),
            @Tag("updatedata"),
            @Tag("ipo")
    })
    void updateDataIpo() throws InterruptedException {
//        Get a last automatically approved phone number
        String phoneNumber = OnboardingUtils.getIpoNumberWithoutOrders("TABYS_IPO");
        startPage
                .clickImAlreadyRegistered(driver);
        loginNumberPage
                .tapForgotPassword(driver);
        passwordRecoveryPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage
                .enterRestorePasswordOtpCode(driver, phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        homeTab.verifyPageLoaded(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver).ipoBannerClick(driver);
        myBondsSharesMainPage
                .verifyPageLoaded(driver)
                .myProfileTap(driver);
        myProfileInformation
                .verifyPageLoaded(driver)
                .tapUpdateData(driver);
        iinPage
                .verifyPageLoaded(driver)
                .verifyIinFound(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        incomePage
                .verifyPageLoaded(driver)
                .setIncomeSource(driver, "Savings");
        mobileCommonElements
                .proceedOnboarding(driver);
        userConsentPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoSelfieRulePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoSelfiePage
                .verifyPageLoadedUpdate(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIdPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        photoFinishedPage
                .checkOnboardingStuck(driver)
                .verifyPageLoaded(driver)
                .checkOnboardingStuck(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        cardIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardBasePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        videocheckIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        videocheckRulesPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
//        // Give time for videocheck
        Selenide.sleep(5000);
        ipoConsentPage
                .verifyPageLoaded(driver).proceed(driver);
        successPage
                .verifyPageLoaded(driver).exit(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver);
    }

    @Test
    @Epic("Onboarding")
    @Feature("Data update - mobile")
    @Story("Updating data on Tabys")
    @Owner("Alena Shomanova")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test that verifies that a fully onboarded Tabys user without any ETN orders can update their data (change income source to 'Savings')")
    @Tags({
            @Tag("mobile"),
            @Tag("updatedata"),
            @Tag("tabys")
    })
    void updateDataEtn() throws InterruptedException {
//        Get a last automatically approved phone number
        String phoneNumber = OnboardingUtils.getTabysNumber();
        startPage
                .clickImAlreadyRegistered(driver);
        //
        loginNumberPage
                .tapForgotPassword(driver);
        passwordRecoveryPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage
                .enterRestorePasswordOtpCode(driver, phoneNumber);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        //
        mobileCommonElements
                .tapOnAvailableButton(driver);
        //
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        //
        homeTab
                .verifyPageLoaded(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver).clickTabProfile(driver);
        profileTab
//                .verifyPageLoaded()
                .clickPersonalInformation(driver);
        etnPersonalInformation
                .verifyPageLoaded(driver)
                .tapUpdateData(driver);
        //
        iinPage
                .verifyPageLoaded(driver)
                .verifyIinFound(driver);
        mobileCommonElements.proceedOnboarding(driver);
        incomePage
                .verifyPageLoaded(driver)
                .setIncomeSource(driver, "Savings");
        mobileCommonElements
                .proceedOnboarding(driver);
        userConsentPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoSelfieRulePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        //
        photoSelfiePage
                .verifyPageLoadedUpdate(driver);
        //
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIdPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        //
        mobileCommonElements
                .tapOnAvailableButton(driver);
        photoFinishedPage
                .checkOnboardingStuck(driver)
                .verifyPageLoaded(driver)
                .checkOnboardingStuck(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        //
        cardIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        //
        cardBasePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        videocheckIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        videocheckRulesPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
//        // Give time for videocheck
        Selenide.sleep(5000);
        successPage
                .verifyPageLoaded(driver).promoteQueue(driver)
                .verifySharingPageLoaded(driver).exit(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver);
    }


    @Test
    @Epic("Onboarding")
    @Feature("Data update - mobile")
    @Story("Updating data on IPO")
    @Owner("Alena Shomanova")
    @Severity(SeverityLevel.NORMAL)
    @Description("Test that verifies that the specified user can update their IPO data (change income source to 'Savings')")
    @Tag("mobile")
    void updateDataIpoKnownAccount() throws InterruptedException {
//        Get a last automatically approved phone number
        startPage
                .clickImAlreadyRegistered(driver);
        loginNumberPage
                // SPECIFY NUMBER HERE
                .enterCredentials(driver, "+72220000338", defaultPassword);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode);
        homeTab.verifyPageLoaded(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver).ipoBannerClick(driver);
        myBondsSharesMainPage
                .verifyPageLoaded(driver)
                .myProfileTap(driver);
        myProfileInformation
                .verifyPageLoaded(driver)
                .tapUpdateData(driver);
        iinPage
                .verifyPageLoaded(driver)
                .verifyIinFound(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        incomePage
                .verifyPageLoaded(driver)
                .setIncomeSource(driver, "Savings");
        mobileCommonElements
                .proceedOnboarding(driver);
        userConsentPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoSelfieRulePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoSelfiePage
                .verifyPageLoadedUpdate(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIdPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        photoFinishedPage
                .checkOnboardingStuck(driver)
                .verifyPageLoaded(driver)
                .checkOnboardingStuck(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        cardIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardRulePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        cardBasePage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        videocheckIntroPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        videocheckRulesPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
//        // Give time for videocheck
        Selenide.sleep(5000);
        ipoConsentPage
                .verifyPageLoaded(driver).proceed(driver);
        successPage
                .verifyPageLoaded(driver);
        mobileCommonElements.proceedOnboarding(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver);
    }

}
