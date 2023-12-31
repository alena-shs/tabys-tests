package mobileapp.drivers;

import com.codeborne.selenide.WebDriverProvider;
import mobileapp.config.AuthBrowserstackConfig;
import mobileapp.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

import static mobileapp.tests.TestBaseMobile.mobileenv;

public class MobileDriverBrowserstackAndroid implements WebDriverProvider {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class,
            System.getProperties());
    public static AuthBrowserstackConfig authConfig = ConfigFactory.create(AuthBrowserstackConfig.class,
            System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(authConfig.getRemoteUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        MutableCapabilities mutableCapabilities = new MutableCapabilities();
        mutableCapabilities.merge(capabilities);
        String device = config.getDevice();

        // Set your access credentials
        mutableCapabilities.setCapability("browserstack.user", authConfig.getUser());
        mutableCapabilities.setCapability("browserstack.key", authConfig.getKey());
        mutableCapabilities.setCapability("browserstack.enablePasscode", config.getEnablePasscode());

        // Set URL of the application under test
        mutableCapabilities.setCapability("app", config.getApp());

        // Specify device and os_version for testing
        mutableCapabilities.setCapability("device", device);
        mutableCapabilities.setCapability("os_version", config.getOsVersion());
        mutableCapabilities.setCapability("disableAnimations", "true");

        // Set other BrowserStack mutableCapabilities
        mutableCapabilities.setCapability("project", "First Java Project");
        mutableCapabilities.setCapability("build", "browserstack-build-1");
        mutableCapabilities.setCapability("name", "first_test");

        switch (mobileenv) {
            case "browserstack-ios":
                mutableCapabilities.setCapability("autoAcceptAlerts", "true");
                break;
            case "browserstack-android":
                mutableCapabilities.setCapability("autoGrantPermissions", "true");
                break;
        }

        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired mutableCapabilities defined above
        return new RemoteWebDriver(getAppiumServerUrl(), mutableCapabilities);
    }
}