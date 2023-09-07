package mobileapp.drivers;

import com.codeborne.selenide.WebDriverProvider;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import mobileapp.config.LocalDeviceConfig;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static io.appium.java_client.remote.AutomationName.ANDROID_UIAUTOMATOR2;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class MobileDriverLocal implements WebDriverProvider {
    public static LocalDeviceConfig config = ConfigFactory.create(LocalDeviceConfig.class,
            System.getProperties());

    public static URL getAppiumServerUrl() {
        try {
            return new URL(config.getServerUrl());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(Capabilities capabilities) {
        UiAutomator2Options options = new UiAutomator2Options();
        options.merge(capabilities);

        options.setAutomationName(ANDROID_UIAUTOMATOR2)
                .setPlatformName(ANDROID)
                .setDeviceName(config.getDeviceName())
                .setPlatformVersion(config.getPlatformVersion())
                .setApp(getAppPath())
                .setAppPackage(config.getAppPackage())
                .setAppActivity(config.getAppActivity());

        return new AndroidDriver(getAppiumServerUrl(), options);
    }

    private String getAppPath() {
        String appPath = config.getAppPath();
        File app = new File(appPath);
        return app.getAbsolutePath();
    }
}
