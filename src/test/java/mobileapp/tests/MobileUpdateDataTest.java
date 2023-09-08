package mobileapp.tests;

import commons.OnboardingUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class MobileUpdateDataTest extends TestBaseMobile {
    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("updatedata"),
            @Tag("ipo")
    })
    void updateDataIpo() {
//        Get a last automatically approved phone number
        String phoneNumber = OnboardingUtils.getCsdNumberWithoutOrders("TABYS_IPO");
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
//        pinPage
//                .setUpPinFirst(defaultPinCode);
//        tabysNavigation
//                .verifyNavigationAvailable();
//        homeTab
//                .verifyPageLoaded().ipoBannerClick();
//        myBondsSharesMainPage
//                .verifyPageLoaded()
//                .myProfileTap();
//        myProfileInformation
//                .verifyPageLoaded()
//                .tapUpdateData();
//        iinPage
//                .verifyPageLoaded()
//                .verifyIinFound();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        incomePage
//                .verifyPageLoaded()
//                .setIncomeSource("Savings");
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        userConsentPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoIntroPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoSelfieRulePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoSelfiePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoIdPage
//                .verifyPageLoadedNewOnboarding();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
//        photoFinishedPage
//                .verifyPageLoaded()
//                .checkOnboardingStuck();
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
//        cardIntroPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        cardRulePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        cardBasePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        videocheckIntroPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        videocheckRulesPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        // Give time for videocheck
//        Selenide.sleep(5000);
//        ipoConsentPage
//                .verifyPageLoaded().proceed();
//        successPage
//                .verifyPageLoaded();
//        mobileCommonElements.proceedOnboarding(driver);
//        tabysNavigation
//                .verifyNavigationAvailable();
//        homeTab
//                .verifyPageLoaded();
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("updatedata"),
            @Tag("tabys")
    })
    void updateDataEtn() {
//        Get a last automatically approved phone number
        String phoneNumber = OnboardingUtils.getTabysNumber();
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
//        pinPage
//                .setUpPinFirst(defaultPinCode);
//        homeTab
//                .verifyPageLoaded();
//        tabysNavigation
//                .verifyNavigationAvailable().clickTabProfile();
//        profileTab
////                .verifyPageLoaded()
//                .clickPersonalInformation();
//        etnPersonalInformation
//                .verifyPageLoaded()
//                .tapUpdateData();
//        iinPage
//                .verifyPageLoaded()
//                .verifyIinFound();
//        mobileCommonElements.proceedOnboarding(driver);
//        incomePage
//                .verifyPageLoaded()
//                .setIncomeSource("Savings");
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        userConsentPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoIntroPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoSelfieRulePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoSelfiePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        photoIdPage
//                .verifyPageLoadedNewOnboarding();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
//        photoFinishedPage
//                .verifyPageLoaded()
//                .checkOnboardingStuck();
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
//        cardIntroPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        cardRulePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        cardBasePage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        videocheckIntroPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        // TODO Debug this
//        videocheckRulesPage
//                .verifyPageLoaded();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        // Give time for videocheck
//        Selenide.sleep(5000);
//        successPage
//                .verifyPageLoaded().promoteQueue()
//                .verifySharingPageLoaded().exit();
//        tabysNavigation
//                .verifyNavigationAvailable();
//        homeTab
//                .verifyPageLoaded();
    }


}
