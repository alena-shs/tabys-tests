package mobileapp.objects.commons;

import commons.database.requests.AcsFetchOtp;
import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static commons.database.requests.AcsFetchOtp.userRestorePasswordCode;

public class OtpPage {
    AcsFetchOtp acsDatabaseConnections = new AcsFetchOtp();
    @Step("Enter registration OTP Code")
    public OtpPage enterRegistrationOtpCode(String phoneNumber){

        String registrationCode = acsDatabaseConnections.phoneNumberConfirmationCode(phoneNumber);
        $(AppiumBy.className("android.widget.EditText"))
                .sendKeys(registrationCode);
        return this;
    }

    @Step("Enter password restoring OTP code")
    public OtpPage enterResorePasswordOtpCode(String phoneNumber){

        String restorePasswordOtp = userRestorePasswordCode(phoneNumber);
        $(AppiumBy.className("android.widget.EditText"))
                .sendKeys(restorePasswordOtp);
        return this;
    }
}
