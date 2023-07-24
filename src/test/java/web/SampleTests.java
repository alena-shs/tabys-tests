package web;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static commons.OnboardingUtils.getLastUniqueNumber;

public class SampleTests  extends TestBaseWeb {
    @Test
    @Tag("sample")
    public void openGoogleWeb(){
        open("https://google.com/");
        String phoneNumber = getLastUniqueNumber("TABYS_IPO");
        System.out.println(phoneNumber);
    }
}
