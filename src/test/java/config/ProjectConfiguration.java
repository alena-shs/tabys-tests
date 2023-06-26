package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;

public class ProjectConfiguration {
    static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class, System.getProperties());
    static KazpostConfig kazpostConfig = ConfigFactory.create(KazpostConfig.class, System.getProperties());
    public void configure() {
        }
    }
