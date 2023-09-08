package commons.database.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/test-database.properties"
})
public interface DatabaseConnectConfig extends Config {
    @Key("acsTestUrl")
    String acsTestUrl();

    @Key("onboardingTestUrl")
    String onboardingTestUrl();

    @Key("cashTestUrl")
    String cashTestUrl();

    @Key("user")
    String user();

    @Key("password")
    String password();
}
