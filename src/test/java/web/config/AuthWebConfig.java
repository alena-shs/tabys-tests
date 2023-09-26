package web.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/auth/web-auth.properties"
})

public interface AuthWebConfig extends Config {
    @Key("loginSelenoid")
    String loginSelenoid();

    @Key("passwordSelenoid")
    String passwordSelenoid();

    @Key("remoteUrl")
    String remoteUrl();
}
