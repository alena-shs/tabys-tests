package mobileapp.tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static commons.OnboardingUtils.getNewPhoneNumber;
import static commons.OnboardingUtils.getNumberForLogin;
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
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded()
                .etnRegistrationButtonClick();
        investorSteps
                .verifyOnboardingStepsPage()
                .proceed();
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by on e.
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplateMobile);
        registerNumberPage
                .enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
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
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
//        pinPage.setUpPinFirst(defaultPinCode)
//                .repeatPin(defaultPinCode);
//                // Personal information
//        iinPage
//                .verifyPageLoaded()
//                .setIin(defaultIin)
//                .verifyIinFound();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//                // Income source
//        incomePage
//                .verifyPageLoaded()
//                .setIncomeSource(defaultIncomeSource);
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
//        photoSelfiePage.initiateSelfie();
//        photoModal.verifyPageLoaded();



//        etnIpoOnboarding
//                // Identification of the person (Start identification)
//                .pressOnAvailableButton()
//                // Selfie (selfie tips page)
//                .pressOnAvailableButton()
//                // Selfie (Take a photo - Initiate modal)
//                .pressOnAvailableButton();
//        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
//        ggTokenMobile = sessionIds[0];
//        sessionIdMobile = sessionIds[1];
//        System.out.println("Gg token:" + ggTokenMobile + " / Session ID: " +sessionIdMobile);
//        selfiePage.sendSelfie(ggTokenMobile, sessionIdMobile);
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
                .verifyNavigationAvailable();
        homeTab
                .verifyPageLoaded()
                .ipoBannerClick();
        investorSteps
                .verifyOnboardingStepsPage()
                .proceed();
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by one.
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplateMobile);
        registerNumberPage
                .enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage.enterRegistrationOtpCode(driver, phoneNumber);
        confirmIdentityPage.verifyPageLoaded(driver);
        mobileCommonElements.tapOnAvailableButton(driver);
        mobileCommonElements
                .tapOnAvailableButton(driver)
                .enterEmail(driver)
                .tapOnAvailableButton(driver);
        passwordSetupPage
                .setPasswordNewAccount(driver);
//        mobileCommonElements
//                .tapOnAvailableButton(driver);
//        pinPage
//                .setUpPinFirst(defaultPinCode)
//                .repeatPin(defaultPinCode);
//        // Personal information
//        iinPage
//                .verifyPageLoaded()
//                .setIin(defaultIin)
//                .verifyIinFound();
//        mobileCommonElements
//                .proceedOnboarding(driver);
//        incomePage
//                .verifyPageLoaded()
//                .setIncomeSource(defaultIncomeSource);
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
//        photoSelfiePage.initiateSelfie();
//        photoModal.verifyPageLoaded();



//        etnIpoOnboarding
//                // Identification of the person (Start identification)
//                .pressOnAvailableButton()
//                // Selfie (selfie tips page)
//                .pressOnAvailableButton()
//                // Selfie (Take a photo - Initiate modal)
//                .pressOnAvailableButton();
//        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
//        ggTokenMobile = sessionIds[0];
//        sessionIdMobile = sessionIds[1];
//        System.out.println("Gg token:" + ggTokenMobile + " / Session ID: " +sessionIdMobile);
//        selfiePage.sendSelfie(ggTokenMobile, sessionIdMobile);
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("mobile")
    })
    void etnMobileLogin(){
        startPage
                .clickImAlreadyRegistered(driver);
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by one.
        String phoneNumber = getNumberForLogin(phoneNumberTemplateMobile);
//        System.out.println(phoneNumber.substring(1));
        loginNumberPage.enterPhoneNumber(driver, phoneNumber, defaultPassword)
                .proceed(driver);
        pinPage
                .setUpPinFirst(defaultPinCode)
                .repeatPin(defaultPinCode);
//        mainPage
//                .etnRegistrationButtonClick();
//        investorSteps
//                .verifyOnboardingStepsPage()
//                .proceed();
////        Billie - selfie page
//        etnIpoOnboarding
//                .pressOnAvailableButton()
//                .pressOnAvailableButton()
////                Selfie requirements page
//                .pressOnAvailableButton()
////                Take a selfie button
//                .pressOnAvailableButton();
//        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
//        ggTokenMobile = sessionIds[0];
//        sessionIdMobile = sessionIds[1];
//        System.out.println("Gg token:" + ggTokenMobile + " / Session ID: " +sessionIdMobile);
//        photoPage.sendSelfie(ggTokenMobile, sessionIdMobile);

        // TODO: startCamera?
        // TODO: Why modals are not visible?

    }

}