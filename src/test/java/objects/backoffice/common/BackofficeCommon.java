package objects.backoffice.common;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static testdata.BackofficeData.*;

public class BackofficeCommon {
    public static SelenideElement loginInputField = $("[formcontrolname='login']"),
            passwordInputField = $("[formcontrolname='password']"),
            loginButton = $("[label='Log in']"),
            otpCodeInputField = $("[placeholder='Enter Code']"),
            confirmButton = $("[label='Confirm']");
    @Step("Log in with credentials")
    public void backofficeLogin(){
        open("https://backoffice-test.aixkz.com/login");
        loginInputField.setValue(login);
        passwordInputField.setValue(password);
        loginButton.click();
        otpCodeInputField.setValue(defaultOtp);
        confirmButton.click();
    }
}
