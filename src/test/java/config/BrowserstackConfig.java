package config;

import org.aeonbits.owner.Config;

public interface BrowserstackConfig extends Config {

    @Key("app")
    @DefaultValue("bs://2639a30a5c17da69c2c04908fe323bddba368d6b")
    String getApp();

    @Key("device")
    @DefaultValue("Google Pixel 3")
    String getDevice();

    @Key("os_version")
    @DefaultValue("9.0")
    String getOsVersion();
}