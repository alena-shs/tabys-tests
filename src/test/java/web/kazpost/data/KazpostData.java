package web.kazpost.data;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static commons.CommonUtils.convertPhotoToSend;

public class KazpostData {
    // TODO: Put all data into a JSON file
//    private ClassLoader cl = KazpostData.class.getClassLoader();
    static DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd.MM.yyyy");
    static LocalDateTime now = LocalDateTime.now();

//    static KazpostUser kazpostUser = gson.fromJson("src/test/resources/userdata/AlenaShomanova.json", KazpostUser.class);
//    InputStream is = cl.getResourceAsStream("minun-pokemon.json");
//    InputStreamReader isr = new InputStreamReader(is) {
//        {
//            try {
//                kazpostUser = mapper.readValue(isr, KazpostUser.class);
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    };

    public static String phoneNumberTemplate = "+72220";
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
            defaultIssueMonth = String.format("%02d", (Integer.parseInt(monthToday)-1)),
            defaultIssueYear = "2001",
            defaultExpirationDay = "1",
            defaultExpirationMonth = String.format("%02d", (Integer.parseInt(monthToday)+1)),
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
    static String[] sessionIds = new String[2];
    public static String ggToken = sessionIds[0], sessionId = sessionIds[1];
    public static String selfieDefaultEncoded = convertPhotoToSend(selfieDefaultSrc);
}
