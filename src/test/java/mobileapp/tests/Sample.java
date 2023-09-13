package mobileapp.tests;

import commons.database.config.DatabaseConnectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class Sample extends TestBaseMobile {
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

        System.out.println("Device: " + databaseConnectConfig.acsTestUrl());
        System.out.println("Platform version:" + databaseConnectConfig.onboardingTestUrl());
        System.out.println("Browserstack user: " + databaseConnectConfig.cashTestUrl());
        System.out.println("Browserstack key: " + databaseConnectConfig.user());

        startPage.clickReadyToStart(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
    }

}