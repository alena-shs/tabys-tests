package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${stand}-database.properties"
})
public interface DatabaseConnectConfig extends Config {
    @Key("acsAddress")
    String acsAddress();

    @Key("user")
    String user();

    @Key("password")
    String password();
}
