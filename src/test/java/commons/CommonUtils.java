package commons;

import commons.api.models.PhotoBody;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;

import java.io.File;
import java.io.IOException;
import java.util.Base64;
import java.util.List;
import java.util.Objects;

import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.fail;

public class CommonUtils {
    public String formatMonth(String month){
        if (Objects.equals(month, "00")) {
            month = "12";
        } else if (Objects.equals(month, "13")) {
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
        return Base64.getEncoder().encodeToString(fileContent);
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
