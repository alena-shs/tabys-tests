package mobileapp.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static commons.OnboardingUtils.getNewPhoneNumber;
import static mobileapp.data.MobileTestData.*;

public class MobileOnboardingTests extends TestBaseMobile {
    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("onboarding")
    })
    void etnMobileOnboarding(){
        startPage.clickReadyToStart(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver)
                .etnRegistrationButtonClick(driver);
        investorSteps
                .verifyOnboardingStepsPage(driver)
                .proceed(driver);
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by on e.
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplateMobile);
        registerNumberPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage
                .enterRegistrationOtpCode(driver, phoneNumber);
        confirmIdentityPage.verifyPageLoaded(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver)
                .enterEmail(driver)
                .tapOnAvailableButton(driver);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage.setUpPinFirst(driver, defaultPinCode)
                .repeatPin(driver, defaultPinCode);
//                // Personal information
        iinPage
                .verifyPageLoaded(driver)
                .setIin(driver, defaultIin)
                .verifyIinFound(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
                // Income source
        incomePage
                .verifyPageLoaded(driver)
                .setIncomeSource(driver, defaultIncomeSource);
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
        photoSelfiePage.verifyPageLoaded(driver).initiateSelfie(driver);
        photoModal.verifyPageLoaded(driver);
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("ipo"),
            @Tag("onboarding")
    })
    void ipoMobileOnboarding(){
        startPage
                .clickReadyToStart(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver)
                .ipoBannerClick(driver);
        investorSteps
                .verifyOnboardingStepsPage(driver)
                .proceed(driver);
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by one.
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplateMobile);
        registerNumberPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage.enterRegistrationOtpCode(driver, phoneNumber);
        confirmIdentityPage.verifyPageLoaded(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver)
                .enterEmail(driver)
                .tapOnAvailableButton(driver);
        passwordSetupPage
                .setPasswordNewAccount(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver);
        pinPage
                .setUpPinFirst(driver, defaultPinCode)
                .repeatPin(driver, defaultPinCode);
//        // Personal information
        iinPage
                .verifyPageLoaded(driver)
                .setIin(driver, defaultIin)
                .verifyIinFound(driver);
        mobileCommonElements
                .proceedOnboarding(driver);
        incomePage
                .verifyPageLoaded(driver)
                .setIncomeSource(driver, defaultIncomeSource);
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
        photoSelfiePage.verifyPageLoaded(driver).initiateSelfie(driver);
        photoModal.verifyPageLoaded(driver);
    }

}