package mobileapp.config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:properties/auth/browserstack-auth.properties"
})
public interface AuthBrowserstackConfig extends Config {
    @Key("browserstack.user")
    String getUser();

    @Key("browserstack.key")
    String getKey();

    @Key("password")
    String getPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}