package mobileapp.tests;

import com.codeborne.selenide.Selenide;
import commons.OnboardingUtils;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static mobileapp.data.MobileTestData.*;

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
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        photoIdPage
                .verifyPageLoaded(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        photoFinishedPage
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
                .verifyPageLoaded(driver);
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
//        // TODO Debug this
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


}
