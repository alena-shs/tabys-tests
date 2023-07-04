package tests;

import api.models.PhotoBody;
import database.AcsDatabaseConnections;
import objects.kazpost.KazpostLoginPage;
import objects.kazpost.KazpostOnboardingPersonalDataPage;
import objects.kazpost.KazpostOnboardingPhotosPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Tags;
import org.junit.jupiter.api.Test;

import static helpers.OnboardingUtils.getNewPhoneNumber;
import static testdata.KazpostData.*;

@Tags({
        @Tag("kazpost"),
        @Tag("onboarding-migration")})
public class KazpostTests extends TestBase{
    KazpostLoginPage kazpostLoginPage = new KazpostLoginPage();
    public static PhotoBody photoBody = new PhotoBody();
    KazpostOnboardingPersonalDataPage kazpostOnboardingPersonalDataPage = new KazpostOnboardingPersonalDataPage();
    KazpostOnboardingPhotosPage kazpostOnboardingPhotosPage = new KazpostOnboardingPhotosPage();
    static AcsDatabaseConnections acsDatabase = new AcsDatabaseConnections();

//    KazpostUtils dateUtils = new KazpostUtils();

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
        kazpostOnboardingPhotosPage.verifyPageOpenedCorrectly()
//                .sendSelfie(sessionIds[0], sessionIds[1])
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
//    public static void preparePhotoBody(String documentType, String src, String title) {
//        photoBody.setDocumentType(documentType);
//        photoBody.setExtension("jpeg");
//        photoBody.setIsLast(true);
//        photoBody.setSrc(src);
//        photoBody.setTitle(title);
//        photoBody.setType("image/jpeg");
//    }
}
