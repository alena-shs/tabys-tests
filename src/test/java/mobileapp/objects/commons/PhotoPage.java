package mobileapp.objects.commons;

import commons.api.specs.Specs;
import io.qameta.allure.Step;

import static commons.CommonUtils.preparePhotoBody;
import static commons.helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static mobileapp.data.MobileTestData.*;
import static mobileapp.tests.TestBaseMobile.photoBodyTabys;

public class PhotoPage {
    @Step("Send photo")
    public PhotoPage sendSelfie() {
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
}
