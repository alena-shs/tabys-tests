package mobileapp.objects.commons.onboarding;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

import static mobileapp.tests.TestBaseMobile.mobileenv;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PhotoSelfiePage {
    private final static Logger logger = LoggerFactory.getLogger(PhotoSelfiePage.class);

    @Step("Verify that the selfie page is fully loaded and has all the necessary elements (for a new onboarding)")
    public PhotoSelfiePage verifyPageLoadedNew(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> addSelfieButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[@text='Add selfie']")));
            assertEquals(1, addSelfieButton.size());
            assertTrue(addSelfieButton.get(0).isEnabled());

            List<WebElement> photoField = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.view.View[@resource-id='photo-clickable']")));
            assertEquals(1, photoField.size());
        }
        return this;
    }

    @Step("Verify that the selfie page is fully loaded and has all the necessary elements")
    public PhotoSelfiePage verifyPageLoadedUpdate(AppiumDriver driver) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            List<WebElement> addSelfieButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[@text='Add selfie']")));
            assertEquals(1, addSelfieButton.size());
            assertTrue(addSelfieButton.get(0).isEnabled());

            List<WebElement> photoField = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.view.View[@resource-id='photo-clickable']")));
            assertEquals(1, photoField.size());

            List<WebElement> nextButton = wait.until
                    (ExpectedConditions.visibilityOfAllElementsLocatedBy(
                            AppiumBy.xpath("//android.widget.Button[@text='Continue']")));
            assertEquals(1, nextButton.size());
            assertTrue(nextButton.get(0).isEnabled());
        }
        return this;
    }

    @Step("Submit and go to the next page")
    public void initiateSelfie(AppiumDriver driver) {

        if (Objects.equals(mobileenv, "browserstack-ios")){
            logger.info("MACBOOK REQUIRED TO WRITE THE SCRIPT");
        } else {
            driver.findElement(AppiumBy.xpath("//android.widget.Button[@text='Add selfie']")).click();
        }
    }


//    An attempt to send photo via API. Returns 200, but useless in the test. Not deleting this chunk of code as you can use it for reference.

//    @Step("Send photo")
//    public PhotoSelfiePage sendSelfie(String Gg_session, String Session_id) {
//        step("Prepare a body for a selfie sending", () -> {
//            preparePhotoBody(photoBodyTabys, selfieDocType, selfieDefaultEncoded, selfieTitle);
//        });
//
//        System.out.println(photoBodyTabys);
//
//        step("Send a POST request to save selfie", () ->
//                given()
//                        .filter(withCustomTemplates())
//                        .spec(Specs.tabysRequestSpec)
//                        .body(photoBodyTabys)
//                        .when()
//                        .post("/onboarding/file/save")
//                        .then()
//                        .spec(Specs.successResponseSpec));
//        return this;
//    }
}
