package mobileapp.helpers;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.SupportsContextSwitching;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.Pause;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.util.Arrays;
import java.util.Set;

import static java.time.Duration.ofMillis;
import static org.openqa.selenium.interactions.PointerInput.Kind.TOUCH;
import static org.openqa.selenium.interactions.PointerInput.MouseButton.LEFT;
import static org.openqa.selenium.interactions.PointerInput.Origin.viewport;

public class MobileUtils {
    private final static PointerInput FINGER = new PointerInput(TOUCH, "finger");

    public static void doSwipe(AppiumDriver driver, Point start, Point end, int duration) {
        Sequence swipe = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), start.getX(), start.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(FINGER.createPointerMove(ofMillis(duration), viewport(), end.getX(), end.getY()))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(swipe));
    }

    public static void tapWithCoordinates(AppiumDriver driver, Point point, int duration) {
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
    }

    public static void tapWithPercentages(AppiumDriver driver, double widthPercentage, double heightPercentage, int duration) {
        Dimension size = driver.manage().window().getSize();
        Point point = new Point((int) (size.width * widthPercentage), (int) (size.height * heightPercentage));
        Sequence tap = new Sequence(FINGER, 1)
                .addAction(FINGER.createPointerMove(ofMillis(0), viewport(), point.getX(), point.getY()))
                .addAction(FINGER.createPointerDown(LEFT.asArg()))
                .addAction(new Pause(FINGER, ofMillis(duration)))
                .addAction(FINGER.createPointerUp(LEFT.asArg()));
        driver.perform(Arrays.asList(tap));
        System.out.println("Tap performed with height:" + point.getY() + " and width:" + point.getX());
    }

    public static void changeDriverContextToWeb(AppiumDriver driver) {
        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("WEBVIEW"))
                ((SupportsContextSwitching) driver).context(contextName);
        }
    }

    public static void changeDriverContextToNative(AppiumDriver driver) {
        Set<String> contextNames = ((SupportsContextSwitching) driver).getContextHandles();
        for (String contextName : contextNames) {
            if (contextName.contains("NATIVE"))
                ((SupportsContextSwitching)  driver).context(contextName);
        }
    }


}
