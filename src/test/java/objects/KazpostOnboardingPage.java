package objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class KazpostOnboardingPage {
    private final SelenideElement cityField = $("#YH3E0rjKM60YpEWln"),
            addressField = $("#VzDYH9kA60x6y9EcV");
    private final SelenideElement sourceIncomeDropdown = $("p-dropdown[ng-reflect-placeholder='Источник финансирования'] div"),
            soiOptionBusiness = $("li[aria-label='Бизнес']"),
            soiOptionSalary = $("li[aria-label='Зарплата']"),
            soiOptionOther = $("li[aria-label='Иные активы']"),
            soiOptionSavings = $("li[aria-label='Сбережения']"),
            soiOutput = $("[ng-reflect-placeholder='Источник финансирования'] span");
    private final SelenideElement pepDropdown = $("[ng-reflect-placeholder='Являетесь ли Вы ПДЛ?'] span"),
            pepOptionNegative = $("[ng-reflect-label='Нет']"),
            pepOptionPositive = $("[ng-reflect-label='Да']");
    private final ElementsCollection checkboxes = $$(".p-checkbox-box");
    @Step("Fill in the address")
    public KazpostOnboardingPage enterAddress(String city, String address) {
        cityField.setValue(city);
        addressField.setValue(address);
        return this;
    }

    @Step("Fill in the source of income: {inputSourceOfIncome}")
    public KazpostOnboardingPage enterSourceOfIncome(String inputSourceOfIncome) {
        sourceIncomeDropdown.click();
        switch (inputSourceOfIncome) {
            case "Business":
                soiOptionBusiness.click();
                break;
            case "Salary":
                soiOptionSalary.click();
                break;
            case "Other":
                soiOptionOther.click();
                break;
            case "Savings":
                soiOptionSavings.click();
                break;
        }
        return this;
    }

    @Step("Fill in the field PEP: {inputPep}")
    public KazpostOnboardingPage enterPep(boolean inputPep) {
        pepDropdown.click();
        if (!(inputPep)) {
            pepOptionNegative.click();
        } else if (inputPep) {
            pepOptionPositive.click();
        }
        pepOptionNegative.click();
        return this;
    }

    @Step("Check all the checkboxes (I'm not from USA/ I agree to everything")
    public KazpostOnboardingPage checkBoxesAmericanAndAgreement() {
        checkboxes.iterator().forEachRemaining(SelenideElement::click);
        return this;
    };

//    @Step("Check if all the fields are consistent with the input that we provided")
//    public KazpostOnboardingPage verifyFieldsCorrectData() {
//        soiOutput.shouldHave(text());
//        return this;
//    }

}
