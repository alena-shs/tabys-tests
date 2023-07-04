package objects.backoffice.tabys;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import io.qameta.allure.Step;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class InvestorPersonalPage {
    public static ElementsCollection allTimestamps = $$((".timestamp")),
            iinRelatedFields = $$(".iin-viewer .dynamic-field");
    @Step("Open the first successful ETN investor")
    public InvestorPersonalPage openFirstEtnInvestor(){
        $(byText("SUCCESS")).click();
        sleep(11000);
        return this;
    }

//    @Step("Check that phone number is not empty")
//    public InvestorPersonalPage checkPhoneNumberValue(){
//        ElementsCollection dynamicFields = $$(".dynamic-field");
////        Temporarily commented, because my current investor was accepted by me manually without a videocheck
////        dynamicFields.shouldHave(size(2))
//        return this;
//    }

    @Step("Check that IIN, Name, date of birth exist")
    public InvestorPersonalPage checkIinNameDoB(){
        iinRelatedFields.shouldHave(size(3));
        iinRelatedFields.shouldHave(CollectionCondition.texts("IIN:", "Full name:", "Birth date:"));
        iinRelatedFields.get(0).shouldHave(Condition.text("IIN:"));
        iinRelatedFields.get(0).shouldHave(Condition.matchText("[0-9]{12}"));
        iinRelatedFields.get(1).shouldHave(Condition.text("Full name:"));
        iinRelatedFields.get(1).shouldHave(Condition.matchText("[А-Я]{2}"));
        iinRelatedFields.get(2).shouldHave(Condition.text("Birth date:"));
//        iinRelatedFields.get(2).shouldHave(Condition.matchText("^Birth date: (0[1-9]|[12][0-9]|3[01])\\.(0[1-9]|1[0-2])\\.[0-9]{4}$"));
        return this;
    }

    @Step("Check the green line on top for an ACCEPTED investor")
    public InvestorPersonalPage checkGreenLineAccepted(){
        $$((".circle.active")).shouldHave(size(8));
        $$((".circle.accept")).shouldHave(size(1));
        return this;
    }

    @Step("Check that all the necessary timestamps exist")
    public InvestorPersonalPage checkTimestamps(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime now = LocalDateTime.now();
        String formattedDate = dtf.format(now);
        allTimestamps.shouldHave(CollectionCondition.texts(formattedDate, formattedDate, formattedDate));
        $((".timestamp-signature")).shouldBe(Condition.not(Condition.empty));
        return this;
    }

//    @Step("Check that all the necessary timestamps exist")
//    void checkTimestamps(){
//        $$((".timestamp")).shouldHave(texts("2023"));
//        $$((".timestamp-signature")).shouldHave(texts("2023"));
//    }

}
