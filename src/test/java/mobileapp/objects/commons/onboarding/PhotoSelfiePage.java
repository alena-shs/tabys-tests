package mobileapp.objects.commons.onboarding;

import com.codeborne.selenide.SelenideElement;
import commons.api.specs.Specs;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import java.time.Duration;

import static com.codeborne.selenide.Condition.interactable;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static commons.CommonUtils.preparePhotoBody;
import static commons.helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static mobileapp.data.MobileTestData.*;
import static mobileapp.tests.TestBaseMobile.photoBodyTabys;

public class PhotoSelfiePage {
    private SelenideElement
            addSelfieButton = $(AppiumBy.xpath("//android.widget.Button[@text='Add selfie']")),
            photoField = $(AppiumBy.xpath("//android.view.View[@resource-id='photo-clickable']")),
            nextButton = $(AppiumBy.xpath("//android.widget.Button[@text='Continue']"));

    @Step("Verify that the selfie page is fully loaded and has all the necessary elements")
    public PhotoSelfiePage verifyPageLoaded() {
        addSelfieButton.shouldHave(visible, Duration.ofSeconds(25));
        photoField.shouldHave(visible, Duration.ofSeconds(25));
        nextButton.shouldHave(visible, Duration.ofSeconds(25));
        return this;
    }

    @Step("Submit and go to the next page")
    public PhotoSelfiePage initiateSelfie() {
        addSelfieButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
        return this;
    }

    @Step("Send photo")
    public PhotoSelfiePage sendSelfie(String Gg_session, String Session_id) {
        step("Prepare a body for a selfie sending", () -> {
            preparePhotoBody(photoBodyTabys, selfieDocType, selfieDefaultEncoded, selfieTitle);
        });

        System.out.println(photoBodyTabys);

        step("Send a POST request to save selfie", () ->
                given()
                        .filter(withCustomTemplates())
                        .spec(Specs.tabysRequestSpec)
                        .body(photoBodyTabys)
                        .when()
                        .post("/onboarding/file/save")
                        .then()
                        .spec(Specs.successResponseSpec));
        return this;
    }

//    @Step("Submit the selfie page and go to the next page")
//    public void proceed() {
//        nextButton.shouldHave(interactable, Duration.ofSeconds(25)).click();
//    }
}
