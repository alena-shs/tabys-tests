package api.utils;

import api.models.PhotoBody;

public class BodyConstructors {
    public void preparePhotoBody(String documentType, String src, String title) {
        PhotoBody photoBody = new PhotoBody();
        photoBody.setDocumentType(documentType);
        photoBody.setExtension("jpeg");
        photoBody.setIsLast(true);
        photoBody.setSrc(src);
        photoBody.setTitle(title);
        photoBody.setType("image/jpeg");
    }
}
