package commons;

import com.codeborne.selenide.SelenideElement;
import commons.api.models.PhotoBody;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.Base64;

public class CommonUtils {
    public String formatMonth(String month){
        if (month == "00") {
            month = "12";
        } else if (month == "13") {
            month = "01";
        }
        return month;
    }

    public static String convertPhotoToSend(String src){
        byte[] fileContent = new byte[0];
        try {
            fileContent = FileUtils.readFileToByteArray(new File(src));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        String encodedSrcFile = Base64.getEncoder().encodeToString(fileContent);
        return encodedSrcFile;
    }

    public static void preparePhotoBody(PhotoBody photoBody, String documentType, String src, String title) {
        photoBody.setDocumentType(documentType);
        photoBody.setExtension("jpeg");
        photoBody.setIsLast(true);
        photoBody.setSrc(src);
        photoBody.setTitle(title);
        photoBody.setType("image/jpeg");
    }

}
