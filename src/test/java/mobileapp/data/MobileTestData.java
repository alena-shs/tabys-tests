package mobileapp.data;

import static commons.CommonUtils.convertPhotoToSend;

public class MobileTestData {
    public static String phoneNumberTemplateMobile = "+74440",
            defaultEmail = "testtabys@gmail.com",
            defaultPassword = "AutoTest123!",
            defaultPinCode = "1111";
    public static String defaultIin = "010111500830",
            defaultIncomeSource = "Salary";
    public static String selfieDocType = "SELFIE",
            selfieDefaultSrc = "src/test/resources/images/tabys-photo.jpeg",
            selfieDefaultEncoded = convertPhotoToSend(selfieDefaultSrc),
            selfieTitle = "Document";
    //    public static String idFrontDocType = "SELFIE",
//            idFrontDefaultSrc = "src/test/resources/images/KazpostSelfie.jpg",
//            idFrontTitle = "Selfie_camera";
//    public static String idBackDocType = "SELFIE",
//            idBackDefaultSrc = "src/test/resources/images/KazpostSelfie.jpg",
//            idBackTitle = "Selfie_camera";
    Integer defaultWaitingOfSeconds = 25;
    static String[] sessionIds = new String[2];
    public static String ggTokenMobile = sessionIds[0], sessionIdMobile = sessionIds[1];

}
