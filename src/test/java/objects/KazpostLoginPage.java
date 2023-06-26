package objects;

import com.codeborne.selenide.Condition;
import database.AcsDatabaseConnections;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class KazpostLoginPage {
    static AcsDatabaseConnections acsDatabase = new AcsDatabaseConnections();

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

    @Step("Send a confirmation code for Kazpost registration")
    public void sendRegistrationKazpostCode(String registrationCode){
        $("input[formcontrolname=smsCode]").setValue(registrationCode);
        $(byText("Отправить")).click();
        sleep(2000);
        $(".selected-button").shouldHave(Condition.text(" Персональные данные "));
    }
}
