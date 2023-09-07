package mobileapp.tests;

import com.codeborne.selenide.Selenide;
import commons.OnboardingUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static mobileapp.data.MobileTestData.defaultPinCode;

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
                .tapUpdateData();
        iinPage
                .verifyPageLoaded()
                .verifyIinFound();
        mobileCommonElements
                .proceedOnboarding();
        incomePage
                .verifyPageLoaded()
                .setIncomeSource("Savings");
        mobileCommonElements
                .proceedOnboarding();
        userConsentPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoSelfieRulePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoSelfiePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoIdPage
                .verifyPageLoadedNewOnboarding();
        mobileCommonElements
                .proceedOnboarding();
        mobileCommonElements
                .tapOnAvailableButton();
        photoFinishedPage
                .verifyPageLoaded()
                .checkOnboardingStuck();
        mobileCommonElements
                .tapOnAvailableButton();
        cardIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardRulePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardBasePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        videocheckIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        videocheckRulesPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        // Give time for videocheck
        Selenide.sleep(5000);
        ipoConsentPage
                .verifyPageLoaded().proceed();
        successPage
                .verifyPageLoaded();
        mobileCommonElements.proceedOnboarding();
        tabysNavigation
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded();
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
        mobileCommonElements
                .tapOnAvailableButton();
        pinPage
                .setUpPinFirst(defaultPinCode);
        homeTab
                .verifyPageLoaded();
        tabysNavigation
                .verifyNavigationAvailable().clickTabProfile();
        profileTab
//                .verifyPageLoaded()
                .clickPersonalInformation();
        etnPersonalInformation
                .verifyPageLoaded()
                .tapUpdateData();
        iinPage
                .verifyPageLoaded()
                .verifyIinFound();
        mobileCommonElements.proceedOnboarding();
        incomePage
                .verifyPageLoaded()
                .setIncomeSource("Savings");
        mobileCommonElements
                .proceedOnboarding();
        userConsentPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoSelfieRulePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoSelfiePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        photoIdPage
                .verifyPageLoadedNewOnboarding();
        mobileCommonElements
                .proceedOnboarding();
        mobileCommonElements
                .tapOnAvailableButton();
        photoFinishedPage
                .verifyPageLoaded()
                .checkOnboardingStuck();
        mobileCommonElements
                .tapOnAvailableButton();
        cardIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardRulePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        cardBasePage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        videocheckIntroPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        // TODO Debug this
        videocheckRulesPage
                .verifyPageLoaded();
        mobileCommonElements
                .proceedOnboarding();
        // Give time for videocheck
        Selenide.sleep(5000);
        successPage
                .verifyPageLoaded().promoteQueue()
                .verifySharingPageLoaded().exit();
        tabysNavigation
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded();
    }


}
