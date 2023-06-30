package api.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginResponse {
    Boolean accessGranted, success;
    List errorFields;
    String errorMessage;
    Integer status;
    public List<ListUserDescResponseData> user;

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListUserDescResponseData {
        String accountName, appKey, department, displayName, facsimileTelephoneNumber, guid, mail, mobileSession, name, nin, orgUnitGuid,
                otherTelephone, phoneNumber, physicalDeliveryOfficeName, position, shortCode, surname, tabnum;
        public List<ListLoginRolesResponseData> user;
    }

    @Data
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class ListLoginRolesResponseData {
        List functions;
        String code, name, applicationCode;
    }
}
