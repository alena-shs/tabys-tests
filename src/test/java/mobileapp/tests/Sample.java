package mobileapp.tests;

import commons.database.config.DatabaseConnectConfig;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.Test;

public class Sample {
    public static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class,
            System.getProperties());

    @Test
    public void main(){
        System.out.println(databaseConnectConfig.cashTestUrl()+ ", "+databaseConnectConfig.user()+ ", "+databaseConnectConfig.password());

    }

}