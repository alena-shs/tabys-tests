package mobileapp.config;

import org.aeonbits.owner.Config;

@Config.Sources(
//        "classpath:properties/${mobileenv}.properties"
        "classpath:properties/mobile/emulator.properties"
)

public interface LocalDeviceConfig extends Config {
    @Config.Key("deviceName")
    @Config.DefaultValue("Pixel 4 API 30")
    String getDeviceName();

    @Config.Key("platformVersion")
    @Config.DefaultValue("11.0")
    String getPlatformVersion();

    @Config.Key("appPackage")
    @Config.DefaultValue("kz.tabys.test")
    String getAppPackage();

    @Config.Key("appActivity")
    @Config.DefaultValue("kz.tabys.test.MainActivity")
    String getAppActivity();

    @Config.Key("serverUrl")
    @Config.DefaultValue("http://localhost:4723/wd/hub")
    String getServerUrl();

    @Config.Key("appPath")
    String getAppPath();
}
