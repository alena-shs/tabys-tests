package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:kazpost.properties"
})
public interface KazpostConfig extends Config {
    @Key("iin")
    String iin();

    @Key("fullName")
    String fullName();

    @Key("citizenship")
    String citizenship();

    @Key("dateOfBith")
    String dateOfBirth();

    @Key("city")
    String city();

    @Key("address")
    String address();
}
