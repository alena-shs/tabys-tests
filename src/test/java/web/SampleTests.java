package web;

import commons.database.requests.CashCheckNumber;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import web.kazpost.tests.TestBaseWeb;

import java.util.List;

import static com.codeborne.selenide.Selenide.open;
import static commons.OnboardingUtils.getLastUniqueNumber;

public class SampleTests  extends TestBaseWeb {
    @Test
    @Tag("sample")
    public void openGoogleWeb(){
        open("https://google.com/");
        List<String> phoneNumber = CashCheckNumber.allNumbersWithWithdrawalOrders();
        List<String> phoneNumbers2 = CashCheckNumber.allNumbersWithIpoOrders();
        System.out.println(phoneNumber);System.out.println(phoneNumbers2);
    }
}
