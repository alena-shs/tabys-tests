package mobileapp.drivers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.util.List;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.fail;

public class DriverUtils {

    public static void waitForDisplayed(WebElement element, int timeOut) throws InterruptedException {
        for (int second = 0; ; second++)
        {
            if (second >= timeOut)
                fail("timeout");
            try
            {
                if (element.isDisplayed()) break;
            }
            catch (Exception e)
            { }
            sleep(1000);
        }
    }

    public static void waitForEnabled(WebElement element, int timeOut) throws InterruptedException {
        for (int second = 0; ; second++)
        {
            if (second >= timeOut)
                fail("timeout");
            try
            {
                if (element.isEnabled()) break;
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

                // KEY is here - we are "failing" the expected condition
                // if there are less than elementsCount elements
//                if (elements.size() < elementsCount) {
////                    return null;
//                    elements = driver.findElements(locator);
//                    return null;
//                }
//
//                for(WebElement element : elements){
//                    if(!element.isDisplayed()){
//                        return null;
//                    }
//                }

                // If there are less than N elements on the page, we wait for 500 ms and try again
                // This cycle can be repeated 30 times, which gives the page 15 seconds to be loaded
                while ((elements.size() < elementsCount) && (cycleElementCount <= 30)) {
                    try {
                        sleep(500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    elements = driver.findElements(locator);
                    cycleElementCount++;
                }
                // If after 30 tries the element was not located, then we are failing the expected condition
                if (cycleElementCount > 30){
                    return null;
                }

                for(WebElement element : driver.findElements(locator)){
                    if(!element.isDisplayed() && (cycleELementVisibility <= 30)){
                        try {
                            sleep(500);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                        elements = driver.findElements(locator);
                        cycleELementVisibility++;
                        return null;
                    }
                }

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
