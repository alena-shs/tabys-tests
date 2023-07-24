package commons.api.utils;

import commons.api.models.PhotoBody;

public class BodyConstructors {
    public void preparePhotoBody(PhotoBody photoBody, String documentType, String src, String title) {

        photoBody.setDocumentType(documentType);
        photoBody.setExtension("jpeg");
        photoBody.setIsLast(true);
        photoBody.setSrc(src);
        photoBody.setTitle(title);
        photoBody.setType("image/jpeg");
    }
}
