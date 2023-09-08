package mobileapp.drivers;

import mobileapp.config.AuthBrowserstackConfig;
import mobileapp.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class NewBrowserstackDriver {
    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class,
            System.getProperties());
    public static AuthBrowserstackConfig authConfig = ConfigFactory.create(AuthBrowserstackConfig.class,
            System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return (new URL("http://" + authConfig.getUser() + ":" + authConfig.getKey() + "@" + authConfig.getRemoteUrl() + "/wd/hub"));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    public static DesiredCapabilities setCapabilities(DesiredCapabilities capabilities) {

        capabilities.setCapability("deviceName", browserstackConfig.getDevice());
        capabilities.setCapability("os_version", browserstackConfig.getOsVersion());

        capabilities.setCapability("project", "JUnit Test Project");
        capabilities.setCapability("build", "BrowserStack Build");
        capabilities.setCapability("name", "first_test");
        capabilities.setCapability("browserstack.debug", true);
        String app = browserstackConfig.getApp();
        if (app != null && !app.isEmpty()) {
            capabilities.setCapability("app", app);
        }
        return capabilities;
    }
}
