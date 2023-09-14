package mobileapp.tests;

import commons.database.config.DatabaseConnectConfig;
import mobileapp.config.AuthBrowserstackConfig;
import mobileapp.config.BrowserstackConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

public class Sample extends TestBaseMobile {
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());

    public static BrowserstackConfig browserstackConfig = ConfigFactory.create(BrowserstackConfig.class,
            System.getProperties());
    public static AuthBrowserstackConfig authBrowserstackConfig = ConfigFactory.create(AuthBrowserstackConfig.class,
            System.getProperties());


    @Tags({
            @Tag("mobile"),
            @Tag("sample_mobile")})
    @Test
    public void sampleTest(){
        System.out.println("Acs test URL: " + databaseConnectConfig.acsTestUrl());
        System.out.println("Onboarding test URL:" + databaseConnectConfig.onboardingTestUrl());
        System.out.println("Cash test URL: " + databaseConnectConfig.cashTestUrl());
        System.out.println("Username: " + databaseConnectConfig.user());
        System.out.println("Password: " + databaseConnectConfig.password());

        System.out.println("Device: " + browserstackConfig.device());
        System.out.println("Platform version:" + browserstackConfig.osVersion());
        System.out.println("Browserstack user: " + authBrowserstackConfig.browserstackUser());
        System.out.println("Browserstack key: " + authBrowserstackConfig.browserstackKey());
        System.out.println("Browserstack user password: " + authBrowserstackConfig.browserstackPassword());
        System.out.println("App key: " + browserstackConfig.app());

        startPage.clickReadyToStart(driver);
        tabysNavigation
                .verifyNavigationAvailable(driver);
//        :sample_mobile --tests "mobileapp.tests.Sample.sampleTest" -Dmobileenv=browserstack-android -Duser=greetgo -Dpassword=z26NPdWj2tFN2S7p -DacsTestUrl=jdbc:postgresql://test-acs-db.caofc8wjrwkc.eu-central-1.rds.amazonaws.com/acs -DonboardingTestUrl=jdbc:postgresql://test-onboarding-db.caofc8wjrwkc.eu-central-1.rds.amazonaws.com/onboarding -DcashTestUrl='jdbc:postgresql://test-cash-db.caofc8wjrwkc.eu-central-1.rds.amazonaws.com/cash' -DbrowserstackUser='alena_Dh1v83' -DbrowserstackKey='fRfkP2sEQxwv6RRd4xWA' -DbrowserstackPassword='Test123' -Ddevice='Samsung Galaxy S22 Ultra' -DosVersion='12.0' -Dapp='bs://0335087e67dc66813d3ce1be7c607f6d729192d0'
//        :sample_mobile --tests "mobileapp.tests.Sample.sampleTest" -Dmobileenv=browserstack-ios -Duser=greetgo -Dpassword=z26NPdWj2tFN2S7p -DacsTestUrl=jdbc:postgresql://test-acs-db.caofc8wjrwkc.eu-central-1.rds.amazonaws.com/acs -DonboardingTestUrl=jdbc:postgresql://test-onboarding-db.caofc8wjrwkc.eu-central-1.rds.amazonaws.com/onboarding -DcashTestUrl='jdbc:postgresql://test-cash-db.caofc8wjrwkc.eu-central-1.rds.amazonaws.com/cash' -DbrowserstackUser='alena_Dh1v83' -DbrowserstackKey='fRfkP2sEQxwv6RRd4xWA' -DbrowserstackPassword='Test123' -Ddevice='iPhone XS' -DosVersion='15' -Dapp='bs://0090dbc41b711889491c90a74296e7f1fed73121'
    }

}