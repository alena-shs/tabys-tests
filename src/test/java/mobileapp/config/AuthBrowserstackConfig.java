package mobileapp.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:properties/auth/browserstack-auth.properties"
})
public interface AuthBrowserstackConfig extends Config {
//    @Key("browserstack.user")
    String browserstackUser();

//    @Key("browserstack.key")
    String browserstackKey();

//    @Key("userPassword")
    String browserstackPassword();

    @Key("remoteUrl")
    String getRemoteUrl();
}