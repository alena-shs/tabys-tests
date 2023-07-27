package web.kazpost.tests;

import commons.api.models.PhotoBody;
import commons.database.requests.AcsFetchOtp;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import web.kazpost.objects.KazpostLoginPage;
import web.kazpost.objects.KazpostOnboardingPersonalDataPage;
import web.kazpost.objects.KazpostOnboardingPhotosPage;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;

import static commons.OnboardingUtils.getNewPhoneNumber;
import static web.kazpost.data.KazpostData.*;

@Tags({
        @Tag("kazpost"),
        @Tag("web")
})
public class KazpostTests extends TestBaseWeb {
    KazpostLoginPage kazpostLoginPage = new KazpostLoginPage();
    public static PhotoBody photoBody = new PhotoBody();
    KazpostOnboardingPersonalDataPage kazpostOnboardingPersonalDataPage = new KazpostOnboardingPersonalDataPage();
    KazpostOnboardingPhotosPage kazpostOnboardingPhotosPage = new KazpostOnboardingPhotosPage();
    static AcsFetchOtp acsDatabase = new AcsFetchOtp();


    @Test
    @DisplayName("Onboarding for Kazpost with a new number")
    void onboardingKazpost() {
        String phoneNumber = getNewPhoneNumber(phoneNumberTemplate);
        kazpostLoginPage.openKazpostMainPage()
                .registerWithNewNumber(phoneNumber);
        String registrationCode = acsDatabase.phoneNumberConfirmationCode(phoneNumber);
        System.out.println(registrationCode);
        kazpostLoginPage.sendRegistrationKazpostCode(phoneNumber, registrationCode);
        kazpostOnboardingPersonalDataPage.enterAddress(city, address)
                .enterSourceOfIncome(sourceOfIncome)
                .enterPep(isPep)
                .checkBoxesAmericanAndAgreement()
                .setIdNumber(defaultIdNum)
                .setIdIssueDate(defaultIssueDay, defaultIssueYear)  // month == current month + 1 by default
                .setIdExpirationDate(defaultExpirationDay, defaultExpirationYear);     // month == current month + 1 by default
        kazpostOnboardingPersonalDataPage.verifyIinNameDobCountry(iin, firstName + " " + lastName, dateOfBirth, citizenship)
                .verifyInputtedAddress(city, address)
                .verifyInputtedSourceOfIncome(sourceOfIncome)
                .verifyInputtedPep(isPep).verifyInputtedIdNo(defaultIdNum)
                .verifyInputtedIssueDate(defaultIssueDay, defaultIssueMonth, defaultIssueYear)
                .verifyInputtedExpirationDate(defaultExpirationDay, defaultExpirationMonth, defaultExpirationYear)
                .pressSubmit();
//        System.out.println(sessionIds[0] + " " + sessionIds[1]);
        String[] sessionIds = AcsFetchOtp.userSessionIds(phoneNumber);
        kazpostOnboardingPhotosPage.verifyPageOpenedCorrectly()
                .sendSelfie(sessionIds[0], sessionIds[1])
        ;
    }

//    @Test
//    @DisplayName("Enter data into an existing KazPost account")
//    void onboardingKazpost() {
//        kazpostLoginPage.openKazpostMainPage()
//                .loginWithExistingNumber(phoneNumber);
//        String registrationCode = acsDatabase.KazpostLoginCode(phoneNumber);
//        System.out.println(registrationCode);
//        sessionIds = kazpostLoginPage.sendRegistrationKazpostCode(phoneNumber, registrationCode);
//        kazpostOnboardingPersonalDataPage.enterAddress(city, address)
//                .enterSourceOfIncome(sourceOfIncome)
//                .enterPep(isPep)
//                .checkBoxesAmericanAndAgreement()
//                .setIdNumber(defaultIdNum)
//                .setIdIssueDate(defaultIssueDay, defaultIssueYear)  // month == current month + 1 by default
//                .setIdExpirationDate(defaultExpirationDay, defaultExpirationYear);     // month == current month + 1 by default
//        kazpostOnboardingPersonalDataPage.verifyIinNameDobCountry(iin, firstName + " "+ , dateOfBirth, citizenship)
//                .verifyInputtedAddress(city, address)
//                .verifyInputtedSourceOfIncome(sourceOfIncome)
//                .verifyInputtedPep(isPep).verifyInputtedIdNo(defaultIdNum)
//                .verifyInputtedIssueDate(defaultIssueDay, defaultIssueMonth, defaultIssueYear)
//                .verifyInputtedExpirationDate(defaultExpirationDay, defaultExpirationMonth, defaultExpirationYear)
//                .pressSubmit();
//        System.out.println(sessionIds[0] + " " + sessionIds[1]);
//        kazpostOnboardingPhotosPage.verifyPageOpenedCorrectly()
//                .sendSelfie(sessionIds[0], sessionIds[1])
//        ;
//    }
//

}
