package web.kazpost.objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import commons.api.models.PhotoBody;
import commons.api.specs.Specs;
import io.qameta.allure.Step;
import web.TestBaseWeb;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static commons.CommonUtils.preparePhotoBody;
import static commons.helpers.CustomAllureListener.withCustomTemplates;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static web.kazpost.data.KazpostData.*;
import static web.kazpost.tests.KazpostTests.photoBody;

public class KazpostOnboardingPhotosPage extends TestBaseWeb {
    private final SelenideElement activeMenuItem = $("[ng-reflect-ng-class='selected-button']");
    private final SelenideElement selfieInstructionText =  $(withText("Пожалуйста, сделайте качественное селфи, для чего необходимо обеспечить хорошее освещение лица на светлом фоне. Убедитесь, что отчетливо видны контуры лица и выражение лица нейтральное. Глаза должны быть открыты и видны, их не должны закрывать волосы или солнцезащитные очки. Перемещайте медленно камеру телефона, приближая и удаляя ее, при этом удерживая изображение лица посередине экрана. Камера зафиксирует лучшее изображение автоматически.")),
            selfieTitleText = $(withText("Фотография")),
            idInstructionText = $(withText("Пожалуйста, сделайте фото удостоверения личности, наведя камеру, чтобы получить зеленую окантовку вокруг изображения. При этом медленно перемещайте камеру, удаляя и приближая ее, пока камера зафиксирует лучшее изображение автоматически.")),
            idTitleText = $(withText("Фото удостоверения личности"));
    private final SelenideElement selfieField = selfieTitleText.parent().sibling(0).$("[src='assets/img/photo.svg']"),
            initiateCameraButton = $("[ng-reflect-label='Сделать снимок']"),
            takePhotoButton = $("]ng-reflect-label='Сделать фото']");
    private final ElementsCollection photoFields = $$("app-dynamic-form img");
    @Step("Verify that the selfie page was opened correctly after submitting data and has content: correct texts and 3 photo fields")
    public KazpostOnboardingPhotosPage verifyPageOpenedCorrectly() {
        activeMenuItem.shouldHave(text("  Фото инвестора и удостоверения "));
        selfieInstructionText.should(exist);
        selfieTitleText.should(exist);
        idInstructionText.should(exist);
        idTitleText.should(exist);
        photoFields.shouldHave(size(3));
        return this;
    }

//    @Step("Send photo")
//    public KazpostOnboardingPhotosPage sendSelfie(String Gg_session, String Session_id) {
//        selfieField.click();
//        initiateCameraButton.click();
//        step("Prepare a body for a selfie sending", () -> {
//            PhotoBody photoBody = new PhotoBody();
//            preparePhotoBody(photoBody, selfieDocType, selfieDefaultEncoded, selfieTitle);
//        });
//
//        step("Send a POST request to save selfie", () ->
//                given()
//                        .filter(withCustomTemplates())
//                        .spec(Specs.kazpostRequestSpec)
//                        .body(photoBody)
//                        .when()
//                        .post("/onboarding/file/save")
//                        .then()
//                        .spec(Specs.successResponseSpec));
//        return this;
//    }
}
