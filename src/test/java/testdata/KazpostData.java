package testdata;

import helpers.KazpostUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class KazpostData {
    // TODO: Put all data into a JSON file
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static LocalDateTime now = LocalDateTime.now();
    public static String phoneNumber = "+72220000913";
    public static String firstName = "АЛЕНА",
            lastName="ШОМАНОВА",
            iin = "980113450119",
            citizenship="Казахстан",
            dateOfBirth="01/12/1998",
            city="Astana",
            address="Mangilik Yel",
            sourceOfIncome = "Зарплата",
            defaultIdNum="010190392";
    public static String fullDateToday = dtf.format(now),
            monthToday = fullDateToday.split("\\.")[1],
            defaultIssueDay = "1",
            defaultIssueMonth = String.format("%02d", (Integer.valueOf(monthToday)-1)),
            defaultIssueYear = "2001",
            defaultExpirationDay = "1",
            defaultExpirationMonth = String.format("%02d", (Integer.valueOf(monthToday)+1)),
            defaultExpirationYear = "2030";
    public static Boolean isPep = false;
    public static String selfieDocType = "SELFIE",
            selfieDefaultSrc = "src/test/resources/images/KazpostSelfie.jpg",
            selfieTitle = "Selfie_camera";
    public static String idFrontDocType = "SELFIE",
            idFrontDefaultSrc = "src/test/resources/images/KazpostSelfie.jpg",
            idFrontTitle = "Selfie_camera";
    public static String idBackDocType = "SELFIE",
            idBackDefaultSrc = "src/test/resources/images/KazpostSelfie.jpg",
            idBackTitle = "Selfie_camera";
    public static String[] sessionIds = new String[2];
    public static String selfieDefaultEncoded = KazpostUtils.convertPhotoToSend(selfieDefaultSrc);
}
