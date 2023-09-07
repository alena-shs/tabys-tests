package web.kazpost.objects;

import com.codeborne.selenide.SelenideElement;
import commons.CommonUtils;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.value;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.sleep;

public class KazpostOnboardingPersonalDataPage {
    CommonUtils dateUtils = new CommonUtils();
    private final SelenideElement cityField = $("app-onboarding .onboarding").$(byText("Населённый пункт")).sibling(0),
            addressField = $("app-onboarding .onboarding").$(byText("Адрес")).sibling(0);
    private final SelenideElement sourceIncomeDropdown = $("p-dropdown[ng-reflect-placeholder='Источник финансирования'] div"),
            soiOptionArea = $(".p-dropdown-items"),
            soiOutput = $("[ng-reflect-placeholder='Источник финансирования'] div span");
    private final SelenideElement pepDropdown = $("[ng-reflect-placeholder='Являетесь ли Вы ПДЛ?'] span"),
            pepOptionNegative = $("[ng-reflect-label='Нет']"),
            pepOptionPositive = $("[ng-reflect-label='Да']");
    private final SelenideElement noUsaCheckbox = $("app-onboarding .onboarding").$(byText("Не имею признаков принадлежности к США")).parent().preceding(0),
            agreementCheckbox = $("app-onboarding .onboarding div").$(withText("Я подтверждаю, что прочитал, понимаю")).parent().preceding(0);
    private final SelenideElement idNumberField = $("app-onboarding .onboarding").$(byText("Номер документа")).sibling(0);
    private final SelenideElement issueDateCalendarInput = $("app-onboarding .onboarding").$(byText("Дата выдачи")).sibling(0),
            issueDateOutput = $("app-onboarding .onboarding").$(byText("Дата выдачи")).sibling(0).$("input"),
            expirationDateCalendarInput = $("app-onboarding .onboarding").$(byText("Срок действия")).sibling(0),
            expirationDateOutput = $("app-onboarding .onboarding").$(byText("Срок действия")).sibling(0).$("input"),
            calendarYear = $(".p-datepicker-year"),
            calendarPreviousMonth = $(".p-datepicker-prev"),
            calendarNextMonth = $(".p-datepicker-next"),
            calendarDayPickerArea = $(".p-datepicker-calendar");
    private final SelenideElement iinField = $("[placeholder='ИИН']"),
            fullNameField = $("[placeholder='Ваши Ф.И.О. будут заполнены автоматически']"),
            dateOfBirthField = $("[placeholder='Дата рождения будет заполнена автоматически']"),
            citizenshipField = $("app-onboarding .onboarding").$(withText("Гражданство")).sibling(0),
            countryField = $("app-onboarding .onboarding").$(withText("Страна")).sibling(0);
    private final SelenideElement submitButton = $("[ng-reflect-label='Далее']");
    @Step("Fill in the address")
    public KazpostOnboardingPersonalDataPage enterAddress(String city, String address) {
        cityField.setValue(city);
        addressField.setValue(address);
        return this;
    }

    @Step("Fill in the source of income: {inputSourceOfIncome}")
    public KazpostOnboardingPersonalDataPage enterSourceOfIncome(String inputSourceOfIncome) {
        sourceIncomeDropdown.click();
        soiOptionArea.$(byText(inputSourceOfIncome)).click();
        return this;
    }

    @Step("Fill in the field PEP: {inputPep}")
    public KazpostOnboardingPersonalDataPage enterPep(boolean inputPep) {
        pepDropdown.click();
        if (!(inputPep)) {
            pepOptionNegative.click();
        } else { // TODO: input position if it is a pep
            pepOptionPositive.click();
        }
        pepOptionNegative.click();
        return this;
    }

    @Step("Check all the checkboxes (I'm not from USA/ I agree to everything")
    public KazpostOnboardingPersonalDataPage checkBoxesAmericanAndAgreement() {
        noUsaCheckbox.click();
        agreementCheckbox.click();
        return this;
    }

    @Step("Set ID number")
    public KazpostOnboardingPersonalDataPage setIdNumber(String idNumber) {
        idNumberField.setValue(idNumber);
        return this;
    }

    @Step("Set ID issue date: default day {day}, month - previous from current month, default year {year}")
    public KazpostOnboardingPersonalDataPage setIdIssueDate(String day, String year) {
        issueDateCalendarInput.click();
        calendarYear.selectOption(year);
        calendarPreviousMonth.click();
        calendarDayPickerArea.$(byText(day)).click();
        return this;
    }

    @Step("Set ID expiration date: default day {day}, month - previous from current month, default year {year}")
    public void setIdExpirationDate(String day, String year) {
        sleep(2000);
        expirationDateCalendarInput.click();
        calendarYear.selectOption(year);
        calendarNextMonth.click();
        calendarDayPickerArea.$(byText(day)).click();
    }


    @Step("Verify that all the automatically inputted fields contain correct values (IIN, Name, Date of birth, country)")
    public KazpostOnboardingPersonalDataPage verifyIinNameDobCountry(String iin, String fullName, String dateOfBirth, String citizensip) {
        iinField.shouldHave(value(iin));
        fullNameField.shouldHave(value(fullName));
        dateOfBirthField.shouldHave(value(dateOfBirth));
        citizenshipField.shouldHave(value(citizensip));
        countryField.shouldHave(value(citizensip));
        return this;
    }

    @Step("Verify that the inputted address fields have values {city}, {address}")
    public KazpostOnboardingPersonalDataPage verifyInputtedAddress(String city, String address) {
        cityField.shouldHave(value(city));
        addressField.shouldHave(value(address));
        return this;
    }

    @Step("Verify that the inputted source of income is: {inputSourceOfIncome}")
    public KazpostOnboardingPersonalDataPage verifyInputtedSourceOfIncome(String inputSourceOfIncome) {
        soiOutput.shouldHave(text(inputSourceOfIncome));
        return this;
    }

    @Step("Verify that inputted PEP is: {inputPep}")
    public KazpostOnboardingPersonalDataPage verifyInputtedPep(boolean inputPep) {
        if (!(inputPep)) {
            pepDropdown.shouldHave(text("Нет"));
        } else { // TODO: Verify the position of PEP when the feature is added
            pepDropdown.shouldHave(text("Да"));
        }
        return this;
    }

    @Step("Verify inputted document number")
    public KazpostOnboardingPersonalDataPage verifyInputtedIdNo(String idNumber) {
        idNumberField.setValue(idNumber);
        return this;
    }

    @Step("Verify inputted issue date")
    public KazpostOnboardingPersonalDataPage verifyInputtedIssueDate(String day, String month, String year) {
        String issueDate = day + "." + dateUtils.formatMonth(month) + "." + year;
        issueDateOutput.shouldHave(value(issueDate));
        return this;
    }

    @Step("Verify inputted expiration date")
    public KazpostOnboardingPersonalDataPage verifyInputtedExpirationDate(String day, String month, String year) {
        String expirationDate = day + "." + dateUtils.formatMonth(month) + "." + year;
        expirationDateOutput.shouldHave(value(expirationDate));
        return this;
    }

    @Step("Submit data")
    public void pressSubmit() {
        submitButton.click();
        sleep(1000);
    }




}
