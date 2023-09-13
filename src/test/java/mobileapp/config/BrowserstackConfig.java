package mobileapp.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/env/${mobileenv}.properties"
})
public interface BrowserstackConfig extends Config {

//    @Config.Key("app")
    @DefaultValue("bs://8fee4233524a635f1d72124f4ad4f6ec6117f765")
    String app();


//    @Config.Key("device")
    @DefaultValue("Samsung Galaxy S22 Ultra")
    String device();

//    @Config.Key("os_version")
    @DefaultValue("12.0")
    String osVersion();
}