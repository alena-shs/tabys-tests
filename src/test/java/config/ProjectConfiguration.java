package config;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.chrome.ChromeOptions;

public class ProjectConfiguration {
    static DatabaseConnectConfig databaseConnectConfig = ConfigFactory.create(DatabaseConnectConfig.class, System.getProperties());
    public void configure() {
        Configuration.holdBrowserOpen = true;
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--use-fake-ui-for-media-stream");
        chromeOptions.addArguments("--use-fake-device-for-media-stream");
        chromeOptions.addArguments("--use-file-for-fake-video-capture=src/test/resources/images/samplevideo.y4m");
        Configuration.browserCapabilities = chromeOptions;
        }
    }
