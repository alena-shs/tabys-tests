package mobileapp.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import commons.api.models.PhotoBody;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import mobileapp.drivers.MobileDriverBrowserstack;
import mobileapp.drivers.MobileDriverLocal;
import commons.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import mobileapp.objects.commons.*;
import mobileapp.objects.ipo.MyBondsSharesMainPage;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.sun.activation.registries.LogSupport.log;

public class TestBaseMobile {
    static DesiredCapabilities cap = new DesiredCapabilities();
    public static String mobileenv = System.getProperty("mobileenv", "emulator");
    public static PhotoBody photoBodyTabys = new PhotoBody();
    MainPage mainPage = new MainPage();
    RegisterNumberPage registerNumberPage = new RegisterNumberPage();
    OtpPage otpPage = new OtpPage();
    PasswordSetupPage passwordSetupPage = new PasswordSetupPage();
    EtnIpoOnboarding etnIpoOnboarding = new EtnIpoOnboarding();
    PhotoPage photoPage = new PhotoPage();
    StartPage startPage = new StartPage();
    LoginNumberPage loginNumberPage = new LoginNumberPage();
    PinPage pinPage = new PinPage();
    PasswordRecoveryPage passwordRecoveryPage = new PasswordRecoveryPage();
    OnboardingMigrationPage onboardingMigrationPage = new OnboardingMigrationPage();
    MyBondsSharesMainPage myBondsSharesMainPage = new MyBondsSharesMainPage();


    @BeforeAll
    public static void setup() {
        switch (mobileenv) {
            case "emulator":
            case "physicaldevice":
                Configuration.browser = MobileDriverLocal.class.getName();
                break;
            case "browserstack":
                Configuration.browser = MobileDriverBrowserstack.class.getName();
                break;
        }
        Configuration.browserSize = null;
        cap.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS,true);
    }

    @BeforeEach
    void addListener() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        open();
//        AndroidDriver mobileDriver = (AndroidDriver) WebDriverRunner.getWebDriver();
//        $(AppiumBy.className("android.widget.TextView")).click();
    }

    @AfterEach
    void afterEach() {
        String sessionId = sessionId().toString();
        Attach.pageSource();

        closeWebDriver();
        switch (mobileenv) {
            case "browserstack":
                Attach.addVideoMobile(sessionId);
                break;
        }
    }

}
