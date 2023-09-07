//package mobileapp.drivers;
//
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.options.UiAutomator2Options;
//import mobileapp.config.AuthBrowserstackConfig;
//import mobileapp.config.BrowserstackConfig;
//import org.aeonbits.owner.ConfigFactory;
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//
//public class BrowserstackAndroidDriver {
//    public AndroidDriver driver;
//    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class,
//            System.getProperties());
//    public static AuthBrowserstackConfig authConfig = ConfigFactory.create(AuthBrowserstackConfig.class,
//            System.getProperties());
//
//    public static URL getAppiumServerUrl() {
//        try {
//            return new URL(authConfig.getRemoteUrl());
//        } catch (MalformedURLException e) {
//            throw new RuntimeException(e);
//        }
//    }
//
//    public void setUp() throws Exception {
//        MutableCapabilities mutableCapabilities = new UiAutomator2Options();
//
//        mutableCapabilities.merge(capabilities);
//        String device = config.getDevice();
//
//        // Set your access credentials
//        capabilities.setCapability("browserstack.user", authConfig.getUser());
//        capabilities.setCapability("browserstack.key", authConfig.getKey());
//        capabilities.setCapability("browserstack.enablePasscode", config.getEnablePasscode());
//
//        // Set URL of the application under test
//        capabilities.setCapability("app", config.getApp());
//
//        // Specify device and os_version for testing
//        capabilities.setCapability("device", device);
//        capabilities.setCapability("os_version", config.getOsVersion());
//        capabilities.setCapability("disableAnimations", "true");
//
//        // Set other BrowserStack mutableCapabilities
//        capabilities.setCapability("project", "First Java Project");
//        capabilities.setCapability("build", "browserstack-build-1");
//        capabilities.setCapability("name", "first_test");
//
////        if (device.startsWith("iPhone")) {
////            mutableCapabilities.setCapability("nativeWebTap", "true");
////        } else {
////            System.out.println("It's an Android");
////        }
//
//        // Initialise the remote Webdriver using BrowserStack remote URL
//        // and desired mutableCapabilities defined above
//        return new RemoteWebDriver(getAppiumServerUrl(), mutableCapabilities);
//        driver = new AndroidDriver(new URL(new URL("https://" + authConfig.getUser() + ":" + authConfig.getKey() +"@hub-cloud.browserstack.com/wd/hub"), caps);
//    }
//}
