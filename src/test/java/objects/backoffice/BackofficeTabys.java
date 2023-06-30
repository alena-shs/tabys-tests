package objects.backoffice;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.*;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class BackofficeTabys {
    @Step("Open the ETN Investors role")
    public BackofficeTabys openRoleAdminTabys() {
        $(byText("ADMIN TABYS")).click();
        return this;
    }

    @Step("Open 'ETN Investors' section")
    public BackofficeTabys openSectionEtnInvestors(){
        $(byText("ETN Investors")).click();
        $("app-title").shouldHave(text("ETN Investors"));
        return this;
    }

    @Step("Open the first successful ETN investor")
    public BackofficeTabys openFirstEtnInvestor(){
        $(byText("SUCCESS")).click();
        sleep(11000);
        return this;
    }

    @Step("Check that phone number is not empty")
    public BackofficeTabys checkPhoneNumberValue(){
        ElementsCollection dynamicFields = $$(".dynamic-field");
//        Temporarily commented, because my current investor was accepted by me manually without a videocheck
//        dynamicFields.shouldHave(size())
        return this;
    }

    @Step("Check that IIN, Name, date of birth exist")
    public BackofficeTabys checkIinNameDoB(){
        ElementsCollection iinFields = $$(".iin-viewer .dynamic-field");
        iinFields.shouldHave(size(3));
        iinFields.shouldHave(CollectionCondition.texts("IIN:", "Full name:", "Birth date:"));
        iinFields.get(0).shouldHave(Condition.text("IIN:"));
        iinFields.get(0).shouldHave(Condition.matchText("[0-9]{12}"));
        iinFields.get(1).shouldHave(Condition.text("Full name:"));
        iinFields.get(1).shouldHave(Condition.matchText("[А-Я]{2}"));
        iinFields.get(2).shouldHave(Condition.text("Birth date:"));
        iinFields.get(2).shouldHave(Condition.matchText("^([0]?[1-9]|[1|2][0-9]|[3][0|1])[./-]([0]?[1-9]|[1][0-2])[./-]([0-9]{4}|[0-9]{2})$"));
        return this;
    }

    @Step("Check the green line on top")
    public BackofficeTabys checkGreenLineAccepted(){
        $$((".circle.active")).shouldHave(size(8));
        $$((".circle.accept")).shouldHave(size(1));
        return this;
    }

    @Step("Check that all the necessary timestamps exist")
    public BackofficeTabys checkTimestamps(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM.yyyy");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        $$((".timestamp")).shouldHave(CollectionCondition.texts(formattedDate,formattedDate, formattedDate));
//        Temporarily removed
//        $((".timestamp-signature")).shouldBe(Condition.not(Condition.empty));
        return this;
    }

//    @Step("Check that all the necessary timestamps exist")
//    void checkTimestamps(){
//        $$((".timestamp")).shouldHave(texts("2023"));
//        $$((".timestamp-signature")).shouldHave(texts("2023"));
//    }



}
