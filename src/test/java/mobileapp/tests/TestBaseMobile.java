package mobileapp.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import commons.api.models.PhotoBody;
import commons.helpers.Attach;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.Setting;
import io.appium.java_client.ios.IOSDriver;
import io.qameta.allure.selenide.AllureSelenide;
import mobileapp.drivers.MobileDriverLocal;
import mobileapp.drivers.NewBrowserstackDriver;
import mobileapp.objects.EmailPage;
import mobileapp.objects.commons.*;
import mobileapp.objects.commons.onboarding.InvestorSteps;
import mobileapp.objects.commons.onboarding.*;
import mobileapp.objects.ipo.MyBondsSharesMainPage;
import mobileapp.objects.ipo.MyCardsPage;
import mobileapp.objects.ipo.MyProfileDocuments;
import mobileapp.objects.ipo.MyProfileInformation;
import mobileapp.objects.tabys.EtnPersonalInformation;
import mobileapp.objects.tabys.HomeTab;
import mobileapp.objects.tabys.ProfileTab;
import mobileapp.objects.tabys.TabysNavigation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.SessionId;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static mobileapp.drivers.NewBrowserstackDriver.getAppiumServerUrl;

public class TestBaseMobile {
    public AppiumDriver driver;
    private SessionId sessionId;
    private String sessionIdValue;
    static DesiredCapabilities capabilities = new DesiredCapabilities();
    public static String mobileenv = System.getProperty("mobileenv", "emulator");
    public static PhotoBody photoBodyTabys = new PhotoBody();


    //////////////////////////////////////////////////////////////////
    // GREEN START PAGE AND SPLASH SCREEN
    //////////////////////////////////////////////////////////////////

    StartPage startPage = new StartPage();



    //////////////////////////////////////////////////////////////////
    ////////////////// LOGIN AND REGISTRATION
    //////////////////////////////////////////////////////////////////

    LoginNumberPage loginNumberPage = new LoginNumberPage();

    RegisterNumberPage registerNumberPage = new RegisterNumberPage();
    OtpPage otpPage = new OtpPage();
    EmailPage emailPage = new EmailPage();
    ConfirmIdentityPage confirmIdentityPage = new ConfirmIdentityPage();
    PasswordSetupPage passwordSetupPage = new PasswordSetupPage();

    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();

    PinPage pinPage = new PinPage();



    //////////////////////////////////////////////////////////////////
    ////////////////////// TABYS MAIN PAGE NAVIGATION AND TABS
    //////////////////////////////////////////////////////////////////

    TabysNavigation tabysNavigation = new TabysNavigation();
    HomeTab homeTab = new HomeTab();
    ProfileTab profileTab = new ProfileTab();


    //////////////////////////////////////////////////////////////////
    ////////////////////// ONBOARDING IPO AND ETN
    //////////////////////////////////////////////////////////////////
    InvestorSteps investorSteps = new InvestorSteps();

    IinPage iinPage = new IinPage();
    IncomeSourcePage incomePage = new IncomeSourcePage();
    UserConsentPage userConsentPage = new UserConsentPage();

    PhotoIntroPage photoIntroPage = new PhotoIntroPage();
    PhotoModal photoModal = new PhotoModal();
    PhotoSelfieRulePage photoSelfieRulePage = new PhotoSelfieRulePage();
    PhotoSelfiePage photoSelfiePage = new PhotoSelfiePage();

    PhotoIdPage photoIdPage = new PhotoIdPage();

    PhotoFinishedPage photoFinishedPage = new PhotoFinishedPage();

    CardIntroPage cardIntroPage = new CardIntroPage();
    CardRulePage cardRulePage = new CardRulePage();
    CardBasePage cardBasePage = new CardBasePage();

    VideocheckIntroPage videocheckIntroPage = new VideocheckIntroPage();
    VideocheckRulesPage videocheckRulesPage = new VideocheckRulesPage();

    SuccessPage successPage = new SuccessPage();
    IpoConsentPage ipoConsentPage = new IpoConsentPage();

    MobileCommonElements mobileCommonElements = new MobileCommonElements();



    //////////////////////////////////////////////////////////////////
    ////////////////// IPO MAIN PAGE
    //////////////////////////////////////////////////////////////////
    MyBondsSharesMainPage myBondsSharesMainPage = new MyBondsSharesMainPage();

    //////////////////////////////////////////////////////////////////
    /////////////////////////// IPO PROFILE TAB
    //////////////////////////////////////////////////////////////////

    MyProfileInformation myProfileInformation = new MyProfileInformation();
    MyProfileDocuments myProfileDocuments = new MyProfileDocuments();
    MyCardsPage myCardsPage = new MyCardsPage();


    //////////////////////////////////////////////////////////////////
    //////////////// PAGES OF TABYS PROFILE TAB
    //////////////////////////////////////////////////////////////////

    EtnPersonalInformation etnPersonalInformation = new EtnPersonalInformation();

    @BeforeAll
    public static void setup() {
        switch (mobileenv) {
            case "emulator":
            case "physicaldevice":
                Configuration.browser = MobileDriverLocal.class.getName();
                Configuration.browserSize = null;
                break;
        }
    }


    @BeforeEach
    public void createConnection() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        switch (mobileenv) {
            case "browserstack-android":
                capabilities = new DesiredCapabilities();
                NewBrowserstackDriver.setCapabilities(capabilities);
                System.out.println(getAppiumServerUrl());
                driver = new AppiumDriver(getAppiumServerUrl(), capabilities);
                sessionId = driver.getSessionId();
                System.out.println(sessionId.toString());
                break;
            case "browserstack-ios":
                capabilities = new DesiredCapabilities();
                NewBrowserstackDriver.setCapabilities(capabilities);
                driver = new IOSDriver(getAppiumServerUrl(), capabilities);
                sessionId = driver.getSessionId();

//                changeDriverContextToNative(driver);
//                driver.findElement(AppiumBy.name("Allow")).click();
//                changeDriverContextToWeb(driver);
                break;
            case "emulator":
            case "physicaldevice":
                Selenide.open();
                driver = (AppiumDriver) WebDriverRunner.getWebDriver();
                capabilities.setCapability("autoGrantPermissions", "true");
                sessionId = driver.getSessionId();
//                capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
                break;
        }
        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
    }

//    @BeforeAll
//    public static void setup() throws MalformedURLException {
//        switch (mobileenv) {
//            case "emulator":
//            case "physicaldevice":
//                Configuration.browser = MobileDriverLocal.class.getName();
//                cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
//                break;
//            case "browserstack-ios":
//            case "browserstack-android":
//                Configuration.browser = MobileDriverBrowserstack.class.getName();
//                break;
//        }
//        Configuration.browserSize = null;
////        cap.setCapability(AndroidMobileCapabilityType.DISABLE_WINDOW_ANIMATION, true);
//    }

//    @BeforeEach
//    void addListener() {
//        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
//        open();
//        switch (mobileenv) {
//            case "browserstack-ios":{
//                System.out.println("Attention! iOS tests require a MacBook!");
//            }
//            case "emulator":
//            case "physicaldevice":
//                AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
//                driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
//                break;
//
//        }
////        AppiumDriver driver = (AppiumDriver) WebDriverRunner.getWebDriver();
////        driver.setSetting(Setting.WAIT_FOR_IDLE_TIMEOUT, 0);
////        $(AppiumBy.className("android.widget.TextView")).click();
//
//    }

    @AfterEach
    void afterEach() {
//        String sessionId = sessionId().toString();
//        Attach.pageSource();
//        closeWebDriver();
        switch (mobileenv) {
            case "browserstack-ios":
                driver.quit();
                break;
            case "browserstack-android":
                sessionIdValue = sessionId.toString();
//                String sessionId = driver.getSessionId().toString();
                System.out.println(sessionIdValue);
//                Attach.pageSourceMobile(driver);
                driver.quit();
//                closeWebDriver();
                Attach.addVideoMobile(sessionIdValue);
                break;
            case "physicaldevice":
            case "emulator":
                sessionIdValue = sessionId.toString();
                System.out.println(sessionIdValue);
                Attach.pageSource();
                closeWebDriver();
                break;

        }
    }

}
