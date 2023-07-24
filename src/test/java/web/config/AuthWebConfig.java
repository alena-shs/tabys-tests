package web.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/auth/web-auth.properties"
})

public interface AuthWebConfig extends Config {
    @Key("login")
    String login();

    @Key("password")
    String password();

    @Key("remoteUrl")
    String remoteUrl();
}
