package mobileapp.tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class Sample {

    @Test
    public static void main(String[] args) throws MalformedURLException, InterruptedException {

        DesiredCapabilities caps = new DesiredCapabilities();
        // Set your access credentials

        caps.setCapability("browserstack.user", "onlyregs_ze2m5b");

        caps.setCapability("browserstack.key", "yzpbFKDE8pgDGnbPQtHW");

        // Set URL of the application under test

        caps.setCapability("app", "bs://c700ce60cf13ae8ed97705a55b8e022f13c5827c");

        // Specify device and os_version for testing

        caps.setCapability("device", "OnePlus OnePlus 9");

        caps.setCapability("os_version", "11.0");

        // Set other BrowserStack capabilities

        caps.setCapability("project", "First Java Project");

        caps.setCapability("build", "browserstack-build-1");

        caps.setCapability("name", "first_test");


        // Initialize the remote Webdriver using BrowserStack remote URL

        // and desired capabilities defined above

        AndroidDriver driver = new AndroidDriver(

                new URL("https://onlyregs_ze2m5b:yzpbFKDE8pgDGnbPQtHW@@hub-cloud.browserstack.com/wd/hub"), caps);

        SelenideElement searchElement = $(AppiumBy.accessibilityId("Search Wikipedia"));
        searchElement.shouldHave(Condition.interactable, Duration.ofSeconds(30)).click();
        SelenideElement insertTextElement = $(AppiumBy.id("org.wikipedia.alpha:id/search_src_text"));
        insertTextElement.shouldHave(Condition.interactable, Duration.ofSeconds(30)).sendKeys("BrowserStack");
        Thread.sleep(1000);
        ElementsCollection allProductsName = $$(AppiumBy.className("android.widget.TextView"));
        assert(allProductsName.size() > 0);

        driver.quit();

    }

}