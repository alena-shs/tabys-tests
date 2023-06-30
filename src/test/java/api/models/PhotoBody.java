package api.models;

import lombok.Data;

@Data
public class PhotoBody {
    String documentType, extension, fileId, src, title, type;
    Boolean isLast;
}
