package web.drivers;

import com.codeborne.selenide.Configuration;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.remote.DesiredCapabilities;
import web.config.AuthWebConfig;
import web.config.WebConfig;

import java.util.Map;

public class ProjectConfiguration {
    static WebConfig webConfig = ConfigFactory.create(WebConfig.class, System.getProperties());
    static AuthWebConfig authconfig = ConfigFactory.create(AuthWebConfig.class, System.getProperties());

    public void configure() {
        Configuration.baseUrl = webConfig.baseUrl();
        Configuration.browser = webConfig.browser();
        Configuration.browserVersion = webConfig.browserVersion();
        Configuration.browserSize = webConfig.browserSize();
        String remoteUrl = "https://" + authconfig.loginSelenoid() + ":" + authconfig.passwordSelenoid() + "@" + authconfig.remoteUrl() + "/wd/hub";
        System.out.println(remoteUrl);
        if (webConfig.isRemote()) {
            Configuration.remote = remoteUrl;
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                    "enableVNC", true,
                    "enableVideo", true
            ));
            Configuration.browserCapabilities = capabilities;
        }
    }
}
