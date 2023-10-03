package mobileapp.tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static commons.OnboardingUtils.getNewPhoneNumber;
import static mobileapp.data.MobileTestData.*;

public class MobileOnboardingTests extends TestBaseMobile {
    @Test
    @Epic("Onboarding")
    @Feature("Onboarding - mobile")
    @Story("Updating data on Tabys")
    @Owner("Alena Shomanova")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test that verifies that Tabys onboarding with a new number can go without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("onboarding")
    })
    void etnMobileOnboarding() throws InterruptedException {
        //        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by on e.
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplateMobile);
        startPage
                .clickReadyToStart(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
        homeTab
                .verifyPageLoaded(driver)
                .etnRegistrationButtonClick(driver);
        investorSteps
                .verifyOnboardingStepsPage(driver)
                .proceed(driver);
        registerNumberPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage
                .enterRegistrationOtpCode(driver, phoneNumber);
        confirmIdentityPage.verifyPageLoaded(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
        emailPage.verifyPageLoaded(driver)
                .enterEmail(driver, defaultEmail)
                .submitEmail(driver);
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
        photoSelfiePage.verifyPageLoadedNew(driver).initiateSelfie(driver);
        photoModal.verifyPageLoaded(driver);
    }

    @Test
    @Epic("Onboarding")
    @Feature("Onboarding - mobile")
    @Story("Updating data on IPO")
    @Owner("Alena Shomanova")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Test that verifies that IPO onboarding with a new number can go without errors")
    @Tags({
            @Tag("mobile"),
            @Tag("ipo"),
            @Tag("onboarding")
    })
    void ipoMobileOnboarding() throws InterruptedException {
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by one.
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplateMobile);
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
        registerNumberPage
                .enterPhoneNumber(driver, phoneNumber)
                .initiateRegistrationOtp(driver);
        otpPage.enterRegistrationOtpCode(driver, phoneNumber);
        confirmIdentityPage.verifyPageLoaded(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
        emailPage.verifyPageLoaded(driver)
                .enterEmail(driver, defaultEmail)
                .submitEmail(driver);
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
        photoSelfiePage.verifyPageLoadedNew(driver).initiateSelfie(driver);
        photoModal.verifyPageLoaded(driver);
    }

}