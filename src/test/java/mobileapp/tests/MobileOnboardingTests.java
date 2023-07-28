package mobileapp.tests;

import com.codeborne.selenide.WebDriverRunner;
import commons.database.requests.AcsFetchOtp;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.NoAlertPresentException;

import static com.codeborne.selenide.Selenide.sleep;
import static commons.OnboardingUtils.*;
import static mobileapp.data.MobileTestData.*;

public class MobileOnboardingTests extends TestBaseMobile {
    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("mobile")
    })
    void etnMobileOnboarding(){
        AndroidDriver mobileDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        startPage.clickReadyToStart();
            mainPage.etnRegistrationButtonClick()
                    .proceedFromInvestorSteps();
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by on e.
        String phoneNumber = getNewPhoneNumber("+74440");
        registerNumberPage.enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage.enterRegistrationOtpCode(phoneNumber);
        etnIpoOnboarding
                .pressOnAvailableButton()
                .enterEmail()
                .pressOnAvailableButton();
        passwordSetupPage.setPasswordNewAccount();
        etnIpoOnboarding.pressOnAvailableButton();
        pinPage.setUpPin("1111")
                .setUpPin("1111");
                // Personal information
        etnIpoOnboarding.setIin("010111500830")
                .pressOnAvailableButton()
                // Income source
                .setIncomeSource("Salary")
                // User Consent
                .pressOnAvailableButton()
                // Identification of the person (Start identification)
                .pressOnAvailableButton()
                // Selfie (selfie tips page)
                .pressOnAvailableButton()
                // Selfie (Take a photo - Initiate modal)
                .pressOnAvailableButton();
        try {
            mobileDriver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e) {
            System.out.println("iOS alert is not present" + e.getMessage());
        }
        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
        ggTokenMobile = sessionIds[0];
        sessionIdMobile = sessionIds[1];
        System.out.println("Gg token:" + ggTokenMobile + " / Session ID: " +sessionIdMobile);
        photoPage.sendSelfie(ggTokenMobile, sessionIdMobile);
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("ipo"),
            @Tag("mobile")
    })
    void ipoMobileOnboarding(){
        AndroidDriver mobileDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
        startPage.clickReadyToStart();
        mainPage.ipoBannerClick()
                .proceedFromInvestorSteps();
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by one.
        String phoneNumber = getNewPhoneNumber("+74440");
        System.out.println(phoneNumber);
        registerNumberPage.enterPhoneNumber(phoneNumber)
                .initiateRegistrationOtp();
        otpPage.enterRegistrationOtpCode(phoneNumber);
        etnIpoOnboarding
                .pressOnAvailableButton()
                .enterEmail()
                .pressOnAvailableButton();
        passwordSetupPage.setPasswordNewAccount();
        etnIpoOnboarding.pressOnAvailableButton();
        pinPage.setUpPin("1111")
                .setUpPin("1111");
        // Personal information
        etnIpoOnboarding.setIin("010111500830")
                .pressOnAvailableButton()
                // Income source
                .setIncomeSource("Salary")
                // User Consent
                .pressOnAvailableButton()
                // Identification of the person (Start identification)
                .pressOnAvailableButton()
                // Selfie (selfie tips page)
                .pressOnAvailableButton()
                // Selfie (Take a photo - Initiate modal)
                .pressOnAvailableButton();
        try {
            mobileDriver.switchTo().alert().accept();
        }
        catch (NoAlertPresentException e) {
            System.out.println("iOS alert is not present" + e.getMessage());
        }
        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
        ggTokenMobile = sessionIds[0];
        sessionIdMobile = sessionIds[1];
        System.out.println("Gg token:" + ggTokenMobile + " / Session ID: " +sessionIdMobile);
        photoPage.sendSelfie(ggTokenMobile, sessionIdMobile);
    }

    @Test
    @Tags({
            @Tag("mobile"),
            @Tag("tabys"),
            @Tag("mobile")
    })
    void etnMobileLogin(){
        startPage.clickImAlreadyRegistered();
//        Get a new phone number for registration. All the numbers will be in the format: +74440xxxxxx. Each new number will increment the previous number by one.
        String phoneNumber = getNumberForLogin(phoneNumberTemplateMobile);
        System.out.println(phoneNumber.substring(1));
        loginNumberPage.enterPhoneNumber(phoneNumber, defaultPassword)
                .proceed();
        pinPage.setUpPin("1111");
        mainPage.etnRegistrationButtonClick()
                .proceedFromInvestorSteps();
//        Billie - selfie page
        etnIpoOnboarding.pressOnAvailableButton()
                .pressOnAvailableButton()
//                Selfie requirements page
                .pressOnAvailableButton()
//                Take a selfie button
                .pressOnAvailableButton();
        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
        ggTokenMobile = sessionIds[0];
        sessionIdMobile = sessionIds[1];
        System.out.println("Gg token:" + ggTokenMobile + " / Session ID: " +sessionIdMobile);
        photoPage.sendSelfie(ggTokenMobile, sessionIdMobile);

        // TODO: startCamera?
        // TODO: Why modals are not visible?

    }

}