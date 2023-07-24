package mobileapp.config;

import org.aeonbits.owner.Config;

@Config.Sources(
        "classpath:properties/mobile/browserstack-test.properties"
)
public interface BrowserstackConfig extends Config {

    @Key("app")
    @DefaultValue("bs://8fee4233524a635f1d72124f4ad4f6ec6117f765")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("os_version")
    @DefaultValue("9.0")
    String getOsVersion();

    @Key("browserstack.enablePasscode")
    @DefaultValue("true")
    Boolean getEnablePasscode();
}