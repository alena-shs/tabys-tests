package objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.$;

public class BackofficeIPO {
    @Step("Login into ADMIN IPO role")
    void backofficeLoginIPO(){
        open("https://backoffice-test.aixkz.com/login");
        $("input[formcontrolname='login']").setValue("a.shomanova");
        $("input[formcontrolname='password']").setValue("Weare1331!");
        $("p-button[label='Log in']").click();
        $("input[placeholder='Enter Code']").setValue("999");
        $("p-button[label='Confirm']").click();
        $(byText("ADMIN IPO")).click();
    }



}
