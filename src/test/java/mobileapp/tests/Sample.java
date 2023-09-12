package mobileapp.tests;

import commons.database.config.DatabaseConnectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

public class Sample extends TestBaseMobile {
    private final static Logger logger = LoggerFactory.getLogger(Sample.class);
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());

    @Tag("mobile")
    @Test
    public void sampleTest(){
        System.out.println("Acs test URL: " + databaseConnectConfig.acsTestUrl());
        System.out.println("Onboarding test URL:" + databaseConnectConfig.onboardingTestUrl());
        System.out.println("Cash test URL: " + databaseConnectConfig.cashTestUrl());
        System.out.println("Username: " + databaseConnectConfig.user());
        System.out.println("Password: " + databaseConnectConfig.password());

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            startPage.clickReadyToStart();
            tabysNavigation
                    .verifyNavigationAvailable();
        }
    }

}