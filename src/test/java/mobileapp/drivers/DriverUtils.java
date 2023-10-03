package mobileapp.drivers;

import com.codeborne.selenide.WebDriverRunner;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

import static com.codeborne.selenide.Selenide.sleep;
import static org.junit.jupiter.api.Assertions.fail;

public class DriverUtils {

    public static void waitForDisplayed(AppiumDriver driver, By locator, int timeOut) throws InterruptedException {
        for (int second = 0; ; second++)
        {
            if (second >= timeOut)
                fail("Element display timeout");
            try
            {
                if (driver.findElement(locator).isDisplayed())
                    break;
            }
            catch (Exception e)
            { }
            sleep(1000);
        }
    }

    public static void waitForEnabled(AppiumDriver driver, By locator, int timeOut) throws InterruptedException {
        for (int second = 0; ; second++)
        {
            if (second >= timeOut)
                fail("Element enabled timeout");
            try
            {
                if (driver.findElement(locator).isEnabled()) break;
            }
            catch (Exception e)
            { }
            sleep(1000);
        }
    }

    public static ExpectedCondition<List<WebElement>> visibilityOfNElementsLocatedBy(
            final By locator, final int elementsCount) {
        return new ExpectedCondition<List<WebElement>>() {
            @Override
            public List<WebElement> apply(WebDriver driver) {
                List<WebElement> elements = driver.findElements(locator);
                int cycleElementCount = 0;
                int cycleELementVisibility = 0;
                int elementNumber = 0;

                // If there are less than N elements on the page, we wait for 500 ms and try again
                // This cycle can be repeated 30 times, which gives the page 15 seconds to be loaded
                while ((elements.size() != elementsCount) && (cycleElementCount <= 30)) {
                    sleep(500);
                    elements = driver.findElements(locator);
                    cycleElementCount++;
                }
                // If after 30 tries the element was not located, then we are failing the expected condition
                if (cycleElementCount > 30){
                    return null;
                }

                while (elementNumber < elementsCount) {
//                    driver.findElements(locator).get(elementNumber);
                    if(!driver.findElements(locator).get(elementNumber).isDisplayed() && (cycleELementVisibility <= 30)){
                        sleep(500);
                        driver.findElements(locator);
                        cycleELementVisibility++;
                        return null;
                    }
                    elementNumber++;
                }

//                for(WebElement element : driver.findElements(locator)){
//                    if(!element.isDisplayed() && (cycleELementVisibility <= 30)){
//                        sleep(500);
//                        elements = driver.findElements(locator);
//                        cycleELementVisibility++;
//                        return null;
//                    }
//                }

                // if the elements are not displayed in 30 tries, we are failing the expected condition
                if (cycleELementVisibility > 30){
                    return null;
                }
                return elements;
            }

            @Override
            public String toString() {
                return "visibility of N elements located by " + locator;
            }
        };
    }
}
