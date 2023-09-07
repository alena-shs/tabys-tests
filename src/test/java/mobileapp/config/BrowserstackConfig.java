package mobileapp.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:properties/env/${mobileenv}.properties"
)
public interface BrowserstackConfig extends Config {

    @Key("app")
    @DefaultValue("bs://8fee4233524a635f1d72124f4ad4f6ec6117f765")
    String getApp();

    @Key("platformName")
    @DefaultValue("android")
    String getPlatformName();

    @Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String getDevice();

    @Key("os_version")
    @DefaultValue("12.0")
    String getOsVersion();

    @Key("browserstack.enablePasscode")
    @DefaultValue("true")
    Boolean getEnablePasscode();
}