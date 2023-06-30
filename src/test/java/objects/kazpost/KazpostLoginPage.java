package objects.kazpost;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.WebDriverRunner;
import database.AcsDatabaseConnections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class KazpostLoginPage {

    @Step("Open Kazpost main page")
    public KazpostLoginPage openKazpostMainPage() {
        open("https://public-ipo-test.aixkz.com/login?iin=980113450119&wtfItemkey=310131");
        return this;
    }

    @Step("Register with a new number")
    public KazpostLoginPage registerWithNewNumber(String phoneNumber) {
        $(".p-button-label").click();
        $("input[name=telephone_num]").click();
        $("input[name=telephone_num]").setValue(phoneNumber.substring(2));
        $(byText("Зарегистрироваться")).click();
        $(byText("Введите СМС-код, отправленный на номер клиента")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Login to the existing account")
    public KazpostLoginPage loginWithExistingNumber(String phoneNumber) {
        $(".p-button-label").click();
        $("input[name=telephone_num]").click();
        $("input[name=telephone_num]").setValue(phoneNumber.substring(2));
        $(byText("Далее")).click();
        $(byText("Введите СМС-код, отправленный на номер клиента")).shouldBe(Condition.visible);
        return this;
    }

    @Step("Send a confirmation code for Kazpost registration")
    public String[] sendRegistrationKazpostCode(String phoneNumber, String registrationCode){
        $("input[formcontrolname=smsCode]").setValue(registrationCode);
        String ggToken = String.valueOf(WebDriverRunner.getWebDriver().manage().getCookieNamed("Gg_token"));
        $(byText("Отправить")).click();
        String[] sessionIds = AcsDatabaseConnections.KazpostSessionIds(phoneNumber);
        sleep(2000);
//        $(".selected-button").shouldHave(Condition.text(" Персональные данные "));
//        Commented because I am developing the photo sending page
        return sessionIds;
    }
}
