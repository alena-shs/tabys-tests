package web.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/env/${env}.properties"
})

public interface WebConfig extends Config {
    @Key("browser")
    @DefaultValue("chrome")
    String browser();

    @Key("browserVersion")
    @DefaultValue("100.0")
    String browserVersion();

    @Key("browserSize")
    @DefaultValue("1920x1080")
    String browserSize();

    @Key("isRemote")
    boolean isRemote();

    @Key("baseUrl")
    @DefaultValue("https://google.com/")
    String baseUrl();
}