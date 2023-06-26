package objects;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.*;

public class BackofficeCommon {
    @Step("Log in with credentials role")
    public void backofficeLogin(){
        open("https://backoffice-test.aixkz.com/login");
        $("[formcontrolname='login']").setValue("a.shomanova");
        $("[formcontrolname='password']").setValue("Weare1331!");
        $("[label='Log in']").click();
        $("[placeholder='Enter Code']").setValue("999");
        $("[label='Confirm']").click();
    }
}
